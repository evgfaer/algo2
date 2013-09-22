package org.coursera.assignment.first;

import org.coursera.assignment.first.entities.Job;



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
			for (int i = 0; i < jobsToSchedule.length-1; i++) {
					if (jobsToSchedule[i].compareTo(jobsToSchedule[i + 1])==-1) {
						swap(jobsToSchedule, i, i + 1);
						bubbleSortChangedSomething = true;
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
