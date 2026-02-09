
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] talls = new int[9];
	static boolean[] selected = new boolean[9];
	static boolean done;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < talls.length; i++) {
			talls[i] = sc.nextInt();
		}
		Arrays.sort(talls);
		subset(0, 0, 0);
		
	}
	private static void subset(int idx, int cnt, int sum) {
		if(cnt > 7) return;
		if(! done && cnt == 7 && sum == 100) {
			for (int i = 0; i < 9; i++)
				if(selected[i])
					System.out.println(talls[i]);
			done = true;
			return;
		}
		if(idx >= 9) return;
		
		selected[idx] = true;
		subset(idx+1, cnt+1, sum + talls[idx]);
		selected[idx] = false;
		subset(idx+1, cnt, sum);
		
	}

}
