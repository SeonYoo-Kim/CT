

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Score{
		int paper;
		int interview;
		
		public Score(int paper, int interview) {
			super();
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public String toString() {
			return "Score [paper=" + paper + ", interview=" + interview + "]";
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Score[] score = new Score[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				score[i] = new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			// 면접 오름차순 정렬
			Arrays.sort(score, (s1, s2) -> s1.interview - s2.interview); 
			// 서류값 비교필요
			int minPaper = Integer.MAX_VALUE;
			int cnt = 0;
			for(Score a : score) {
				if(a.paper < minPaper) minPaper = a.paper;
				if(a.paper > minPaper) cnt++;
				
			}
System.out.println(N - cnt);

		}
	}

}
