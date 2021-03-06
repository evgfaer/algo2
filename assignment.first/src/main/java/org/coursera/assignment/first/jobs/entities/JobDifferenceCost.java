package org.coursera.assignment.first.jobs.entities;

public class JobDifferenceCost extends Job {

	public JobDifferenceCost(int weight, int length) {
		super(weight, length);
	}

	@Override
	public double getCosts() {
		return this.getWeight()-this.getLength();
	}

}
