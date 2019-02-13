package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		int[] student = new int[cnt];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<cnt; i++) {
			student[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		
		for(int i=0; i<student.length; i++) {
			
			ans += 1;

			ans += (student[i]-m)/s;
			
			if((student[i]-m)%s !=0) {
				ans = ans+1;
			}
		}
		
		System.out.println(ans);
		
	}
}
