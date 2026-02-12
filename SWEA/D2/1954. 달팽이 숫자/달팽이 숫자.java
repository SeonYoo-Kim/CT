
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Solution {
	static int[][] arr;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		StringBuilder sb = new StringBuilder();
		st.nextToken();
		int T = (int) st.nval;
		for (int tc = 1; tc <= T; tc++) {
			
			st.nextToken();
			N = (int) st.nval;
			arr = new int[N][N];

			snail(0, 0, 0, 1);
			
//			for(int[]a:arr)
//				System.out.println(Arrays.toString(a));
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}System.out.println(sb);
	}

	private static void snail(int x, int y, int dir, int val) {
		
		if (val > N*N)
			return;
//		System.out.println("snail cnt : " + val);
//		System.out.println("x, y = " + x + ", " + y);
		arr[x][y] = val;
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];

		if (nx < 0 || nx > N-1  || ny < 0 || ny > N-1  || arr[nx][ny] != 0) {
			dir++;
			dir %= 4;
		}

		// System.out.println("dir : " + dir +" || x : " + x + " || nx : " + (x+dx[dir]) + "|| y : " + y + " || ny : " + (y+dy[dir]));
		snail(x + dx[dir], y + dy[dir], dir, val + 1);

	}

}