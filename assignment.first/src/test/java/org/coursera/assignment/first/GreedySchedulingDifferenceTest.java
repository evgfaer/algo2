package org.coursera.assignment.first;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.coursera.assignment.first.jobs.GreedySchedulingDifference;
import org.coursera.assignment.first.jobs.entities.Job;
import org.coursera.assignment.first.jobs.entities.JobDifferenceCost;
import org.coursera.assignment.first.jobs.entities.JobRatioCost;
import org.junit.Test;

public class GreedySchedulingDifferenceTest {

	private static String jobsPath = "src/test/resources/jobs.txt";

	@Test
	public void testDifference() {
		Job[] jobs = new Job[6];
		jobs[0] = new JobDifferenceCost(30, 90);
		jobs[1] = new JobDifferenceCost(10, 30);
		jobs[2] = new JobDifferenceCost(20, 40);
		jobs[3] = new JobDifferenceCost(30, 50);
		jobs[4] = new JobDifferenceCost(20, 60);
		jobs[5] = new JobDifferenceCost(10, 50);
		GreedySchedulingDifference.scheduleJobs(jobs);
		assertEquals(GreedySchedulingDifference.calculateCosts(jobs), 20000);
	}

	@Test
	public void testRatio() {
		Job[] jobs = new Job[6];
		jobs[0] = new JobRatioCost(30, 90);
		jobs[1] = new JobRatioCost(10, 30);
		jobs[2] = new JobRatioCost(20, 40);
		jobs[3] = new JobRatioCost(30, 50);
		jobs[4] = new JobRatioCost(20, 60);
		jobs[5] = new JobRatioCost(10, 50);
		GreedySchedulingDifference.scheduleJobs(jobs);
		assertEquals(GreedySchedulingDifference.calculateCosts(jobs), 19400);
	}

	@Test
	public void testOriginalJobDifferenceCost() throws Exception {

		BufferedReader reader = new BufferedReader(new FileReader(new File(
				jobsPath)));
		try {
			String currentLine = reader.readLine();
			int numberOfJobs = new Integer(currentLine);
			JobDifferenceCost[] jobs = new JobDifferenceCost[numberOfJobs];
			int i = 0;
			while ((currentLine = reader.readLine()) != null) {
				String[] jobData = currentLine.split(" ");
				jobs[i] = new JobDifferenceCost(new Integer(jobData[0]),
						new Integer(jobData[1]));
				i++;
			}
			GreedySchedulingDifference.scheduleJobs(jobs);
			System.out.println("difference: "
					+ GreedySchedulingDifference.calculateCosts(jobs));
		} finally {
			reader.close();
		}

	}

	@Test
	public void testOriginalJobRationCost() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(
				jobsPath)));
		try {
			String currentLine = reader.readLine();
			int numberOfJobs = new Integer(currentLine);
			Job[] jobs = new JobRatioCost[numberOfJobs];
			int i = 0;
			while ((currentLine = reader.readLine()) != null) {
				String[] jobData = currentLine.split(" ");
				jobs[i] = new JobRatioCost(new Integer(jobData[0]),
						new Integer(jobData[1]));
				i++;
			}
			GreedySchedulingDifference.scheduleJobs(jobs);

			System.out.println("Ratio: "
					+ GreedySchedulingDifference.calculateCosts(jobs));
		} finally {
			reader.close();
		}
	}

}
