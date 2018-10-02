package ds.graph.raversal.bfs;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	int v;
	List<Integer> adj[];

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++)
			adj[i] = new LinkedList<Integer>();
	}

	private void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);
		int v = g.findMother();

		System.out.println("Mother :" + v);
	}

	private int findMother() {
		boolean[] isVisited = new boolean[v];
		int x = 0;
		for (int i = 0; i < v; i++) {
			if (!isVisited[i]) {
				DFSUtil(i, isVisited);
				x = i;
			}

		}

		isVisited = new boolean[v];
		DFSUtil(x, isVisited);
		for (boolean b : isVisited) {
			if (!b)
				return -1;
		}

		return x;
	}

	private void DFSUtil(int v, boolean[] isVisited) {
		isVisited[v] = true;
		for (int i : adj[v]) {
			if (!isVisited[i]) {
				isVisited[i] = true;
				DFSUtil(i, isVisited);

			}
		}

	}

}
