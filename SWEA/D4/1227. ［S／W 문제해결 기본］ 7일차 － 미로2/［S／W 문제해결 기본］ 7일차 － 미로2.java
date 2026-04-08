import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			map = new int[100][100];
			visited = new boolean[100][100];
			int curX = -1, curY = -1;
			for (int i = 0; i < 100; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < 100; j++) {
					map[i][j] = line[j] - '0';
					if(map[i][j] == 2) {
						curX = i;
						curY = j;
						visited[i][j] = true;
					}
				}
			}
			System.out.println("#" + tc + " " + dfs(curX, curY));
		}

	}

	private static int dfs(int x, int y) {
		if(map[x][y] == 3)
			return 1;
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if(inRange(nx, ny)) {
				visited[nx][ny] = true;
				if(dfs(nx, ny) == 1) return 1;
			}
		}
		return 0;
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100 && !visited[x][y] && map[x][y]!=1;
	}

}
