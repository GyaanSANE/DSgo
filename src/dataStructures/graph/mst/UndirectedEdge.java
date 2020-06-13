package dataStructures.graph.mst;

import dataStructures.node.WeightedNode2;

public class UndirectedEdge {

	private WeightedNode2 first;
	private WeightedNode2 second;
	private int weight;
	
	public UndirectedEdge(WeightedNode2 first, WeightedNode2 second, int weight) {
		this.first = first;
		this.second = second;
		this.weight = weight;
	}
	public WeightedNode2 getFirst() {
		return first;
	}
	public void setFirst(WeightedNode2 first) {
		this.first = first;
	}
	public WeightedNode2 getSecond() {
		return second;
	}
	public void setSecond(WeightedNode2 second) {
		this.second = second;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
