package com.sprphnx.hakerrank;

public class DrawingEdge {

	public static void main(String[] args) {

		System.out.println(findNumberOfGraphs(4));
	}

	//2^(N*(N-1)/2)
	private static double findNumberOfGraphs(Integer vertices) {
		
		Integer power = (vertices*(vertices-1)/2); 
		return Math.pow(2D, power);

	}
	
}
