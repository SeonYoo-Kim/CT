
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Queue;

public class Main {
	static int[][] box;
	static boolean[][] ripe;
	static boolean impossible = false;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, M, days = -1;

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		M = (int) st.nval;
		st.nextToken();
		N = (int) st.nval;
		box = new int[N][M];
		ripe = new boolean[N][M];
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				st.nextToken();
				box[i][j] = (int) st.nval;
				if (box[i][j] == 1)
					cnt++;
			}
		}
//		for (int[] a : box)
//			System.out.println(Arrays.toString(a));

		int[][] start = new int[cnt][2]; // x, y
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					start[idx][0] = i;
					start[idx][1] = j;
					idx++;
				}
			}
		}
//		for(int[]a : start)
//			System.out.println(Arrays.toString(a));

		tomato(start);

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				days = tomato(i, j, 1);
//			}
//		}
//		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) impossible = true; 
			}
		}

		System.out.println(impossible ? -1 : days);

	}

	private static void tomato(int[][] start) {
		// System.out.println("inside of tomato");
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < start.length; i++) {
			q.offer(start[i]);
			ripe[start[i][0]][start[i][1]] = true;
			// System.out.println("q added start : " + q.peek());
		}
		

		while (!q.isEmpty()) {
			// System.out.println("inside loop");
			int n = q.size();
			int[][] everyDay = new int[n][2];
			for (int i = 0; i < n; i++) {
				int[] cur = q.poll();
				everyDay[i][0] = cur[0];
				everyDay[i][1] = cur[1];
			}
			// System.out.println("one day passed : " + q.isEmpty());
			days++;
			for (int i = 0; i < n; i++) {
				int x = everyDay[i][0];
				int y = everyDay[i][1];
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < M && !ripe[nx][ny] && box[nx][ny] != -1) {
						ripe[nx][ny] = true;
						box[nx][ny] = 1;
						q.offer(new int[] { nx, ny });
						// System.out.println("q children added : " + q.peek());
					}
				}
			}
			
//			for(int[] a : box)
//				System.out.println(Arrays.toString(a));
			
			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if(ripe[i][j] && box[i][j] > -1) {
//						box[i][j]++;
//					}
//				}
//			}
		}

	}

}
