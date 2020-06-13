package dataStructures.graph.mst;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class KruskalsMain {
	public static void main(String[] args) {
		ArrayList<WeightedNode2> nodeList = new ArrayList<>();
		
		//create 10 nodes: v1-v10
		for(int i=0;i<5; i++) {
			nodeList.add(new WeightedNode2(""+(char)(65+i)));
		}
		Kruskals graph = new Kruskals(nodeList);
		//add weighted edges following graph in graph.docx
		
		//Add A<-> B , weight 10
		graph.addUndirectedEdge(1,2,10);
		
		//Add A<-> C , weight 20
		graph.addUndirectedEdge(1,3,20);
		
		graph.addUndirectedEdge(2,3,30);
		
		graph.addUndirectedEdge(2,4,5);
		
		graph.addUndirectedEdge(3,4,15);
		graph.addUndirectedEdge(3,5,6);
		
		graph.addUndirectedEdge(4,5,8);
		
		
		//run kruskal on graph
		System.out.println("Running Kruskal's Algo on the graph: ");
		graph.kruskals();
	}

}
