

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] list = new boolean[30];
		for (int i = 0; i < 28; i++) {
			list[sc.nextInt() - 1] = true;
		}
		for (int i = 0; i < 30; i++) {
			if (!list[i])
				System.out.println(i + 1);
		}
	}

}
