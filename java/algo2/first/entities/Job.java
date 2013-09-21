package algo2.first.entities;

public abstract class Job {

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
}
