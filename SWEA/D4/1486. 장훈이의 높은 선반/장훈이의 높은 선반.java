
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int B, N, heights[], min;
	static boolean[] selected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			heights = new int[N];
			selected = new boolean[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}

			System.out.println("#" + tc + " " + subSet(0, 0));
		}
	}

	private static int subSet(int sum, int idx) {
		if (sum >= B) {
			if (sum - B < min) {
				min = sum - B;
				// System.out.println("min : " + min + ", sum : " + sum + ", B : " + B);
			}
			return min;
		}
		if (idx >= N) return min;
		if ( selected[idx])
			return min;

		selected[idx] = true;
		subSet(sum + heights[idx], idx + 1);
		selected[idx] = false;
		subSet(sum, idx + 1);

		return min;
	}

}
