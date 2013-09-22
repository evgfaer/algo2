package org.coursera.assignment.first;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.coursera.assignment.first.graph.entities.Graph;
import org.coursera.assignment.first.graph.entities.PrimSpanningTree;
import org.junit.Test;

public class SpanningTreeTest {

	String assignmentGraphPath = "src/test/resources/edges.txt";
	String exampleGraphPath = "src/test/resources/graphExample.txt";

	@Test
	public void testStraighForwardSolution() throws Exception {
		Graph graph=null;
		graph = readGraph(assignmentGraphPath);
		assertEquals((new PrimSpanningTree(graph)).getSpanningTreeCostsStraightForwardSolution(),-3612829);
	}
	@Test
	public void testStraighForwardSolutionWithExampleGraph() throws Exception {
		Graph graph=readGraph(exampleGraphPath);
		assertEquals((new PrimSpanningTree(graph)).getSpanningTreeCostsStraightForwardSolution(),120971);
	}

	private Graph readGraph(String pathToGraphInformation) throws Exception {
		Graph graph;
		BufferedReader reader=null;
		try {
			reader = new BufferedReader(new FileReader(new File(
					pathToGraphInformation)));
			String readLine = reader.readLine();
			String[] graphInfo = readLine.split(" ");
			graph =new Graph(Integer.valueOf(graphInfo[0]),Integer.valueOf(graphInfo[1]));
			while((readLine=reader.readLine())!=null)
			{
				String[] edgeInfo = readLine.split(" ");
				graph.addEdge(Integer.valueOf(edgeInfo[0]), Integer.valueOf(edgeInfo[1]), Integer.valueOf(edgeInfo[2]));
			}
		} 
		catch(Exception e)
		{
			throw e;
		}
		finally {
			reader.close();
		}
		return graph;
	}
}
