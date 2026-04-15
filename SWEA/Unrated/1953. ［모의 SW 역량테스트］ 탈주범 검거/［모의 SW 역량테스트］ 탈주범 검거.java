import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int N, M, R, C, L, map[][][];
//	static int[] dx = {0, 0, 1, -1}; // 우 / 좌 / 하 / 상
//	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 1, 0, -1}; // 우 / 하 / 좌 / 상
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M][4];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int type = Integer.parseInt(st.nextToken());
					switch (type) {
					case 0: {
						map[i][j] = new int[] {0, 0, 0, 0};
						visited[i][j] = true;
						break;
					}case 1: {
						map[i][j] = new int[] {1, 1, 1, 1};
						break;
					}case 2: {
						map[i][j] = new int[] {0, 1, 0, 1};
						break;
					}case 3: {
						map[i][j] = new int[] {1, 0, 1, 0};
						break;
					}case 4: {
						map[i][j] = new int[] {1, 0, 0, 1};
						break;
					}case 5: {
						map[i][j] = new int[] {1, 1, 0, 0};
						break;
					}case 6: {
						map[i][j] = new int[] {0, 1, 1, 0};
						break;
					}case 7: {
						map[i][j] = new int[] {0, 0, 1, 1};
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + type);
					} 
				}
			}
			int cnt = 1;
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {R, C, 1});
			visited[R][C] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];
				
				if(t >= L) break;
				
				
				for (int d = 0; d < 4; d++) {
					
					if(map[x][y][d] == 1) {
						int nx = x + dx[d];
						int ny = y + dy[d];
						if(inRange(nx, ny) && map[nx][ny][(d+2)%4] == 1) {
							visited[nx][ny] = true;
							q.offer(new int[] {nx, ny, t + 1});
							cnt++;
							// System.out.println(nx + ", " + ny + " offered");
						}
					}
				}				
			}			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M && !visited[x][y];
	}

}
