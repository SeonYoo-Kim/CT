import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        String[] n = br.readLine().split("");
        
        
        int sum = 0, idx = 0;
        
        for (int i = n.length - 1; i >= 0; i--) {
            int t = Integer.parseInt(n[i]);
            for (int j = 0; j < idx; j++) {
                t *= a;
            }
            idx++;
            sum += t;
        }
    
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            sb.append(sum%b);
            
            if(sum<b)break;
            sum/=b;
        }
        System.out.println(sb.reverse());
        
    }

}
