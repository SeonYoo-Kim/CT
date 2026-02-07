

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[] arr = new int[9];
    	for(int i = 0; i<9; i++) {
    		arr[i] = Integer.parseInt(br.readLine());
    	}//System.out.println(Arrays.toString(arr));
    	int max = 0, max_index = 0;
    	for(int i = 0; i<9; i++) {
    		if (arr[i] > max) {
    			max = arr[i];
    			max_index = i + 1;
    		}
    	}
    	System.out.println(max + "\n" + max_index);
    }
}
