package dataStructures.graph.singleSourceShortestPath;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class BellmanFordMain {
public static void main(String[] args) {
		
		ArrayList<WeightedNode2> nodeList = new ArrayList<>();
		
		//create 5 nodes: A,B,C,D,E
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode2(""+(char)(65+i)));
		}
		
		//Constructor
		BellmanFord graph = new BellmanFord(nodeList);
		
		graph.addWeightedEdge(1,3,6); //Add A-> C , weight 6
		graph.addWeightedEdge(2,1,3); //Add B-> A , weight 3
		graph.addWeightedEdge(1,4,6); //Add A-> D , weight 6
		//graph.addWeightedEdge(1,4,-6); //Add A-> D , weight -6 TEST NEGATIVE WEIGHT HERE
		graph.addWeightedEdge(4,3,1); //Add D-> C , weight 1
		graph.addWeightedEdge(3,4,2); //Add C-> D , weight 2
		graph.addWeightedEdge(4,2,1); //Add D-> B , weight 1
		graph.addWeightedEdge(5,4,2); //Add E-> D , weight 2
		graph.addWeightedEdge(5,2,4); //Add E-> B , weight 4
		
		//System.out.println(graph.nodeList.get(4).getEdges());
		
		graph.bellmanFord(nodeList.get(4));
		
	}//end of method



}
