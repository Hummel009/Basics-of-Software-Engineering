package main.java.hummel;

import java.util.*;

public class ADS04 {
	public static void main(String[] args) {
		List<Edge> edges = new ArrayList<>();
		edges.add(new Edge(0, 1, 6));
		edges.add(new Edge(1, 2, 7));
		edges.add(new Edge(2, 0, 5));
		edges.add(new Edge(2, 1, 4));
		edges.add(new Edge(3, 2, 9));
		edges.add(new Edge(4, 5, 1));
		edges.add(new Edge(5, 4, 3));
		Edge start = null;
		for (Edge e1: edges) {
			start = e1;
			for (Edge e2: edges) {
				if (e1 != e2 && e1.src == e2.dest) {
					start = null;
				}
			}
		}
		if (start != null) {
			System.out.printf("Start: %d -----> %s\n", start.src, start.dest);
		}
		Graph graph = new Graph(edges);
		Graph.printGraph(graph);
	}

	public static class Edge {
		public int src, dest, weight;

		public Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	public static class Graph {
		public List<List<Node>> adjList = new ArrayList<>();

		public Graph(List<Edge> edges) {
			int n = 0;
			for (Edge e : edges) {
				n = Integer.max(n, Integer.max(e.src, e.dest));
			}
			for (int i = 0; i <= n; i++) {
				adjList.add(i, new ArrayList<>());
			}
			for (Edge e : edges) {
				adjList.get(e.src).add(new Node(e.dest, e.weight));
			}
		}

		public static void printGraph(Graph graph) {
			int src = 0;
			int n = graph.adjList.size();

			while (src < n) {
				for (Node edge : graph.adjList.get(src)) {
					System.out.printf("%d --%s ", src, edge);
				}

				System.out.println();
				src++;
			}
		}
	}

	public static class Node {
		public int value, weight;

		public Node(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return weight + "--> " + value;
		}
	}
}