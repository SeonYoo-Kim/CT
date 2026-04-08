
import java.util.List;
import java.util.Scanner;

public class Main{

	static boolean selected[];
	static int M, N, arr[];
	static List<int[]> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		selected = new boolean[N];
		arr = new int[M];
		comb(0, sb);

		System.out.println(sb);
	}

	private static void comb(int cnt, StringBuilder sb) {
		if (cnt == M) {
			for (int i = 0; i < M; i++)
				sb.append(arr[i]).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!selected[i]) {
				selected[i] = true;
				arr[cnt] = i + 1;
				comb(cnt + 1, sb);
				selected[i] = false;
			}
		}
	}
}
