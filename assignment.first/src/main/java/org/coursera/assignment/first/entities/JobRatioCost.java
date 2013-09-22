package org.coursera.assignment.first.entities;

public class JobRatioCost extends Job {

	public JobRatioCost(int weight, int length) {
		super(weight, length);
	}

	@Override
	public double getCosts() {
		return (double) this.getWeight() / (double) this.getLength();
	}

}
