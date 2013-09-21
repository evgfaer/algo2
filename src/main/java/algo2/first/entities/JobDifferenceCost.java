package algo2.first.entities;

public class JobDifferenceCost extends Job {

	public JobDifferenceCost(int weight, int length) {
		super(weight, length);
	}

	@Override
	public double getCosts() {
		return this.getWeight()-this.getLength();
	}

}
