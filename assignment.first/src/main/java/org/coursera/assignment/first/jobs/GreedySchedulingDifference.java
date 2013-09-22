package org.coursera.assignment.first.jobs;

import java.util.Arrays;
import java.util.Comparator;

import org.coursera.assignment.first.jobs.entities.Job;

public class GreedySchedulingDifference {

	public static long calculateCosts(Job[] jobsToSchedule) {
		int currentTime = 0;
		long costs = 0;
		for (int i = 0; i < jobsToSchedule.length; i++) {
			Job job = jobsToSchedule[i];
			currentTime = currentTime + job.getLength();
			costs = costs + currentTime * job.getWeight();
		}
		return costs;
	}

	public static void scheduleJobs(Job[] jobsToSchedule) {
		Arrays.sort(jobsToSchedule, new JobsDescendingComparator());
	}
}
