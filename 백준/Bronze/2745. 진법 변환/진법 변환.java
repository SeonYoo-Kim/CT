

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next().trim();
		char[] numbers = num.toCharArray();
		int n = sc.nextInt();
		// System.out.println(num + n);
//		char[] list = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
//				'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

//		System.out.println('Z' - 55); // 35
//		System.out.println('A' - 55); // 10
//		System.out.println('9' - 48); // 9
		int sum = 0;
		for (int i = numbers.length - 1; i >= 0; i--) {
//			System.out.println(numbers[i] - 55);
//			System.out.println(Math.pow(n, numbers.length - i-1));
			if (0 <= numbers[i] - 48 && numbers[i] - 48 < 10) {
				sum += (numbers[i] - 48) * Math.pow(n, numbers.length - i-1); 
				
			} else {
				//sum += list[numbers[i] - 55] * Math.pow(n, numbers.length - i-1);
				sum += (numbers[i] - 55) * Math.pow(n, numbers.length - i-1);
			}
		}
		System.out.println(sum);
	}

}
