package dataStructures.graph.singleSourceShortestPath;

import java.util.ArrayList;

import dataStructures.node.WeightedEdge;
import dataStructures.node.WeightedNode;

public class Dijkstra {
	
	ArrayList <WeightedNode> nodeList= new ArrayList<>();
	
	public Dijkstra(ArrayList <WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void dijkstra(WeightedNode src) {
		src.setCost(0);
		src.setParent(null);
		for(WeightedEdge edge : src.getEdges()) {
			if(edge.getNode().getCost() > edge.getWeight()) {
				edge.getNode().setCost(edge.getWeight());
				edge.getNode().setParent(src);
				visitNeighbours(edge.getNode());
			}
		}
		for(WeightedNode node : nodeList) {
			if(node == src) {
				System.out.print("Path for "+src.getName()+": ");
				System.out.println("(Cost: "+node.getCost()+") "+src.getName());
				
			}else {
				System.out.print("Path for "+node.getName()+": ");
				System.out.print("(Cost: "+node.getCost()+") ");
				printPath(node);
				System.out.println();
			}
		}
	}

	private void visitNeighbours(WeightedNode curr) {
		for(WeightedEdge edge : curr.getEdges()) {
			if(edge.getNode().getCost() > (curr.getCost() + edge.getWeight())) {
				edge.getNode().setCost(curr.getCost() + edge.getWeight());
				edge.getNode().setParent(curr);
				visitNeighbours(edge.getNode());
			}
		}
	}



	private void printPath(WeightedNode node) {
		if(node.getParent()!=null) {
			printPath(node.getParent());
		} 
			System.out.print(node.getName()+ " ");
		
	}

	public void addWeightedEdge(int from, int to, int weight) {
		from--;
		to--;
		WeightedEdge edge = new WeightedEdge(nodeList.get(to), weight);
		nodeList.get(from).getEdges().add(edge);
	}

}
