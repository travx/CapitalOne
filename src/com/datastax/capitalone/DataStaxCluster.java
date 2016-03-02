package com.datastax.capitalone;

import java.util.ArrayList;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.Cluster.Builder;

public class DataStaxCluster {
	private String[] nodes;
	private String keyspace;
	private Cluster cluster;
	private Session session;
	
	private StatsFutureSet futures;
	
	//Debugging
	private boolean debug=false;

	//Prepared Statements
	private PreparedStatement psWriteLocation;
	
	//Statements
	private Statement sGetZips;
	private Statement sGetSearches;
	private Statement sGetAllVINs;
	
	public DataStaxCluster(String[] nodes, String keyspace, boolean debug){
		this(nodes, keyspace);
		this.debug = debug;
	}
	
	public DataStaxCluster(String[] nodes, String keyspace){
		this.setNodes(nodes);
		this.setKeyspace(keyspace);
		
		futures = new StatsFutureSet(20, 100000, 100000);
		
		connect();
		prepare();
	}
	
	public void printStats(){
		futures.printStats();
	}
	
	private void connect(){
		Builder builder = Cluster.builder();
		builder.addContactPoints(nodes);
		cluster = builder.build();
		cluster.getConfiguration().getSocketOptions().setReadTimeoutMillis(100000);
		//cluster.getConfiguration().getPoolingOptions().s
		cluster.getConfiguration().getQueryOptions().setConsistencyLevel(ConsistencyLevel.ONE);
		session = cluster.connect(keyspace);		
	}
	
	private void prepare(){
		psWriteLocation = session.prepare("insert into vehicle(vin, city, state, lat_lon) values(?, ?, ?, ?)");
		sGetZips = session.prepare("select * from zips").bind();
		sGetSearches = session.prepare("select * from searches").bind();
		sGetAllVINs = session.prepare("select vin from vehicle").bind();
	}
	
	public void vehicleSearch(String filterquery, String searchname){
		//select * from capitalone.vehicle where solr_query='{"q":"*:*","fq":"city:WOBURN AND yeartxt:1996"}' limit 100;
		String search = "'{\"q\":\"*:*\",\"fq\":\"" + filterquery + "\"}'";
		String statement = "select * from vehicle where solr_query = " + search + " limit 100";
		if (debug) System.out.println(statement);
		//futures.add(session.executeAsync(statement), searchname);
		execQuery(statement, searchname);
	}
	
	public void geoSearch(String lat_lon){
		//select * from vehicle where solr_query = '{"q": "*:*", "fq": "{!geofilt sfield=lat_lon pt=44.48,-73.22 d=1}"}';
		String search = "'{\"q\": \"*:*\", \"fq\": \"{!geofilt sfield=lat_lon pt=" + lat_lon +" d=1}\"}'";
		String statement = "select * from vehicle where solr_query = " + search + " limit 100";
		if (debug) System.out.println(statement);
		//futures.add(session.executeAsync(statement), "geospatial");
		execQuery(statement, "geospatial");
	}
	
	public void vehicleGeoSearch(String filterquery, String lat_lon, String searchname){
		//select * from vehicle where solr_query = '{"q": "*:*", "fq": "{!geofilt sfield=lat_lon pt=44.48,-73.22 d=1}"}';
		String search = "'{\"q\": \"*:*\", \"fq\":\"" + filterquery + " AND {!geofilt sfield=lat_lon pt=" + lat_lon +" d=1}\"}'";
		String statement = "select * from vehicle where solr_query = " + search + " limit 100";
		if (debug) System.out.println(statement);
		//futures.add(session.executeAsync(statement), searchname);
		execQuery(statement, searchname);
	}
	
	private void execQuery(String statement, String description){
		//For debugging only
		//long start = System.currentTimeMillis();
		//ResultSet results = session.execute(statement);
		//futures.getFutureAction().onSuccess(results, description, start);
		futures.add(session.executeAsync(statement), description);
	}

	public void writeLocation(String vin, String city, String state, String lat_lon){
		futures.add(session.executeAsync(psWriteLocation.bind(vin, city, state, lat_lon)), "Update Location");
	}
	
	public ArrayList<Search> getSearches(){
		ArrayList<Search> searches = new ArrayList<Search>();
		ResultSet results = session.execute(sGetSearches);
		
		for (Row row: results){
			searches.add(new Search(row.getString("search_field"), "(" + row.getString("search_value") + ")"));
		}
		
		return searches;
	}
	
	public ArrayList<Zip> getZips(){
		ArrayList<Zip> zipcodes = new ArrayList<Zip>();
		ResultSet results = session.execute(sGetZips);
		
		for (Row row: results){
			zipcodes.add(new Zip(row));
		}
		
		return zipcodes;
	}
	
	public ArrayList<String> getAllVINs(){
		ArrayList<String> vins = new ArrayList<String>();
		ResultSet results = session.execute(sGetAllVINs);
		
		for (Row row: results){
			vins.add(row.getString("vin"));
		}
		
		return vins;
	}	
	
	public String[] getNodes() {
		return nodes;
	}

	public void setNodes(String[] nodes) {
		this.nodes = nodes;
	}

	public String getKeyspace() {
		return keyspace;
	}

	public void setKeyspace(String keyspace) {
		this.keyspace = keyspace;
	}

	public Cluster getCluster() {
		return cluster;
	}

	public void setCluster(Cluster cluster) {
		this.cluster = cluster;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}	
}
