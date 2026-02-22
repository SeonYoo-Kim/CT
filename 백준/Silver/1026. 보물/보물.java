

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] a = new Integer[N]; // 재정렬
		Integer[] b = new Integer[N]; // 고정
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a, (a1, a2) -> a2 - a1);
		Arrays.sort(b, (b1, b2) -> b1 - b2);
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += a[i] * b[i];
		}
		System.out.println(sum);
	}

}
