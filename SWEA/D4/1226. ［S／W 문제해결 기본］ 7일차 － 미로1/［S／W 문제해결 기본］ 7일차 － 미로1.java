
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int map[][];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;
	static int asw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			asw = 0;
			br.readLine();

			map = new int[16][16];
			visited = new boolean[16][16];
			int x = -1, y = -1;

			for (int i = 0; i < 16; i++) {
				String line = br.readLine();
				for (int j = 0; j < 16; j++) {
					map[i][j] = line.charAt(j) - '0';
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
//for(int[]a:map)System.out.println(Arrays.toString(a));
			
			dfs(x, y);
			
			System.out.println("#" + tc + " " + asw);
		}

	}

	private static void dfs(int x, int y) {
//		System.out.println("x, y : " + x + " " + y);
		if(asw == 1) return;
		
		if (map[x][y] == 3) {
			asw = 1;
			return;
		}
		
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (inRange(nx, ny)) {
				dfs(nx, ny);
			}
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < 16 && y >= 0 && y < 16 && map[x][y] != 1 && !visited[x][y];
	}

}
