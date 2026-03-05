
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static ArrayList<int[]> fire;
	static int[][] fireMap;
	static String[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); // y
			h = Integer.parseInt(st.nextToken()); // x

			map = new String[h][w];
			int startX = -1, startY = -1;
			fire = new ArrayList<>();

			for (int i = 0; i < h; i++) {
				String[] line = br.readLine().split("");
				for (int j = 0; j < w; j++) {
					map[i][j] = line[j];
					if (map[i][j].equals("@")) {
						map[i][j] = ".";
						startX = i;
						startY = j;
					} else if (map[i][j].equals("*")) {
						fire.add(new int[] { i, j });
					}
				}
			}
//			for(String[]a:map)System.out.println(Arrays.toString(a));

			fireMap = new int[h][w];
			for (int[] a : fireMap) Arrays.fill(a, -1);

			Queue<int[]> q = new ArrayDeque<>();
			for (int[] a : fire) {
				q.offer(new int[] { a[0], a[1], 0 });
				fireMap[a[0]][a[1]] = 0;
			}
//			for (int[] a : fireMap)System.out.println(Arrays.toString(a));

			while(!q.isEmpty()) {
				
				int[] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];
				
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					int nt = t + 1;
					
					if(inRange(nx, ny) && fireMap[nx][ny] == -1 && map[nx][ny].equals(".")) {
						fireMap[nx][ny] = nt;
						q.offer(new int[] {nx, ny, nt});
					}
				}
			}
			
			bfs(startX, startY);
			
		} // tc

	}

	private static void bfs(int startX, int startY) {

		boolean[][] visited = new boolean[h][w];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startX, startY, 0});
		visited[startX][startY] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int dist = cur[2];
			
			if(x == h && y == w) {
				System.out.println(dist);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int ndist = dist + 1;
				
				if(inRange(nx, ny)) {
					if(!visited[nx][ny] && map[nx][ny].equals(".") && (fireMap[nx][ny] > ndist || fireMap[nx][ny] == -1)) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny, ndist});
					}
				}else {
					System.out.println(ndist);
					return;
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < h && y >= 0 && y < w;
	}

}
