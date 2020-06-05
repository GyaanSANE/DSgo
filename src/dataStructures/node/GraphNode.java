package dataStructures.node;

import java.util.ArrayList;

public class GraphNode {

	private String name;
	private int index;
	private ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
	private int weight;
	private boolean isVisited;
	private GraphNode parent;
	
	public GraphNode(String name, int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public ArrayList<GraphNode> getNeighbours() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<GraphNode> neighbours) {
		this.neighbours = neighbours;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public boolean isVisited() {
		return isVisited;
	}
	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}
	public GraphNode getParent() {
		return parent;
	}
	public void setParent(GraphNode parent) {
		this.parent = parent;
	}
		
}
