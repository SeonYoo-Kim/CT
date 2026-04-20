import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
	static class fish {
		int x, y, dist;

		public fish(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int N, map[][], r, c;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
					map[i][j] = 0;
				}
			}
		}
		int cnt = 0;
		int sec = 0;
		int size = 2;

		while (true) {
			PriorityQueue<fish> pq = new PriorityQueue<>((a, b) -> {
				if (a.dist == b.dist) {
					if (a.x == b.x)
						return Integer.compare(a.y, b.y);
					return Integer.compare(a.x, b.x);
				}
				return Integer.compare(a.dist, b.dist);
			});

			ArrayDeque<int[]> q = new ArrayDeque<>();
			boolean visited[][] = new boolean[N][N];
			visited[r][c] = true;
			q.offer(new int[] { r, c, 0 });

			while (!q.isEmpty()) {

				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int dist = cur[2];

				if (map[x][y] > 0 && map[x][y] < size) {
					pq.offer(new fish(x, y, dist));
					// System.out.println("fish offered to pq : " + x + ", " + y);
				}

				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (inRange(nx, ny) && !visited[nx][ny] && map[nx][ny] <= size) {
						visited[nx][ny] = true;
						q.offer(new int[] { nx, ny, dist + 1 });
						// System.out.println("fish offered : " + nx + ", " + ny + ", " + (dist+1));
					}
					
				}
			}
			if (pq.isEmpty()) break;

			fish target = pq.poll();
			map[target.x][target.y] = 0;
			r = target.x;
			c = target.y;
			sec += target.dist;
			cnt++;
			if (cnt == size) {
				size++;
				cnt = 0;
			}
			// System.out.println("eaten " + target.x + ", " + target.y);

		}

		System.out.println(sec);
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
