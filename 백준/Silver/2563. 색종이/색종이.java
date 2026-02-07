

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int papers = Integer.parseInt(br.readLine());
		int[][] white = new int[100][100];
		
		for (int i = 0; i < papers; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int j = x; j<x+10;j++) {
				for(int k = y; k<y+10;k++) {
					white[j][k] = 1;
				}
			}
		}
		
		int sum = 0;
		
		for(int j = 0; j<100;j++) {
			for(int k = 0; k<100;k++) {
				sum += white[j][k];
			}
		}
		System.out.println(sum);
	}

}
