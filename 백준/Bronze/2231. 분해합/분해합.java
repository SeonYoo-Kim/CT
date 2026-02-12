
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String num = String.valueOf(N);

		for (int i = N - (num.length() * 10); i < N; i++) {
			int tmp = i;
			int sum = i;
			while (tmp > 0) {
				sum += (tmp % 10);
				tmp /= 10;
			}
			if(sum==N) {
				System.out.println(i);
				return;
			}

		}
		System.out.println(0);

	}

}
