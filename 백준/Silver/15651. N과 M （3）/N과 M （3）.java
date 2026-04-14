
import java.util.Scanner;

public class Main {
	static int N, M, comb[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		comb = new int[M];
		dfs(0);
		System.out.println(sb);
		sc.close();
	}

	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int a : comb) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			comb[cnt] = i + 1;
			dfs(cnt + 1);
		}
	}
}
