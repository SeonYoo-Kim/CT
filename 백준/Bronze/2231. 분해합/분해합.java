import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine().trim();
		int n = Integer.parseInt(num);
		int search = num.length() * 10;

		for (int i = n - search; i < n; i++) {
			int test = i;
			int sum = test;
			while (test>0) {
				sum += test%10;
				test/=10;
			}
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}System.out.println(0);
	}

}
