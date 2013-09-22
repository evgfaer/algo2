package org.coursera.assignment.first.graph.entities;

public class Graph {

	private Vertex[] vertices;
	private Edge[] edges;
	private int nextFreePlaceForEdge;

	public Graph(int numberOfVertices, int numberOfEdges) {
		vertices = new Vertex[numberOfVertices];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new Vertex(i-1);
		}
		edges = new Edge[numberOfEdges];
		nextFreePlaceForEdge = 0;
	}

	public void addEdge(int vertexNameFirst, int vertexNameSecond, int costs) {
		if (nextFreePlaceForEdge > edges.length - 1) {
			throw new RuntimeException("edge cannot be added, array is full");
		}
		edges[nextFreePlaceForEdge] = new Edge(getVertex(vertexNameFirst),
				getVertex(vertexNameSecond), costs);
		nextFreePlaceForEdge++;
	}

	public int getNumberOfVertices() {
		return vertices.length;
	}

	public Vertex getVertex(int name) {
		return vertices[name-1];
	}

	public Edge[] getEdges() {
		return edges;
	}

	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}
}
