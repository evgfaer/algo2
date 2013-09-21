package algo2.first.algos;

import algo2.first.entities.Job;

public class GreedySchedulingDifference {
	
	public static long calculateCosts(Job[] jobsToSchedule)
	{
		int currentTime=0;
		long costs=0;
		for (int i = 0; i < jobsToSchedule.length; i++) {
			Job job = jobsToSchedule[i];
			currentTime=currentTime+job.getLength();
			costs=costs+currentTime*job.getWeight();
		}
		return costs;
	}

	public static void scheduleJobs(Job[] jobsToSchedule) {
		boolean bubbleSortChangedSomething = true;
		while (bubbleSortChangedSomething) {
			bubbleSortChangedSomething = false;
			for (int i = 0; i < jobsToSchedule.length; i++) {
				if (i < jobsToSchedule.length - 1) {
					if (jobsToSchedule[i].getCosts() < jobsToSchedule[i + 1]
							.getCosts()
							|| (jobsToSchedule[i].getCosts() == jobsToSchedule[i + 1]
									.getCosts() && jobsToSchedule[i]
									.getWeight() < jobsToSchedule[i + 1]
									.getWeight())) {
						swap(jobsToSchedule, i, i + 1);
						bubbleSortChangedSomething = true;
					}
				}
			}
		}
	}

	public static void swap(Object[] toSwap, int from, int to) {
		Object toObject = toSwap[to];
		toSwap[to] = toSwap[from];
		toSwap[from] = toObject;
	}
}
