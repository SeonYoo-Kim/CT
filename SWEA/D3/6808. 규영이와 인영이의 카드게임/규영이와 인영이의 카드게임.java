import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int winCnt, loseCnt, N = 9;
	static int[] kyu, in;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			winCnt = 0;
			loseCnt = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			kyu = new int[N];
			in = new int[N];
			selected = new boolean[N * 2 + 1];
			for (int i = 0; i < N; i++) {
				kyu[i] = Integer.parseInt(st.nextToken());
				selected[kyu[i]] = true;
			}
			int idx = 0;
			for (int i = 1; i <= N * 2; i++) {
				if (!selected[i])
					in[idx++] = i;
			}
//			System.out.println("규영 : "+Arrays.toString(kyu));
//			System.out.println("인영 : "+Arrays.toString(in));
			Arrays.sort(in);
			do {
				int kScore = 0, iScore = 0;
				for (int i = 0; i < N; i++) {
					if (kyu[i] > in[i])
						kScore += kyu[i] + in[i];
					else
						iScore += kyu[i] + in[i];
				}
				if (kScore > iScore)
					winCnt++;
				else
					loseCnt++;
			} while (np());

			System.out.println("#" + tc + " " + winCnt + " " + loseCnt);
		}

	}

	private static boolean np() {
		// System.out.println("in next permutation");

		int i = N - 1;
		while (i >= 1 && in[i - 1] > in[i]) i--;

		if (i == 0) return false;

		int j = N - 1;
		while (in[i - 1] > in[j]) j--;
		//System.out.println(i + " " + j);
		swap(i - 1, j);

		int k = N - 1;
		while (i < k) swap(i++, k--);

		return true;
	}

	private static void swap(int i, int j) {
		int temp = in[i];
		in[i] = in[j];
		in[j] = temp;
	}

}
