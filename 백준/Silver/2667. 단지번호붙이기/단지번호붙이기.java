import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		int[] dx = { 0, 0, 1, -1 };
		int[] dy = { 1, -1, 0, 0 };
		ArrayList<Integer> apart = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (!visited[i][j] && map[i][j] == 1) {
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] { i, j });
					visited[i][j] = true;
					int cnt = 0;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						cnt++;
						int x = cur[0];
						int y = cur[1];
						for (int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] == 1) {
								visited[nx][ny] = true;
								q.offer(new int[] { nx, ny });
							}
						}
					}
					apart.add(cnt);
				}

			}
		}
		Integer[] list = apart.toArray(new Integer[0]);
		Arrays.sort(list);
		System.out.println(list.length);
		for (int a : list)
			System.out.println(a);
	}

}
