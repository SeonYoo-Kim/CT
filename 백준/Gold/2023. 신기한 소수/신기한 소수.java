
import java.util.Scanner;

public class Main {
	static int arr[], N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		sb = new StringBuilder();
		dfs(2, 0);
		dfs(3, 0);
		dfs(5, 0);
		dfs(7, 0);
		System.out.println(sb);
	}

	private static void dfs(int num, int len) {
		if(len == N - 1) {
			sb.append(num).append("\n");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			int next = num * 10 + i;
			if(isPrime(next)) dfs(next, len + 1);
		}
	}

	private static boolean isPrime(int next) {
		boolean prime = true;
		for (int i = 2; i <= Math.sqrt(next); i ++)
			if(next % i == 0) {
				prime = false;
				break;
			}
		return prime;
	}
}
