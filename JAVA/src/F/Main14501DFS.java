package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501DFS {
	static int N;
	static int MAX = Integer.MIN_VALUE;
	static int[] T;
	static int[] P;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			if(i+T[i]>N) {
				continue;
			}
			else {
				MAX = Math.max(MAX, P[i]);
				DFS(i+T[i],P[i]);
			}
		}
		
		System.out.println(MAX);
	}
	
	static void DFS(int day, int sum) {
		for(int i=day; i<N; i++) {
			if(i+T[i]>N) {
				continue;
			}else {
				MAX = Math.max(MAX, sum+P[i]);
				DFS(i+T[i],sum+P[i]);
			}
		}
	}

}
