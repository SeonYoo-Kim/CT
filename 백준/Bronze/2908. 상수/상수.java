
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();

		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		char tmpA = a[0];
		char tmpB = b[0];
		a[0] = a[2];
		a[2] = tmpA;
		b[0] = b[2];
		b[2] = tmpB;

		int resultA = 100 * (a[0]-'0') + 10 * (a[1]-'0') + (a[2]-'0');
		int resultB = 100 * (b[0]-'0') + 10 * (b[1]-'0') + (b[2]-'0');

		System.out.println(Math.max(resultA, resultB));

	}

}
