
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, com[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		com = new int[M];
		dfs(0, 0);
		sc.close();
	}
	private static void dfs(int idx, int cnt) {
		if(cnt == M) {
			for(int a : com) System.out.print(a + " ");
			System.out.println();
			return;
		}
		if(idx >= N) return;
		com[cnt] = idx + 1;
		dfs(idx + 1, cnt + 1);
		dfs(idx + 1, cnt);
	}

}

