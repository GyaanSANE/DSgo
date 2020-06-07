package dataStructures.graph.dfs;

import java.util.ArrayList;
import java.util.Stack;

import dataStructures.node.GraphNode;

public class DFSByIteration {
	
	ArrayList<GraphNode> nodeList;
	Stack<GraphNode> stack = new Stack<>();

	public DFSByIteration(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	
	
	public void dfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited()) {
				visit(node);
			}
		}
		
	}	
	
	private void visit(GraphNode node) {
		stack.push(node);
		while(!stack.isEmpty()) {
			GraphNode curr = stack.pop();
			curr.setVisited(true);
			System.out.print(curr.getName()+" ");
			for(GraphNode neighbour : curr.getNeighbours()) {
				if(!neighbour.isVisited()) {
					stack.push(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}



	public void addUndirectedEdge(int i,int j) {
		i--;
		j--;
		nodeList.get(i).getNeighbours().add(nodeList.get(j));
		nodeList.get(j).getNeighbours().add(nodeList.get(i));
	}
}
