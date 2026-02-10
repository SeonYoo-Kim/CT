import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static boolean[] col, slash, bSlash;
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			col = new boolean[N];
			slash = new boolean[N * 2 - 1];
			bSlash = new boolean[N * 2 - 1];
			
			cnt = 0;
			setQueen(0);

			System.out.println("#" + tc + " " + cnt);
		}

	}

	static void setQueen(int row) {
		if (row >= N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {

			if (col[c] || slash[row + c] || bSlash[row - c + N - 1])
				continue;
			else {
				col[c] = slash[row + c] = bSlash[row - c + N - 1] = true;
				setQueen(row + 1);
				col[c] = slash[row + c] = bSlash[row - c + N - 1] = false;
			}
		}

	}

}
