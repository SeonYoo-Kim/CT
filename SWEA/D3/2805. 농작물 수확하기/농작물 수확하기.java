
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int n = N / 2;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char[] arr = st.nextToken().toCharArray();
//				System.out.println(Arrays.toString(arr));
				for (int j = 0; j < N; j++) {
					if (!(i + j < n || i + j > 3*n || i - j < (-1*n) || i - j > n)) {
						/*
						 * x+y가 2 미만이나 6 초과 x-y+4가 2 미만이나 6 초과
						 */

						sum += arr[j] - '0';
						// System.out.print(arr[j] - '0' + " ");
					}

				} // System.out.println();
			}

			System.out.println("#" + tc + " " + sum);
		}

	}

}
