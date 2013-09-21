package test.algo2.first.algos;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Test;

import algo2.first.algos.GreedySchedulingDifference;
import algo2.first.entities.Job;
import algo2.first.entities.JobDifferenceCost;
import algo2.first.entities.JobRatioCost;

public class GreedySchedulingDifferenceTest {

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
		assertEquals(GreedySchedulingDifference.calculateCosts(jobs),20000);
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
		assertEquals(GreedySchedulingDifference.calculateCosts(jobs),19400);
	}
	@Test
	public void testOriginalJobDifferenceCost() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/jobs.txt")));
		String currentLine = reader.readLine();
		int numberOfJobs=new Integer(currentLine);
		JobDifferenceCost[] jobs = new JobDifferenceCost[numberOfJobs];
		int i=0;
		while((currentLine=reader.readLine())!=null)
		{
			String[] jobData = currentLine.split(" ");
			jobs[i]=new JobDifferenceCost(new Integer(jobData[0]),new Integer(jobData[1]));
			i++;
		}
		GreedySchedulingDifference.scheduleJobs(jobs);
		System.out.println("difference: "+GreedySchedulingDifference.calculateCosts(jobs));
	}
	
	@Test
	public void testOriginalJobRationCost() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/jobs.txt")));
		String currentLine = reader.readLine();
		int numberOfJobs=new Integer(currentLine);
		Job[] jobs = new JobRatioCost[numberOfJobs];
		int i=0;
		while((currentLine=reader.readLine())!=null)
		{
			String[] jobData = currentLine.split(" ");
			jobs[i]=new JobRatioCost(new Integer(jobData[0]),new Integer(jobData[1]));
			i++;
		}
		GreedySchedulingDifference.scheduleJobs(jobs);
		System.out.println("Ratio: "+GreedySchedulingDifference.calculateCosts(jobs));
	}

}
