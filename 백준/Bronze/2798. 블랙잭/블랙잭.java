
import java.util.Scanner;

public class Main{
	static int M, N, max = 0;
	static int[] cards;
	static int min = Integer.MAX_VALUE;
	static int asw = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		} // System.out.println(Arrays.toString(cards));
		select(0, 0, 0);
		System.out.println(max);
		
		
	}

	private static void select(int cnt, int sum, int index) {
		if(sum > M) {
			return;
		}
		if(cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		if(index == N) {
			return;
		}
		select(cnt+1, sum+cards[index], index+1);
		select(cnt, sum, index+1);
	}

}
