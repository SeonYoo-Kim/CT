

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] plan, price;
	static int minPrice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			plan = new int[12];

			// day, month, 3 months, year
			price = new int[4];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < plan.length; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			}

			minPrice = price[3]; // 1년권 사용

			usePackages(0, 0);

			System.out.println("#" + tc + " " + minPrice);
		}
	}

	private static void usePackages(int month, int sum) {
		if (sum >= minPrice)
			return;
		if (month >= 12) {
			// System.out.println(minPrice);
			if (sum < minPrice)
				minPrice = sum;

			return;
		}
		if (plan[month] == 0) {
			usePackages(month + 1, sum);
			return;
		}

		// 이번달을 3개월권으로 할지
		usePackages(month + 3, sum + price[2]);

		// 1개월권으로 할지?
		usePackages(month + 1, sum + price[1]);

		// 일일권으로 할지
		usePackages(month + 1, sum + (price[0] * plan[month]));

	}

}
