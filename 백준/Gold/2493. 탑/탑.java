import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> tower = new Stack<>();		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int max = 0;
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			while(!tower.isEmpty() && tower.peek()[1] < height) 
				tower.pop();
			
			
			if(tower.isEmpty()) sb.append("0 ");
			else sb.append(tower.peek()[0]).append(" ");
			
			tower.push(new int[] {i + 1, height});
			
		}
		System.out.println(sb);
	}

}
