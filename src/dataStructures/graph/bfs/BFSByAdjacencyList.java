package dataStructures.graph.bfs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.node.GraphNode;

public class BFSByAdjacencyList {
	
	ArrayList<GraphNode> nodeList;
	
	public BFSByAdjacencyList(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void bfs() {
		for(GraphNode node : nodeList) {
			if(!node.isVisited()) {
				visit(node);
			}
		}
	}
	
	private void visit(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			curr.setVisited(true);
			System.out.print(curr.getName()+" ");
			for(GraphNode neighbour : curr.getNeighbours()) {
				if(!neighbour.isVisited()) {
					queue.add(neighbour);
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
