import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] result = new int[N];
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!stack.isEmpty() && stack.peek()[1] < height) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				result[i] = stack.peek()[0];
			}

			stack.push(new int[] { i + 1, height });
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb);
	}

}