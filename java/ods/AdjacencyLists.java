package ods;

import java.util.Iterator;
import java.util.List;

public class AdjacencyLists implements Graph {
	int n;
	
	List<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public AdjacencyLists(int n0) {
		n = n0;
		adj = (List<Integer>[])new List[n];
		for (int i = 0; i < n; i++) 
			adj[i] = new ArrayStack<Integer>(Integer.class);
	}
	
	public void addEdge(int i, int j) {
		adj[i].add(j);
	}

	public boolean hasEdge(int i, int j) {
		return adj[i].contains(j);
	}

	public int inDegree(int i) {
		int deg = 0;
		for (int j = 0; j < n; j++)
			if (adj[j].contains(i)) deg++;
		return deg;
	}

	public List<Integer> inEdges(int i) {
		List<Integer> edges = new ArrayStack<Integer>(Integer.class);
		for (int j = 0; j < n; j++)
			if (adj[j].contains(i))	edges.add(j);
		return edges;
	}

	public int nVertices() {
		return n;
	}

	public int outDegree(int i) {
		return adj[i].size();
	}

	public List<Integer> outEdges(int i) {
		return adj[i];
	}

	public void removeEdge(int i, int j) {
		Iterator<Integer> it = adj[i].iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}	
	}
}
