package dataStructures.node;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode2 {
	String name;
	ArrayList <WeightedNode2> neighbours = new ArrayList<>();
	HashMap < WeightedNode2 , Integer > edges = new HashMap<>();
	int cost = Integer.MAX_VALUE/10; //reducing because Integer will cycle to -21474836... when we add anything to Int.max
	boolean visited;
	WeightedNode2 parent;
	public WeightedNode2(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<WeightedNode2> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<WeightedNode2> neighbours) {
		this.neighbours = neighbours;
	}
	public HashMap<WeightedNode2, Integer> getEdges() {
		return edges;
	}
	public void setEdges(HashMap<WeightedNode2, Integer> edges) {
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
	public WeightedNode2 getParent() {
		return parent;
	}
	public void setParent(WeightedNode2 parent) {
		this.parent = parent;
	}

}
