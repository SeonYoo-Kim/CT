
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		int a1 = A % 10;
		int a2 = A / 10 % 10;
		int a3 = A / 100;
		int b1 = B % 10;
		int b2 = B / 10 % 10;
		int b3 = B / 100;

		int reA = 100 * a1 + 10 * a2 + a3;
		int reB = 100 * b1 + 10 * b2 + b3;
		System.out.println(reA > reB ? reA : reB);

	}

}

