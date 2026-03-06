
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());		
			int start = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] call = new ArrayList[101];
			int[] visited = new int[101];
			Arrays.fill(visited, -1);
			for (int i = 0; i < call.length; i++) {
				call[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len/2; i++) {
				call[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {start, 0});
			visited[start] = 0;

			int dist = 0;
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int idx = cur[0];
				dist = cur[1];
				
				for(int c : call[idx]) {
					if(visited[c] == -1) {
						visited[c] = dist + 1;
						q.offer(new int[] {c, dist+1});
					}
				}
			}
			print(visited, dist, tc);
		}
	}

	private static void print(int[] visited, int dist, int tc) {
		for (int i = visited.length - 1; i > 0; i--) {
			if(visited[i] == dist) {
				System.out.println("#" + tc + " " + i);
				return;
			}
		}
	}
}
