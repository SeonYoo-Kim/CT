

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int B = sc.nextInt();
		String[] list = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
				"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		List<String> asw = new ArrayList<>();

		while (N > 0) {
			int tmp = N % B;
			N /= B;
			asw.add(list[tmp]);
		}
		for (int i = asw.size() - 1; i >= 0; i--) {
			sb.append(asw.get(i));
		}
//		System.out.println('A' - 1);
//		System.out.println(list.length);
//		System.out.println((char) 60);
		System.out.println(sb);

	}

}
