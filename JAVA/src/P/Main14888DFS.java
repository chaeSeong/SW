package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14888DFS {

	static boolean[] visited;
	static int[] num;
	static int[] op;
	static int n;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		int idx =0;
		num = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}	
		
		op = new int[n-1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			int cnt = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<cnt; j++) {
				op[idx++] = i+1;
			}
		}
		
		visited = new boolean[n-1];
		DFS(0,1,num[0],0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void DFS(int v, int idx, int sum, int d) {
		int result = 0;
		
		for(int i=0; i<visited.length; i++) {
			System.out.println(visited[i]);
		}
		System.out.println();
		
		if(d == n-1) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
		}else {
			for(int i=0; i<n-1;i++) {
				if(!visited[i]) {
					switch (op[i]) {
					case 1:
						result = sum+num[idx];
						break;
					case 2:
						result = sum-num[idx];
						break;
					case 3:
						result = sum*num[idx];
						break;
					case 4:
						result = sum/num[idx];
						break;
					}
					visited[i] = true;
					DFS(i,idx+1,result,d+1);
				}
			}
		}
		visited[v] = false;
	}
}
