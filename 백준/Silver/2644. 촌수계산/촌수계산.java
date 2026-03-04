

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] edges = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			edges[c].add(d);
			edges[d].add(c);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		int[] dist = new int[N+1];
		Arrays.fill(dist, -1);
		q.offer(a);
		dist[a] = 0;
		
		while(!q.isEmpty()) {
			
			int cur = q.poll();
			if(cur == b) break;
			
			for(int child : edges[cur]) {
				if(dist[child] == -1) {
					dist[child] = dist[cur] + 1;
					q.offer(child);
				}
			}
			
		}
		System.out.println(dist[b]);
	}

}
