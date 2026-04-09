
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution{
	static int N, op[], arr[], max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			op = new int[4];
			for (int i = 0; i < 4; i++)
				op[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			calc(arr[0], 0);

			System.out.println("#" + tc + " " + (max - min));
		}
	}

	private static void calc(int sum, int len) {
		if (len == N - 1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		if (op[0] > 0) {
			op[0]--;
			calc(sum + arr[len+1], len + 1);
			op[0]++;
		}
		if (op[1] > 0) {
			op[1]--;
			calc(sum - arr[len+1], len + 1);
			op[1]++;
		}
		if (op[2] > 0) {
			op[2]--;
			calc(sum * arr[len+1], len + 1);
			op[2]++;
		}
		if (op[3] > 0) {
			op[3]--;
			calc(sum / arr[len+1], len + 1);
			op[3]++;
		}
	}
}
