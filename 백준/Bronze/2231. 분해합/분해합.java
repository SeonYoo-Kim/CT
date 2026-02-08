
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine().trim();
		int n = Integer.valueOf(num);
		
		for (int i = n-(num.length()*10); i < n; i++) {
			// System.out.println("===== i : " + i +"=====");
			int sum = i;
			int tmp = i;
			for (int j = 1; j <= num.length(); j++) {
				// System.out.println("+++++ j : " + j +"+++++ " + (tmp % 10));
				sum += tmp % 10;
				tmp /= 10;
			}if(sum == n) {
				System.out.println(i);
				return;
			}
		}System.out.println(0);
	}

}
