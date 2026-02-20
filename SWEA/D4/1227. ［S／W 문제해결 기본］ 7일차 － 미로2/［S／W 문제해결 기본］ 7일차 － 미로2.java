
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int map[][];
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {

			int testCase = Integer.parseInt(br.readLine());
			map = new int[100][100];
			visited = new boolean[100][100];
			int x = -1;
			int y = -1;

			for (int i = 0; i < 100; i++) {
				String line = br.readLine();
				String[] arr = line.split("");
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(arr[j]);
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}
//			for(int[]a : map)
//				System.out.println(Arrays.toString(a));

			System.out.println("#" + tc + " " + maze(x, y));
		}

	}

	private static int maze(int x, int y) {
		// System.out.println(x + " " + y + " " + map[x][y]);
		
		if(map[x][y] == 3) {
			return 1;
		}
		
		if(visited[x][y]) {
			System.out.println("visited["+x+"]["+y+"] : " + visited[x][y]);
			return 0;
		}
		visited[x][y] = true;
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx>=0 && nx <100 && ny>=0 && ny <100 && map[nx][ny] != 1 && !visited[nx][ny]) {
				if(maze(nx, ny) == 1) {
	                return 1;
	            }
			}
		}
		return 0;
	}

}
