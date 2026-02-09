
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int winCnt, loseCnt, N = 9;
	static int[] kyuyung, inyung;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			winCnt = 0;
			loseCnt = 0;
			kyuyung = new int[N];
			inyung = new int[N];
			boolean[] selected = new boolean[2 * N + 1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				kyuyung[i] = Integer.parseInt(st.nextToken());
				selected[kyuyung[i]] = true;
			} // System.out.println("규영이 : "+Arrays.toString(kyuyung));
			int idx = 0;
			for (int i = 1; i <= 2 * N; i++) {
				if (!selected[i])
					inyung[idx++] = i;
			} // System.out.println("인영이 : "+Arrays.toString(inyung));
			Arrays.sort(inyung);
			do {
				int kyuScore = 0, inScore = 0;
				for (int i = 0; i < N; i++) {
					if (inyung[i] < kyuyung[i]) {
						kyuScore += inyung[i] + kyuyung[i];
					} else
						inScore += inyung[i] + kyuyung[i];
				}
				if (kyuScore > inScore)
					winCnt++;
				else
					loseCnt++;
				// System.out.println("#" + winCnt + " " + loseCnt);
			} while (np());
			System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
		}
	}

	private static boolean np() {
		int i = N - 1;
		while (i >= 1 && inyung[i - 1] > inyung[i])
			i--;

		if (i == 0)
			return false;

		int j = N - 1;
		while (inyung[i - 1] > inyung[j])
			j--;

		swap(i - 1, j);

		int k = N - 1;
		while (i < k) {
			swap(i++, k--);
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = inyung[i];
		inyung[i] = inyung[j];
		inyung[j] = temp;
	}

}
