import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static boolean selected[];
	static int N, M, per[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		selected = new boolean[N];
		per = new int[M];
		dfs(0);
		sc.close();
	}
	private static void dfs(int cnt) {
		
		if(cnt == M) {
			for(int a : per)
				System.out.print(a + " ");
			System.out.println();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			per[cnt] = i + 1;
			dfs(cnt + 1);
			selected[i] = false;
		}
		
		
	}

}
