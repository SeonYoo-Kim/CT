
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	static int R, C, fireMap[][];
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int startX = -1, startY = -1;
		Queue<int[]> q = new ArrayDeque<>();

		map = new char[R][C];
		fireMap = new int[R][C];
		for (int[] a : fireMap)
			Arrays.fill(a, -1);
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if (map[i][j] == 'J') {
					startX = i;
					startY = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'F') {
					q.offer(new int[] { i, j, 0 });
					fireMap[i][j] = 0;
					map[i][j] = '.';
				}
			}
		}
		int[] dx = {0, 0 , 1, -1};
		int[] dy = {1, -1, 0, 0};
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int t = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(inRange(nx, ny)) {
					fireMap[nx][ny] = t + 1;
					q.offer(new int[] {nx, ny, t+1});
				}
			}
		}

		q.clear();
		q.offer(new int[] {startX, startY, 0});
		boolean[][] visited = new boolean[R][C];
		visited[startX][startY] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int t = cur[2];
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nt = t + 1;
				
				if(inRange(nx, ny, nt)) {
//					System.out.println(nx + " " + ny + " " + nt);
					if(!visited[nx][ny] && map[nx][ny] == '.' && (nt < fireMap[nx][ny] || fireMap[nx][ny] == -1)) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, nt});
					}
				}
				else {
					System.out.println(nt);
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean inRange(int x, int y, int t) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C && fireMap[x][y] == -1 && map[x][y] == '.';
	}

}
