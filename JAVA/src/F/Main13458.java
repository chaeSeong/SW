package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int major = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		
		int cnt =0;
		
		for(int i=0; i<N; i++) {
			arr[i] -= major;
			cnt++;
			
			if(arr[i] > 0) {
				if(arr[i] % sub ==0) {
					cnt +=(arr[i]/sub);
				}else {
					cnt += (arr[i] / sub)+1;
				}
			}
		}
		System.out.println(cnt);
	}
}
