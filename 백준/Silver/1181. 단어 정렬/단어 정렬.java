
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		// System.out.println(set);
		String[] arr = set.toArray(new String[0]); //오~~!! 
		// String[] arr = set.toArray(new String[set.size()]); 이것도 되기는함 

		Arrays.sort(arr, (s1, s2) ->{
			if(s1.length()==s2.length())
				return s1.compareTo(s2);
			return s1.length()-s2.length();
		});
		for(String a : arr)
		System.out.println(a);
		
	}

}
