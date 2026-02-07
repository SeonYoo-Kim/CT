

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int A = Integer.parseInt(br.readLine());
    	int B = Integer.parseInt(br.readLine());
    	int C = Integer.parseInt(br.readLine());
    	char[] arr = ((A*B*C)+"").toCharArray();
    	int[] idx = new int[10];
    	for(int i = 0; i<arr.length; i++) {
    		idx[arr[i]-'0']++;
    	}for(int i = 0; i<10; i++) {
    		System.out.println(idx[i]);
    	}
    	
    }
    	
}
