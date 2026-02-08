
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			byte[][] board = new byte[N][N];
			int cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextByte();
				}
			}

			for (int i = 0; i < N; i++) {
				int lenCol = 0;
				int lenRow = 0;

				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						lenCol++;
						if (j + 1 == N || board[i][j + 1] == 0) {
							if (lenCol == K) {
								cnt++;
								lenCol = 0;
								// System.out.println("가로 x : " + i + ", y : " + j);
							}

						}
					} else
						lenCol = 0;
					if (board[j][i] == 1) {
						lenRow++;
						if (j + 1 == N || board[j + 1][i] == 0) {
							if (lenRow == K) {
								cnt++;
								lenRow = 0;
								// System.out.println("세로 x : " + j + ", y : " + i);
							}

						}
					} else
						lenRow = 0;

				}

			}

			System.out.println("#" + tc + " " + cnt);
		}

	}

}
