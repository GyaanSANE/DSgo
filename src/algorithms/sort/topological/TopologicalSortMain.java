package algorithms.sort.topological;

import java.util.ArrayList;

import dataStructures.node.GraphNode;

public class TopologicalSortMain {
	public static void main(String[] args) {
		
		ArrayList<GraphNode> nodeList = new ArrayList<>();
		
		for(int i=0;i<8;i++) {
			GraphNode node = new GraphNode(((char)(65+i))+"");
			nodeList.add(node);
		}
		
		TopologicalSort graph = new TopologicalSort(nodeList);
		graph.addDirectedEdge(0, 2);
		graph.addDirectedEdge(1, 2);
		graph.addDirectedEdge(1, 3);
		graph.addDirectedEdge(2, 4);
		graph.addDirectedEdge(4, 7);
		graph.addDirectedEdge(4, 5);
		graph.addDirectedEdge(5, 6);
		graph.addDirectedEdge(3, 5);
		
		graph.topologicalSort();
	}

}
