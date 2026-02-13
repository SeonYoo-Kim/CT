
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i);
			char[] arr = s.toCharArray();
			int cnt = 0;
			boolean isThree = false;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '3' || arr[j] == '6' || arr[j] == '9') {
					isThree = true;
					cnt++;
				}
			}
			if (isThree) {
				for (int j = 0; j < cnt; j++) {
					sb.append("-");
				}
			} else
				sb.append(i);

			sb.append(" ");

		}
		System.out.println(sb);
	}

}
