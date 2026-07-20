import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());
        
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day1 = d1, day2 = d2;
        
        for (int i = 0; i < m1; i++) 
            day1 += months[i];
        for (int i = 0; i < m2; i++) 
            day2 += months[i];
        
        //int idx = ((day2-day1) % 7 + 7) % 7;
        int idx = Math.floorMod(day2 - day1, 7);
        System.out.println(days[idx]);

    }
}