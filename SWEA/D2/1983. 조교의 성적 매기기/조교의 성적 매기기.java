
import java.util.Arrays;
import java.util.Scanner;

public class Solution{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] score = new int[N];

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt() * 35 + sc.nextInt() * 45 + sc.nextInt() * 20;
			}

			int[] sorted = score.clone();
			Arrays.sort(sorted);
			int cutLine = N/10;
			String[] grade = new String[N];

			for (int i = 0; i < N; i++) {

				if(score[i] >= sorted[0] && score[i] < sorted[cutLine]) {
					grade[i] = "D";
				} else if(score[i] >= sorted[cutLine] && score[i] < sorted[cutLine*2]) {
					grade[i] = "C-";
				}else if(score[i] >= sorted[cutLine*2] && score[i] < sorted[cutLine*3]) {
					grade[i] = "C0";
				}else if(score[i] >= sorted[cutLine*3] && score[i] < sorted[cutLine*4]) {
					grade[i] = "C+";
				}else if(score[i] >= sorted[cutLine*4] && score[i] < sorted[cutLine*5]) {
					grade[i] = "B-";
				}else if(score[i] >= sorted[cutLine*5] && score[i] < sorted[cutLine*6]) {
					grade[i] = "B0";
				}else if(score[i] >= sorted[cutLine*6] && score[i] < sorted[cutLine*7]) {
					grade[i] = "B+";
				}else if(score[i] >= sorted[cutLine*7] && score[i] < sorted[cutLine*8]) {
					grade[i] = "A-";
				}else if(score[i] >= sorted[cutLine*8] && score[i] < sorted[cutLine*9]) {
					grade[i] = "A0";
				}else
					grade[i] = "A+";
				
				
			}			
			
			System.out.println("#" + tc + " " + grade[K-1]);

		}

	}

}
