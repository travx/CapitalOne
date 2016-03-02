package com.datastax.capitalone;

import java.util.ArrayList;
import java.util.Random;

public class SearchTest {
	
	//Arguments - number of minutes to run. Defaults to one hour
	private static int MINUTES = 60;
	

	public static void main(String[] args) throws InterruptedException {
		// Cluster Connection
		DataStaxCluster dse = new DataStaxCluster(new String[]{"node0", "node1", "node2"}, "capitalone");
		
		if (args.length > 0){
			MINUTES = Integer.parseInt(args[0]);
		}
		
		//List of possible zipcodes
		System.out.println("Loading location data");
		ArrayList<Zip> zips = dse.getZips();
		
		//List of possible searches
		System.out.println("Loading search data");
		ArrayList<Search> searches = dse.getSearches();
		
		//Random generator (for getting a random zip code)
		Random r = new Random();
		
		long endTime = System.currentTimeMillis() + (MINUTES * 60000);
		
		System.out.println("Executing searches");
		
		while (System.currentTimeMillis() < endTime){
			//get random city, state, lat_lon for search
			Zip z = zips.get(r.nextInt(zips.size()));
			String citystate = "city:(" + z.getCity() + ") AND state:(\\\\" + z.getState() + ")";
			
			//get random search parameter
			Search s = searches.get(r.nextInt(searches.size()));
			String filterquery = s.getKey() + ":" + s.getValue();
			
			//Search by random parameter
			dse.vehicleSearch(filterquery, s.getKey());
			
			//Search by city, state
			dse.vehicleSearch(citystate, "city-state");
			
			//Search by city, state, parameter
			dse.vehicleSearch(citystate + " AND " + filterquery, "city-state-" + s.getKey());
			
			//Search by geo
			dse.geoSearch(z.getLat_lon());
			
			//Search by parameter-geo
			dse.vehicleGeoSearch(filterquery, z.getLat_lon(), s.getKey() + " + geospatial");
			
			//Search by more random parameters
			for (int i=0; i<3; i++){
				filterquery = addSearch(filterquery, searches.get(r.nextInt(searches.size())));
				dse.vehicleSearch(filterquery, "multi-parameter");
			}
		}
		
		//finish
		System.out.println("Test complete.");
		//Wait 10 seconds for pending callbacks to complete.
		Thread.sleep(10000);
		dse.printStats();
		System.exit(0);
		
	}
	
	private static String addSearch(String searchstring, Search s){
		if (!searchstring.contains(s.getKey())){
			searchstring = searchstring + " AND " + s.getKey() + ":" + s.getValue();
		}
		return searchstring;
	}

}
