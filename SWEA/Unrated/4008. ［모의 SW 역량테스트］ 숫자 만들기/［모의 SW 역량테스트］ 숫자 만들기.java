import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int min, max, N, operator[], nums[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			operator = new int[4]; // +, -, *, /
			for (int i = 0; i < 4; i++)
				operator[i] = Integer.parseInt(st.nextToken());

			nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				nums[i] = Integer.parseInt(st.nextToken());

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			calculate(1, nums[0]);
			System.out.println("#" + tc + " " + (max - min));
		}
	}
	private static void calculate(int used, int result) {
		if (used == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if (operator[0] > 0) {
			operator[0]--;
			calculate(used + 1, result + nums[used]);
			operator[0]++;
		}
		if (operator[1] > 0) {
			operator[1]--;
			calculate(used + 1, result - nums[used]);
			operator[1]++;
		}
		if (operator[2] > 0) {
			operator[2]--;
			calculate(used + 1, result * nums[used]);
			operator[2]++;
		}
		if (operator[3] > 0) {
			operator[3]--;
			calculate(used + 1, result / nums[used]);
			operator[3]++;
		}
	}
}