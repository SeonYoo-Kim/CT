

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int[] arr = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for (int i = 0; i<N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}//System.out.println(Arrays.toString(arr));
    	int v = Integer.parseInt(br.readLine());
    	int cnt = 0;
    	for (int i = 0; i<N; i++) {
    		if(arr[i] == v)cnt++;
    	}
    	System.out.println(cnt);
    }
}
