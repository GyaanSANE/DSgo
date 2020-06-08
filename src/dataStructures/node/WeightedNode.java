package dataStructures.node;

import java.util.ArrayList;

public class WeightedNode {
	String name;
	ArrayList <WeightedEdge> edges = new ArrayList<>();
	int cost = Integer.MAX_VALUE;
	boolean visited;
	WeightedNode parent;
	public WeightedNode(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<WeightedEdge> getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<WeightedEdge> edges) {
		this.edges = edges;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public WeightedNode getParent() {
		return parent;
	}
	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}
	
	
}
