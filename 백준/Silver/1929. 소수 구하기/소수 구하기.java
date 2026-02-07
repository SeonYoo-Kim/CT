import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] NotPrime = new boolean[N + 1];
		
		NotPrime[0] = NotPrime[1] = true;

		for (int i = 2; i * i <= N; i++) {
			if (NotPrime[i] == true) continue;
			for(int j = i + i; j <= N; j+=i) {
				NotPrime[j] = true;
			}
		}
		for (int i = M ; i < N + 1; i++) {
			if(NotPrime[i] == false) System.out.println(i);
		}
		
		
	}

}
