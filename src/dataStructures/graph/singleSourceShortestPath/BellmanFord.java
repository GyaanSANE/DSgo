package dataStructures.graph.singleSourceShortestPath;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class BellmanFord {
	
	ArrayList<WeightedNode2> nodeList;
	
	public BellmanFord(ArrayList<WeightedNode2> nodeList) {
		this.nodeList = nodeList;
	}

	public void bellmanFord(WeightedNode2 src) {
		src.setCost(0);
		src.setParent(null);
		//for n-1 times, for each node , for each neighbour, if cost is better- update cost and parent
		for(int i=1;i<nodeList.size();i++) {
			for(WeightedNode2 node:nodeList) {
				for(WeightedNode2 neighbour : node.getNeighbours()) {
					if(neighbour.getCost() > node.getEdges().get(neighbour)+node.getCost()) {
						neighbour.setCost(node.getEdges().get(neighbour)+node.getCost());
						neighbour.setParent(node);
					}
				}
			}
		}
		//checking for negative cycle
		for(WeightedNode2 node:nodeList) {
			for(WeightedNode2 neighbour : node.getNeighbours()) {
				if(neighbour.getCost() > node.getEdges().get(neighbour)+node.getCost()) {
					System.out.println("Negative Cycle Found!");
					System.out.print("Node: "+neighbour.getName());
					return;
				}
			}
		}
		for(WeightedNode2 node:nodeList) {
			System.out.print("Path for "+node.getName()+": (Cost: "+node.getCost()+"): ");
			printPath(node);
			System.out.println();
		}	
	}
	
	private void printPath(WeightedNode2 node) {
		if(node.getParent()!= null) {
			printPath(node.getParent());
		}
		System.out.print(node.getName()+" ");
	}

	public void addWeightedEdge(int from, int to, int weight) {
		from--;
		to--;
		nodeList.get(from).getNeighbours().add(nodeList.get(to));
		nodeList.get(from).getEdges().put(nodeList.get(to), weight);
		
	}
	
	
}
