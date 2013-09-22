package org.coursera.assignment.first.graph.entities;

public class Edge {
	private Vertex first;
	private Vertex second;
	private int costs;
	public Vertex getFirst() {
		return first;
	}
	public void setFirst(Vertex first) {
		this.first = first;
	}
	public Vertex getSecond() {
		return second;
	}
	public void setSecond(Vertex second) {
		this.second = second;
	}
	public int getCosts() {
		return costs;
	}
	public void setCosts(int costs) {
		this.costs = costs;
	}
	public Edge(Vertex first, Vertex second, int costs) {
		super();
		this.first = first;
		this.second = second;
		this.costs = costs;
	}
	
	
	
	
}
