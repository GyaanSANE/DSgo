package dataStructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import dataStructures.node.GraphNode;

public class BFSByAdjacencyMatrix {

	private ArrayList<GraphNode> nodeList = new ArrayList<>(); //java 7+ allows diamond operator <> to avoid typing GraphNode again
	private int [][] adjacecnyMatrix;
	
	public BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacecnyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	
	//bfs
	public void bfs() {
		for(GraphNode node:nodeList) {
			if(node.isVisited()==false) {
				visit(node);
			}
		}
	}
	
	//visit
	
	
	
	private void visit(GraphNode node) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode curr = queue.remove();
			if(!curr.isVisited()) {
				System.out.print(curr.getName() +" ");
				curr.setVisited(true);
				queue.addAll(getNeighbours(curr));
			}
		}	
	}

	//get Neighbours
	private ArrayList<GraphNode> getNeighbours(GraphNode node){
		int nodeIndex = node.getIndex();
		ArrayList<GraphNode> neighbours = new ArrayList<>();
		for(int i =0;i<nodeList.size();i++) {
			if(adjacecnyMatrix[nodeIndex][i] == 1) {
				neighbours.add(nodeList.get(i));
			}
		}
		return neighbours;
	}
	
	//addUndirectedEdge
	public void addUndirectedEdge(int i,int j) { //nodes i,j
		i--;
		j--; //to get array index for matrix
		adjacecnyMatrix[i][j] = 1;
	}
	
	
	
	
	
	
	
	
}
