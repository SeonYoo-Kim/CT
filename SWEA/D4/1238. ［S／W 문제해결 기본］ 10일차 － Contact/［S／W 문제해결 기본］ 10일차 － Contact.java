import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		for (int tc = 1; tc <= 10; tc++) {
			

			st.nextToken();
			int N = (int) st.nval / 2;
			
			st.nextToken();
			int start = (int) st.nval;
			
//			System.out.println(N + " " + start);
			ArrayList<Integer>[] edges = new ArrayList[101];
			int[] visited = new int[101];

			for (int j = 0; j < N; j++) {
				st.nextToken();
				int from = (int) st.nval;
				if(edges[from] == null)
					edges[from] = new ArrayList<>();
				st.nextToken();
				edges[from].add((int) st.nval);
			}

//			for(int i = 0; i < 101; i++) {
//				if(edges[i] != null) {
//					System.out.println(i);
//					System.out.println(edges[i].toString());
//				}
//			}
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(start);
			visited[start] = 1;
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(edges[cur] == null) continue;
				for(Integer call : edges[cur]) {
					if(visited[call] == 0) {
						visited[call] = visited[cur] + 1;
						q.offer(call);
// 						System.out.println("offered : " + call);
					}
				}
			}
			
			int max = Integer.MIN_VALUE;
			int idx = -1;
			for (int i = 0; i < visited.length; i++) {
				if(visited[i] >= max) {
					max = visited[i];
					idx = i;
				}
			}
			System.out.println("#" + tc + " " + idx);
		}

	}

}
