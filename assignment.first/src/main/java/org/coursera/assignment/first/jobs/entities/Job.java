package org.coursera.assignment.first.jobs.entities;

public abstract class Job implements Comparable<Job> {

	private int weight;
	private int length;

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Job(int weight, int length) {
		super();
		this.weight = weight;
		this.length = length;
	}

	public abstract double getCosts();

	public int compareTo(Job o) {
		int comparisonResult = Double.valueOf(this.getCosts()).compareTo(
				o.getCosts());
		if (comparisonResult == 0) {
			return Integer.valueOf(this.getWeight()).compareTo(o.getWeight());
		}
		return comparisonResult;
	}
}
