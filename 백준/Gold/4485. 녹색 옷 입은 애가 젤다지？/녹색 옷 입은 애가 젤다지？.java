
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class Node{
		int x, y, weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", weight=" + weight + "]";
		}
	}

	static int N, map[][];
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] cost = new int[N][N];
			for (int[] a : cost) Arrays.fill(a, Integer.MAX_VALUE);
			cost[0][0] = map[0][0];
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.weight, b.weight));
			pq.offer(new Node(0, 0, map[0][0]));
			
			while(!pq.isEmpty()) {
				
				Node cur = pq.poll();
				// System.out.println(cur.toString());
				int x = cur.x;
				int y = cur.y;
				int weight = cur.weight;
				
				for (int d = 0; d < 4; d++) {
					
					int nx = x + dx[d];
					int ny = y + dy[d];
					// System.out.println(nx + ", " + ny);
					
					if(inRange(nx, ny)) {
						int dist = weight + map[nx][ny];
						// System.out.println(dist);
						if(cost[nx][ny] <= dist) continue;
						cost[nx][ny] = dist;
						pq.offer(new Node(nx, ny, dist));
						
						
					}
						
				}
				
			}
			// for (int[] a : cost) System.out.println(Arrays.toString(a));
			System.out.println("Problem " + tc++ + ": " + cost[N-1][N-1]);
		}
	}
	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}
