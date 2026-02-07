
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static boolean[][] visited;
	static boolean[][] drowned;
	static int[] dx = new int[] { 0, 0, 1, -1 };
	static int[] dy = new int[] { 1, -1, 0, 0 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		int max_space = 0;
		int max_height = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, arr[i][j]);
			}
		}
		for (int rain = 0; rain <= max_height; rain++) {
			drowned = new boolean[N][N]; // visited랑 같이 가야해서 계속 초기화 필요
			visited = new boolean[N][N];
			int space = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= rain) {
						drowned[i][j] = true;
					}
				}
			}
			// 인접 영역 탐색
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!drowned[i][j] && !visited[i][j]) { /////////////
						dfs(i, j); /////////////////// 안전구역이 끝나야 리턴됨
						space++;
					}
				}
			}
			if (space > max_space) {
				max_space = space;
			}
		}

		System.out.println(max_space);
	}

	private static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || ny < 0 || nx >= N || ny >= N || drowned[nx][ny] || visited[nx][ny])
				continue; // 안전구역 인접이 전부 이래야 끝남

			dfs(nx, ny);

		}
	}
}
