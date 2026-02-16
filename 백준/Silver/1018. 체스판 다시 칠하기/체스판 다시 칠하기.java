

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		st.nextToken();
		int N = (int) st.nval;
		st.nextToken();
		int M = (int) st.nval;
		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			st.nextToken();
			String line = st.sval;
			char[] temp = line.toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp[j];
			}
		}
//		for ( char[] a : board)
//			System.out.println(Arrays.toString(a));
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < N - 7; i++) {
			for (int j = 0; j < M - 7; j++) {
				
				int cnt = 0;
				// System.out.println("첫번쩨 자리 : " + board[i][j]);
				for (int i2 = i; i2 < i + 8; i2++) {
					for (int j2 = j; j2 < j + 8; j2++) {
						// System.out.print(board[i2][j2]);
						if ((i2 + j2) % 2 == 0) { // 첫칸과 동일
							if (board[i2][j2] != board[i][j]) {
								cnt++;
								// System.out.println("i, j changed : " + i2  + " "+ j2);
							}
								
						} else { // 첫칸과 달라야함
							if (board[i2][j2] == board[i][j]) {
								// System.out.println("i, j changed : " + i2 + " " + j2);
								cnt++;
							}
							
								
						}
					} // System.out.println();
				}
				int tmp = Math.min(cnt,  64-cnt);
				// System.out.println(tmp + "\n");
				if (tmp < min)
					min = tmp;
			}
		}
		System.out.println(min);
	}

}
