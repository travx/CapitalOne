package com.datastax.capitalone;

import java.util.ArrayList;
import java.util.Random;

public class SetLocations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataStaxCluster dse = new DataStaxCluster(new String[]{"node0", "node1", "node2"}, "capitalone");
		
		//Random numbers
		Random r = new Random();
		
		//List of possible zipcodes
		ArrayList<Zip> zips = dse.getZips();
		
		//Get all vins
		ArrayList<String> vins = dse.getAllVINs();
		
		//For each vin, update the city, state, and lat_lon
		for (int i=0; i<vins.size(); i++){
			Zip z = zips.get(r.nextInt(zips.size()));
			dse.writeLocation(vins.get(i), z.getCity(), z.getState(), z.getLat_lon());
		}
		
	}

}
