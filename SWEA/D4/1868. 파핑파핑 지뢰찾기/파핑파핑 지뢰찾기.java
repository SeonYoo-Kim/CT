
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution{

	static int N;
	static int board[][];
	static int[] dx = { 0, 0, 1, 1, 1, -1, -1, -1 };
	static int[] dy = { 1, -1, 0, 1, -1, 0, 1, -1 };
	private static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] line = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					switch (line[j]) {
					case '*': {
						board[i][j] = -1;
						break;
					}
					case '.': {
						board[i][j] = 0;
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + line[j]);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != -1) {
						int mine = 0;
						for (int d = 0; d < 8; d++) {
							int nx = i + dx[d];
							int ny = j + dy[d];
							if (inRange(nx, ny)) {
								if (board[nx][ny] == -1)
									mine++;
							}
						}
						board[i][j] = mine;
					}
				}
			}
//			for (int[] a : board)
//				System.out.println(Arrays.toString(a));

			int cnt = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] == -1) visited[i][j] = true;
					else if (board[i][j] == 0 && !visited[i][j]) {
						
						ArrayDeque<int[]> q = new ArrayDeque<>();
						q.offer(new int[] {i, j});
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							
							int[] cur = q.poll();
							int x = cur[0];
							int y = cur[1];
							
							if(board[x][y] == 0) {
								for (int d = 0; d < 8; d++) {
									int nx = x + dx[d];
									int ny = y + dy[d];
									
									if(inRange(nx, ny) && !visited[nx][ny] && board[nx][ny] != -1) {
										visited[nx][ny] = true;
										q.offer(new int[] {nx, ny});
									}
								}
							}
						}
						cnt ++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						if(visited[i][j]) continue;
						cnt++;
						visited[i][j] = true;
					}
					
				}
				
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}

	private static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
