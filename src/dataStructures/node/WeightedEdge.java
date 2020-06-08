package dataStructures.node;

public class WeightedEdge {
	WeightedNode node; //destination node
	int weight;
	
	public WeightedEdge(WeightedNode node, int weight) {
		this.node = node;
		this.weight = weight;
	}
	
	public WeightedNode getNode() {
		return node;
	}
	public void setNode(WeightedNode node) {
		this.node = node;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}

}
