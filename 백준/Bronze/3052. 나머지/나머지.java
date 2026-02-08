import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] check = new boolean[42];
		for (int i = 0; i < 10; i++) {
			check[sc.nextInt()%42] = true;
		}
		int cnt = 0;
		for (boolean a : check) {
			if(a) cnt++;
		}
		System.out.println(cnt);
	}

}
