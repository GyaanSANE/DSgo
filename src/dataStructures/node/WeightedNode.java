package dataStructures.node;

import java.util.ArrayList;

public class WeightedNode {
//public class WeightedNode implements Comparable<WeightedNode>{ //use this to instead of comparator for PriorityQueue in dijkstra
	String name;
	ArrayList <WeightedEdge> edges = new ArrayList<>();
	int cost = Integer.MAX_VALUE/10; //reducing because Integer will cycle to -21474836... when we add anything to Int.max
	boolean visited;
	WeightedNode parent;
	public WeightedNode(String name) {
		this.name = name;
	}
	
	/*@Override   //use this to instead of comparator for PriorityQueue in dijkstra
	public int compareTo(WeightedNode o) {
		return this.cost - o.cost;
	}*/
	
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
