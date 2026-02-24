
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		boolean[] selected = new boolean[N + 1];
		int[][] network = new int[C][2];
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			network[i][0] = Integer.parseInt(st.nextToken());
			network[i][1] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		selected[1] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < C; i++) {
				if(network[i][0] == cur) {
					if(!selected[network[i][1]]) {
						q.offer(network[i][1]);
						selected[network[i][1]] = true;
					}
				}
				if(network[i][1] == cur) {
					if(!selected[network[i][0]]) {
						q.offer(network[i][0]);
						selected[network[i][0]] = true;
					}
				}
			}
		}
		
		int cnt = 0;
		for(boolean s : selected)
			if(s)cnt++;
		System.out.println(cnt - 1);
	}

}
