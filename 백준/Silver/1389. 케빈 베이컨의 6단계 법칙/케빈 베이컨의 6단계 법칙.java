import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer>[] friends = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		
		int min = Integer.MAX_VALUE;
		int person = 0;
		
		for (int i = N; i > 0; i--) {
//			System.out.print(i + " ");
			int KevinBacon = 0;
			boolean[] visited = new boolean[N + 1];
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {i, 0});
			visited[i] = true;
			
			while(!q.isEmpty()) {
				
				int[] cur = q.poll();
				int idx = cur[0];
				int KB = cur[1];
				KevinBacon += KB;
				
				for(int f : friends[idx]) {
					
					if(!visited[f]) {
						visited[f] = true;
						q.offer(new int[] {f, KB+1});
					}
				}
			}
//			System.out.println(KevinBacon);
			if(KevinBacon <= min) {
				min = KevinBacon;
				person = i;
			}
		}
		System.out.println(person);
	}

}
