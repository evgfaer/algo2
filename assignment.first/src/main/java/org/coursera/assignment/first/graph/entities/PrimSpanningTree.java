package org.coursera.assignment.first.graph.entities;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PrimSpanningTree {
	private Graph graph;

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public PrimSpanningTree(Graph graph) {
		super();
		this.graph = graph;
	}

	public int getSpanningTreeCostsStraightForwardSolution() {
		Set<Vertex> verticesInTree = new HashSet<Vertex>();
		Set<Edge> tree = new HashSet<Edge>();
		addRandomVertice(verticesInTree);
		while (graph.getNumberOfVertices() != verticesInTree.size()) {
			Edge[] edges = graph.getEdges();
			Edge edgeWithSmallestCost = findNextTreeEdge(verticesInTree, edges);
			tree.add(edgeWithSmallestCost);
			verticesInTree.add(edgeWithSmallestCost.getFirst());
			verticesInTree.add(edgeWithSmallestCost.getSecond());
		}
		return calculateTreeCosts(tree);
	}

	private void addRandomVertice(Set<Vertex> verticesInTree) {
		int random = (new Random()).nextInt(graph.getNumberOfVertices()-1);
		verticesInTree.add(graph.getVertex(random));
	}

	private int calculateTreeCosts(Set<Edge> tree) {
		int treeCosts = 0;
		for (Edge edge : tree) {
			treeCosts = treeCosts + edge.getCosts();
		}
		return treeCosts;
	}

	private Edge findNextTreeEdge(Set<Vertex> verticesInTree, Edge[] edges) {
		Edge edgeWithSmallestCost = null;
		for (int i = 0; i < edges.length; i++) {
			Edge currentEdge = edges[i];
			if ((!verticesInTree.contains(currentEdge.getFirst()) && verticesInTree
					.contains(currentEdge.getSecond()))
					|| (verticesInTree.contains(currentEdge.getFirst()) && !verticesInTree
							.contains(currentEdge.getSecond()))) {
				if (edgeWithSmallestCost == null
						|| edgeWithSmallestCost.getCosts() > currentEdge
								.getCosts()) {
					edgeWithSmallestCost = currentEdge;
				}
			}
		}
		return edgeWithSmallestCost;
	}
}
