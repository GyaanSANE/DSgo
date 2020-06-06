package dataStructures.graph.singleSourceShortestPath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.node.GraphNode;

public class PathFindByBFS {
	
	ArrayList<GraphNode> nodeList;
	
	public PathFindByBFS(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void SSSPByBFS(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			curr.setVisited(true);
			System.out.print("Path for node "+curr.getName()+": ");
			printPath(curr);
			System.out.println();
			ArrayList<GraphNode> neighbours = curr.getNeighbours();
			for(GraphNode neighbour: neighbours) {
				if(!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setParent(curr);
					neighbour.setVisited(true);
				}
			}
			
		}
	}
	
	private void printPath(GraphNode node) {
		if(node.getParent()!=null) {
			printPath(node.getParent());
		}
		System.out.print(node.getName()+" ");
	}

	public void addUndirectedEdge(int i,int j) {
		nodeList.get(i).getNeighbours().add(nodeList.get(j));
		nodeList.get(j).getNeighbours().add(nodeList.get(i));
	}
	
	
}
