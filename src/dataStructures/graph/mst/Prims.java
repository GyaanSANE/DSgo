package dataStructures.graph.mst;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import dataStructures.node.WeightedNode2;
public class Prims {
	
	ArrayList<WeightedNode2> nodeList;
	PriorityQueue<WeightedNode2> queue;
	WeightedNode2 nodeZero;
	
	public Prims(ArrayList<WeightedNode2> nodeList) {
		this.nodeList = nodeList;
	}
	Comparator<WeightedNode2> comparator = new Comparator<WeightedNode2>() {
		@Override
		public int compare(WeightedNode2 a, WeightedNode2 b) {
			return(a.getCost()-b.getCost());
		}
	};
	
	public void prims(WeightedNode2 src) {
		src.setCost(0);
		nodeZero = src;
		queue = new PriorityQueue<>(comparator);
		queue.addAll(nodeList);
		while(!queue.isEmpty()) {
			visit(queue.remove());
		}	
		printMst();
	}
	
	private void visit(WeightedNode2 curr) {
		curr.setVisited(true);
		for(WeightedNode2 node : curr.getNeighbours()) {
			if(!node.isVisited()) {
				//System.out.println(node.getCost());
				//System.out.println(curr.getEdges().get(node));
				if(node.getCost()>curr.getEdges().get(node)) {
					node.setCost(curr.getEdges().get(node));
					node.setParent(curr);
					queue.remove(node);
					queue.add(node);
				}
			}
		}
	}

	private void printMst() {
		nodeList.remove(nodeZero);
		int totalCost=0;
		for(WeightedNode2 node:nodeList) {
			System.out.println("Edge ("+node.getParent()+","+node+"), Weight: "+node.getCost());
			totalCost+=node.getCost();
		}
		System.out.println();
		System.out.println("Cost of MST: "+totalCost);
	}

	public void addUndirectedEdge(int a, int b, int weight) {
		WeightedNode2 first = nodeList.get(a-1);
		WeightedNode2 second = nodeList.get(b-1);
		first.getNeighbours().add(second);
		first.getEdges().put(second, weight);
		second.getNeighbours().add(first);
		second.getEdges().put(first, weight); 
	}
}
