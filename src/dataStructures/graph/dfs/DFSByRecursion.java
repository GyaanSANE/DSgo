package dataStructures.graph.dfs;

import java.util.ArrayList;

import dataStructures.node.GraphNode;

public class DFSByRecursion {
	ArrayList<GraphNode> nodeList;
	
	public DFSByRecursion(ArrayList<GraphNode> nodeList) {
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
			node.setVisited(true);
			System.out.print(node.getName()+" ");
			for(GraphNode neighbour : node.getNeighbours()) {
				if(!neighbour.isVisited()) {
					visit(neighbour);
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
