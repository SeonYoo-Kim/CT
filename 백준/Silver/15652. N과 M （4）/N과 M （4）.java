import java.util.Scanner;

public class Main {
	static int N, M, perm[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		perm = new int[M];
		dfs(0, 0);
		System.out.println(sb);
		sc.close();
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == M) {
			for(int a : perm) sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		for (int i = idx; i < N; i++) {
			perm[cnt] = i + 1;
			dfs(i, cnt + 1);
		}
		
	}

}
