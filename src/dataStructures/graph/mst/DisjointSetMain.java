package dataStructures.graph.mst;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class DisjointSetMain {

public static void main(String[] args) {
		
		ArrayList<WeightedNode2> nodeList = new ArrayList<>();

		// create 10 nodes: 1-10
		for (int i = 0; i < 10; i++) {
			nodeList.add(new WeightedNode2("" + (char) (65 + i)));
		}

		// Calling DisjointSet
		DisjointSet.driver(nodeList);

	}// end of method
}
