package com.sprphnx.hakerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelFun {

	
	public static void main(String[] args) {
		System.out.println(findDirectRoutes());
	}
	
	private static Map<Integer, ArrayList<Integer>> findDirectRoutes() {
		Integer numberOfCities = 6;
		Integer[] originArray = {1,2,3};
		Integer[] destinationArray = {4,5,6};
		Integer threshold = 2;

		List<Integer> originList = Arrays.asList(originArray);
		List<Integer> destinationList = Arrays.asList(destinationArray);
		
		Map<Integer, ArrayList<Integer>> directRouteMaps = new HashMap<>();
		
		for (Integer origin : originList) {
			ArrayList<Integer> directDestinationList = new ArrayList<>();
			directRouteMaps.put(origin, directDestinationList);
			
			for (Integer destination : destinationList) {
				if(findGCD(origin, destination)>threshold) {
					directDestinationList.add(destination);
				}
			}

		}
		
		return directRouteMaps;
	}
	
	private static int findGCD(int number1, int number2) {
        if(number2 == 0){
            return number1;
        }
        return findGCD(number2, number1%number2);
    }

}
