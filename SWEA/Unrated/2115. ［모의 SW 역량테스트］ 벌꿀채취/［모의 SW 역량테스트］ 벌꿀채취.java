import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map, maxMap;
	static int M, C, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			maxMap = new int[N][N - M + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + tc + " " + getMaxBenifit());
		}
	}

	private static int getMaxBenifit() {
		makeMaxMap();
		return processCombination();
	}

	private static void makeMaxMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				subSet(i, j, 0, 0, 0);
			}
		}

	}

	private static void subSet(int i, int j, int sum, int cnt, int profit) {
		if (sum > C)
			return;
		if (cnt == M) {
			// 최대이익 계산
			if (maxMap[i][j - M] < profit)
				maxMap[i][j - M] = profit;
			return;
		}
		subSet(i, j + 1, sum + map[i][j], cnt + 1, profit + (map[i][j] * map[i][j]));
		subSet(i, j + 1, sum, cnt + 1, profit);

	}

	private static int processCombination() {
		// a와 b의 선택
		int a, b, max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				a = maxMap[i][j];
				b = 0;
				for (int i2 = i; i2 < N; i2++) {
					int start = (i == i2 ? j + M : 0);
					for (int j2 = start; j2 < N - M + 1; j2++) {
						if (b < maxMap[i2][j2])
							b = maxMap[i2][j2];
					}
				}
				if (a + b > max)
					max = a + b;
			}
		}

		return max;
	}

}
