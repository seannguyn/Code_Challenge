import java.util.*;


public class Problem_2 {
/*
 * 
 * 		Implement dijkstra algorithm
 * 
 * 		Graph has a list of node, hashmap of node
 * 		each node has an arraylist of edge, and an associated cost
 */
	
	public static void main(String[] args) {
		System.out.println("Problem 2");
		System.out.println();
		
		Problem_2 p2 = new Problem_2();
		
		Graph g = p2.new Graph();
		
		g.addEdge("A", "B", 4);
		g.addEdge("A", "H", 8);
		
		g.addEdge("B", "C", 8);
		g.addEdge("B", "H", 11);
		
		
		g.addEdge("C", "D", 7);
		g.addEdge("C", "F", 4);
		g.addEdge("C", "I", 2);
		
		g.addEdge("D", "E", 9);
		g.addEdge("D", "F", 14);
		
		g.addEdge("E", "F", 10);
		
		g.addEdge("F", "G", 2);
		
		g.addEdge("G", "I", 6);
		g.addEdge("G", "H", 1);
		
		g.addEdge("H", "I", 7);
		
		g.dijkstra("A","I");
	}
	
	public class Graph {
		
		HashMap<String, Node> nodeHash;
		ArrayList<Node> nodeList;
		
		public Graph() {
			this.nodeHash = new HashMap<String, Node>();
			this.nodeList = new ArrayList<Node>();
		}
		
		public void dijkstra(String src, String dst) {
			
			PriorityQueue<State> pq = new PriorityQueue<State>();
			
			Iterator it = nodeHash.entrySet().iterator();
			while (it.hasNext()) {
				
				Map.Entry pair = (Map.Entry)it.next();
				
				Node n = (Node)pair.getValue();
				State newState;
				
				if (n.value.equals(src)) {
					newState = new State(n, 0);
				} else {
					newState = new State(n, Integer.MAX_VALUE);
				}
				pq.add(newState);
				
				it.remove();
			}
			
			State result = null;
			
			
			while (!pq.isEmpty()) {
				State currentState = pq.poll();
				Node currentNode = currentState.currentNode;
				
				if(currentNode.value.equals(dst)) {
					result = currentState;
				}
				
				for (Node neighborNode : currentNode.neighbor.keySet()) {
					int neighborEdge = currentNode.neighbor.get(neighborNode);
					
					State neighborState = null;
					// how to get the neighbor node from state
					for (State s : pq) {
						if (s.currentNode.equals(neighborNode)) {
							neighborState = s;
						}
					}
					
					if (neighborState == null) continue;
					
					if (currentState.cost + neighborEdge < neighborState.cost ) {
						int newCost = currentState.cost + neighborEdge;
						
						for (State st : pq) {
							if (st.equals(neighborState)) {
								// dequeue
								pq.remove(st);
								
								// update neighbor cost
								st.cost = newCost;
								
								// enqueue this neighbor state
								pq.add(st);
								break;
							}
						}
						
						
					}
				}
				
			}
			if (result != null) System.out.println(src+" to "+dst+" "+result.cost);
			
			// initialize a PQ 
			// populate the PQ with states, all states have the cost of infinity, except for the src state, which have the starting cost of 0
			// 
			/*
			 * while (PQ is not empty) {
			 * 
			 * 		State currentState = PQ.pop();
			 * 		Node currentNode = currentState.currentNode;
			 * 
			 * 		for (Node neighbor : currentNode.getNeighbor) {
			 * 
			 * 
			 * 			if (currentState.cost + edgeToNeighbor < neighborCurrentCost) {
			 * 				dequeue
			 * 				update neighbor cost
			 * 				enqueue this neighbor state 
			 * 			}
			 * 
			 * 		}
			 * 
			 * }
			 */
		}
		
		public class Node {
			String value;
			HashMap<Node, Integer> neighbor;
			
			public Node(String value) {
				this.value = value;
				this.neighbor = new HashMap<Node, Integer>();
			}
			
			public void printEdge() {
				Iterator it = neighbor.entrySet().iterator();
				while (it.hasNext()) {
					
					Map.Entry pair = (Map.Entry)it.next();
					
					Node n = (Node) pair.getKey();
					
					System.out.print("  "+n.value + " = " + pair.getValue());
					
					it.remove();
				}
				System.out.println();
			}
		}
		
		public class State implements Comparable<State> {

			Node currentNode;
			int cost;
			
			public State(Node currentNode, int cost) {
				this.currentNode = currentNode;
				this.cost = cost;
			}
			
			@Override
			public int compareTo(State another) {
				// TODO Auto-generated method stub
				if (this.cost > another.cost) {
					return 1;
				} else if (this.cost == another.cost) {
					return 0;
				} else {
					return -1;
				}
				
			}
			
		}
		
		public void addEdge(String src, String dest, int cost) {
			
			// check if src or dst exist
			Node srcNode; 
			Node dstNode;
			
			if (nodeHash.get(src) != null) {
				srcNode = nodeHash.get(src);
			} else {
				srcNode = new Node(src);
				nodeHash.put(src, srcNode);
				nodeList.add(srcNode);
			}
			
			
			if (nodeHash.get(dest) != null) {
				dstNode = nodeHash.get(dest);
			} else {
				dstNode = new Node(dest);
				nodeHash.put(dest, dstNode);
				nodeList.add(dstNode);
			}
			
			srcNode.neighbor.put(dstNode, cost);
		}
		
		public void checkEdge() {
			Iterator it = nodeHash.entrySet().iterator();
			while (it.hasNext()) {
				
				Map.Entry pair = (Map.Entry)it.next();
				
				System.out.println("Node: "+pair.getKey());
				
				Node n = (Node)pair.getValue();
				n.printEdge();
				
				it.remove();
			}
		}
		
	}
	
	
}
