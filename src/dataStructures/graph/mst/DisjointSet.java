package dataStructures.graph.mst;

import java.util.ArrayList;

import dataStructures.node.WeightedNode2;

public class DisjointSet {

	ArrayList<WeightedNode2> nodes = new ArrayList<>();
	
	public static void driver(ArrayList<WeightedNode2> nodeList){
		makeSet(nodeList); 
		for(int i= 0; i<nodeList.size()-1; i++) {
			WeightedNode2 firstNode = nodeList.get(i);
			WeightedNode2 secondNode = nodeList.get(i+1);
			System.out.println("Checking if node "+firstNode.getName()+" and "+secondNode.getName() +" belongs to different set, if yes, will Union them...");
			System.out.println("\nFirst Set name is: " + firstNode.getName());
			firstNode.getSet().printAllNodesOfThisSet();
			System.out.println("\nSecond Set name is: " + secondNode.getName());
			secondNode.getSet().printAllNodesOfThisSet();
			if(!findSet(firstNode).equals(findSet(secondNode))) {
				System.out.println("\nMaking union "+firstNode+" and "+secondNode );
				DisjointSet unionedSet = union(firstNode, secondNode);
				unionedSet.printAllNodesOfThisSet();
			}
			System.out.println("\n**************************************\n");
		}
	}
	
	public static void makeSet(ArrayList<WeightedNode2> nodeList) {
		for(WeightedNode2 node:nodeList) {
			DisjointSet set = new DisjointSet();
			set.getNodes().add(node);
			node.setSet(set);
		}
	}

	public static DisjointSet union(WeightedNode2 node1, WeightedNode2 node2) {
		DisjointSet set1 = node1.getSet();
		DisjointSet set2 = node2.getSet();
		if(set1.getNodes().size() > set2.getNodes().size()) {
			for(WeightedNode2 node : set2.getNodes()) {
				set1.getNodes().add(node);
				node.setSet(set1);
			}
			return set1;
		}else {
			for(WeightedNode2 node : set1.getNodes()) {
				node.setSet(set2);
				set2.getNodes().add(node);
			}
			return set2;	
		}
		
	}
	
	public static DisjointSet getSet(WeightedNode2 node) {
		return node.getSet();
	}
	public static DisjointSet findSet(WeightedNode2 node) {
		return node.getSet();
	}

	public ArrayList<WeightedNode2> getNodes() {
		return nodes;
	}
	public void setNodes(ArrayList<WeightedNode2> nodes) {
		this.nodes = nodes;
	}
	
	public void printAllNodesOfThisSet() {
		System.out.println("Printing all nodes of the set: ");
		for(WeightedNode2 node : nodes) {
			System.out.print(node+" ");
		}
		System.out.println();
	}
	
	
}
