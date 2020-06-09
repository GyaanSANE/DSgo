package dataStructures.graph.singleSourceShortestPath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import dataStructures.node.WeightedEdge;
import dataStructures.node.WeightedNode;

public class Dijkstra {
	
	ArrayList <WeightedNode> nodeList;
	PriorityQueue<WeightedNode> pQueue = new PriorityQueue<WeightedNode>(compare);
	
	
	//either use comparator override here, 
	//or implement Comparable and  override compareTo method in weightedNode class
	//and then use pQueue without passing comparator
    public static Comparator<WeightedNode> compare = new Comparator<WeightedNode>() {
	@Override
	public int compare(WeightedNode a, WeightedNode b) {
		return (a.getCost() - b.getCost());
	}
    };
    
	public Dijkstra(ArrayList <WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void dijkstra(WeightedNode src) {
		src.setCost(0);
		src.setParent(null);
		/*for(WeightedEdge edge : src.getEdges()) {
			if(edge.getNode().getCost() > edge.getWeight()) {
				edge.getNode().setCost(edge.getWeight());
				edge.getNode().setParent(src);
				visitNeighbours(edge.getNode());
			}
		}*/
		
		//p queue while not empty
		pQueue.addAll(nodeList);
		while(!pQueue.isEmpty()) {
			WeightedNode node1 = pQueue.poll();
			for(WeightedEdge edge : node1.getEdges()) {
				if(edge.getNode().getCost() > edge.getWeight()+node1.getCost()) {
					edge.getNode().setCost(edge.getWeight()+node1.getCost());
					edge.getNode().setParent(node1);
				//if weight changes, remove from queue and add again to refresh
					pQueue.remove(edge.getNode());
					pQueue.add(edge.getNode());
			}
		}}
		
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

	/*private void visitNeighbours(WeightedNode curr) {
		for(WeightedEdge edge : curr.getEdges()) {
			if(edge.getNode().getCost() > (curr.getCost() + edge.getWeight())) {
				edge.getNode().setCost(curr.getCost() + edge.getWeight());
				edge.getNode().setParent(curr);
				visitNeighbours(edge.getNode());
			}
		}
	}*/



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
