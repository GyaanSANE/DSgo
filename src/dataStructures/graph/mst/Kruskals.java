package dataStructures.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import dataStructures.node.WeightedNode2;
//undirectedEdge from same package
public class Kruskals {
	
	private ArrayList<WeightedNode2> nodeList;
	private ArrayList<UndirectedEdge> edges = new ArrayList<>();
	
	public Kruskals(ArrayList<WeightedNode2> nodeList) {
		this.nodeList = nodeList;
	}
	
	//comparator edges
	public static Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
		@Override
		public int compare(UndirectedEdge a, UndirectedEdge b) {
			return(a.getWeight()-b.getWeight());
		}
	};
	
	
	public void kruskals() {
		DisjointSet.makeSet(nodeList);
		Collections.sort(edges, comparator);
		int cost=0;
		for(UndirectedEdge edge : edges) {
			if(edge.getFirst().getSet() != edge.getSecond().getSet()) {
				DisjointSet.union(edge.getFirst(), edge.getSecond());
				cost+= edge.getWeight();
				System.out.println("Edge taken ("+edge.getFirst()+","+edge.getSecond()+") Weight = "+edge.getWeight());
			}
		}
		System.out.println();
		System.out.println("Cost of MST: "+cost);
	}
	
	
	public void addUndirectedEdge(int index1, int index2, int weight) {
		WeightedNode2 first = nodeList.get(index1-1);
		WeightedNode2 second = nodeList.get(index2-1);
		UndirectedEdge edge = new UndirectedEdge(first, second, weight);
		edges.add(edge);
		first.getNeighbours().add(second);
		second.getNeighbours().add(first);
	}
	

}
