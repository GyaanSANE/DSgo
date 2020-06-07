package algorithms.sort.topological;

import java.util.ArrayList;
import java.util.Stack;

import dataStructures.node.GraphNode;

public class TopologicalSort {
	
	ArrayList<GraphNode> nodeList;
	Stack<GraphNode> stack = new Stack<>();

	public TopologicalSort(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void topologicalSort() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited()) {
				visit(node);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop().getName()+" ");
		}
	}
	
	private void visit(GraphNode node) {
		for(GraphNode neighbour : node.getNeighbours()) {
			if(!neighbour.isVisited()) {
				neighbour.setVisited(true);
				visit(neighbour);
			}
		}
		stack.push(node);
		
	}

	public void addDirectedEdge(int from, int to) {
		//from--;
		//to--;
		nodeList.get(from).getNeighbours().add(nodeList.get(to));
	}
}
