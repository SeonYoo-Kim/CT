
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][M + 1];
		boolean[][][] visited = new boolean[N + 1][M + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			String line = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = line.charAt(j - 1) - '0';
			}
		}
//		for(int[]a:map)System.out.println(Arrays.toString(a));

		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 1, 1, 1, 0 });
		visited[1][1][0] = true;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			int broken = cur[3];
			
			if(x == N && y == M) {
				System.out.println(dist);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(inRange(nx, ny)) {
					
					if(map[nx][ny] == 0) {
						if(!visited[nx][ny][broken]) {
							visited[nx][ny][broken] = true;
							q.offer(new int[] {nx, ny, dist+1, broken});
						}
					}else {
						if(broken < K && !visited[nx][ny][broken+1]) {
							visited[nx][ny][broken+1] = true;
							q.offer(new int[] {nx, ny, dist+1, broken+1});
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	private static boolean inRange(int x, int y) {
		return x > 0 && x <= N && y > 0 && y <= M;
	}

}
