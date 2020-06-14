package dataStructures.graph.mst;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class PrimsMain {
	public static void main(String[] args) {
		ArrayList<WeightedNode2> nodeList = new ArrayList<>();
		
		//Create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode2(""+(char)(65+i)));
		}
		
		Prims graph = new Prims(nodeList);
		graph.addUndirectedEdge(1,2,10); //Add undirected Edge between A-B with Weight 10
		graph.addUndirectedEdge(1,3,20); //Add undirected Edge between A-C with Weight 20
		graph.addUndirectedEdge(2,3,30); //Add undirected Edge between B-C with Weight 30
		graph.addUndirectedEdge(2,4,5);  //Add undirected Edge between B-D with Weight 5
		graph.addUndirectedEdge(3,4,15); //Add undirected Edge between C-D with Weight 15
		graph.addUndirectedEdge(3,5,6);  //Add undirected Edge between C-E with Weight 6
		graph.addUndirectedEdge(4,5,8);  //Add undirected Edge between D-E with Weight 8
		
		System.out.println("Printing Prim's Algo from source: E");
		graph.prims(nodeList.get(4));
		
	}//end of method

}
