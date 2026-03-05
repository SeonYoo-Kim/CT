
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int R, C;
	static String[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int xJ = -1, yJ = -1;
//		int xF = -1, yF = -1;
		List<int[]> F = new ArrayList<>();
		map = new String[R][C];
		boolean[][] visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
			for (int j = 0; j < C; j++) {
				if (map[i][j].equals("J")) {
					xJ = i;
					yJ = j;
					visited[xJ][yJ] = true;
					map[i][j] = ".";
				} else if (map[i][j].equals("F")) {
					F.add(new int[] {i, j});
					visited[i][j] = true;
				}else if (map[i][j].equals("#")) {
					visited[i][j] = true;
				}
			}
		}
//		for(String[]a:map)System.out.println(Arrays.toString(a));
//		System.out.println("J : " + x + ", " + y + "\n" + "F : " + xF + ", " + yF);

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };

		int[][] fireTime = new int[R][C];
		for (int[] a : fireTime)
			Arrays.fill(a, -1);
		for(int[]a:F) {
			fireTime[a[0]][a[1]] = 0;
		}
		
		Queue<int[]> fireQ = new ArrayDeque<>();
		for(int[]a:F) {
			fireQ.offer(new int[] { a[0], a[1], 0 });
		}

		while (!fireQ.isEmpty()) {
			int[] cur = fireQ.poll();
			int xf = cur[0];
			int yf = cur[1];
			int time = cur[2];
			for (int d = 0; d < 4; d++) {
				int nx = xf + dx[d];
				int ny = yf + dy[d];
				if (inRange(nx, ny) && map[nx][ny].equals(".")&& fireTime[nx][ny] == -1) {
					fireTime[nx][ny] = time + 1;
					fireQ.offer(new int[] { nx, ny, time + 1 });
				}
			}
		}
		//for(int[]a:fireTime)System.out.println(Arrays.toString(a));

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { xJ, yJ, 0 });
		//for(boolean[]a:visited)System.out.println(Arrays.toString(a));

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int time = cur[2];
//			System.out.println("x, y : " + x + ", " + y);

			boolean burn = true;
			for (int d = 0; d < 4; d++) {
				
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nt = time + 1;
// 				System.out.println("nx, ny, nt : " + nx + ", " + ny + ", " + nt);
				if (!inRange(nx, ny)) {
					System.out.println(nt);
					return;
				} else {
					if (map[nx][ny].equals(".") && !visited[nx][ny] && (nt < fireTime[nx][ny] || fireTime[nx][ny] == -1)) {
						visited[nx][ny] = true;
						q.offer(new int[] { nx, ny, nt });
//						System.out.println("offered : " + nx + ", " + ny + ", " + nt);
//						if(nt < fireTime[nx][ny]) burn = false;
					}
				}
			}//if(burn) break;
		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < R && y >= 0 && y < C;
	}

}
