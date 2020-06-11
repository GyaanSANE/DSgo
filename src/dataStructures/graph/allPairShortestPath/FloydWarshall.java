package dataStructures.graph.allPairShortestPath;

import java.util.ArrayList;

import dataStructures.node.WeightedNode;

public class FloydWarshall {
	//matrix based solution for ALL Source shortest path
	//thus ignoring use of edge, weight variables in weighted node object and directly using a matrix to store edges, weights
	
	private ArrayList<WeightedNode> nodeList;
	private int[][] V; //VxV matrix
	private int size;
	
	public FloydWarshall(ArrayList<WeightedNode> nodeList) {
		this.nodeList=nodeList;
		size = nodeList.size();
		V = new int [size][size];
		for(int i =0;i<size;i++) {
			for(int j =0;j<size;j++) {
				if(i==j) {
					V[i][j] =0;
				}else {
					V[i][j] = Integer.MAX_VALUE/10;
				}
			}
		}
		
	}
	
	public void floydWarshall() {
		//since matrix is already ready, find best costs and print
		
		//CHANGE: loop(from>via>to) --> loop(via>from>to)
		
		for(int via=0;via<size;via++) {									//k		(intermediate node)
			for(int from=0;from <size;from++) {							//i		(from)
				for(int to =0;to<size;to++) {							//j		(to)
					if(V[from][to] > V[from][via]+V[via][to]) {
						V[from][to] = V[from][via]+V[via][to];			// [i][j] = [i][k] + [k][j]
					}
				}
			}
				
		}
		
		for(int i=0;i<size;i++) {
			System.out.print("Cost from "+nodeList.get(i).getName()+": ");
			for(int j=0;j<size;j++) {
				System.out.print(nodeList.get(j).getName()+"~"+V[i][j]+", ");
			}
			System.out.println();
		}
		
	}
	
	public void addWeightedEdge(int from,int to, int w) {
		from--;
		to--;
		V[from][to] = w;
	}
	
}
