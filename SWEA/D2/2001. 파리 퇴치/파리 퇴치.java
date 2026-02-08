
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] board = new int[N][N];
			int[][] prefix = new int[N + 1][N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			for(int[] a : board)
//				System.out.println(Arrays.toString(a));
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					prefix[i][j] = board[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
				}
			}
			int max = 0;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					int sum = prefix[i][j] - prefix[i - M][j] - prefix[i][j - M] + prefix[i - M][j - M];
					if(sum > max) max = sum;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
