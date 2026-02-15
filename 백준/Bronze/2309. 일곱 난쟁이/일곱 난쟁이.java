import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static boolean[] selected;
	static int[] heights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		heights = new int[9];
		selected = new boolean[9];
		for (int i = 0; i < 9; i++) {
			heights[i] = sc.nextInt();
		}
		Arrays.sort(heights);

		subset(0, 0, 0);

	}

	private static void subset(int idx, int cnt, int sum) {
		if (cnt == 7 && sum == 100) {
			for (int i = 0; i < 9; i++) {
				if (selected[i]) {
					System.out.println(heights[i]);
				}
			}
			System.exit(0);
		}
		if (idx >= 9 || cnt > 7 || sum > 100)
			return;

		selected[idx] = true;
		subset(idx + 1, cnt + 1, sum + heights[idx]);
		selected[idx] = false;
		subset(idx + 1, cnt, sum);

	}

}
