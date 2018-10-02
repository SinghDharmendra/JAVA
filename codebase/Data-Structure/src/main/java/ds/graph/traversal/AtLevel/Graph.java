package ds.graph.traversal.AtLevel;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		adj[w].add(v);
	}

	private int BFS(int i, int l) {
		int level[] = new int[v];
		boolean[] isVisited = new boolean[v];

		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		isVisited[i] = true;
		level[i] = 0;

		while (!q.isEmpty()) {

			int s = q.poll();
			for (int k : adj[s]) {
				if (!isVisited[k]) {
					isVisited[k] = true;
					level[k] = level[s] + 1;
					q.add(k);
				}
			}

		}

		int count = 0;
		for (int k = 0; k < v; k++)
			if (level[i] == l)
				count++;
		return count;
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 5);

		int level = 2;
		System.out.println(g.BFS(0, level));

	}

}
