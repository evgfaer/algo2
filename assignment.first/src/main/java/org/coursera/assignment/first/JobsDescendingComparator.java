package org.coursera.assignment.first;

import java.util.Comparator;

import org.coursera.assignment.first.entities.Job;

public class JobsDescendingComparator implements Comparator<Job> {

	public int compare(Job o1, Job o2) {
		int comparisonResult = o1.compareTo(o2);
		switch (comparisonResult) {
		case 1:
			return -1;
		case -1:
			return 1;
		default:
			return 0;
		}
	}

}
