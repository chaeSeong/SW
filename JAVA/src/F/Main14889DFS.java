package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889DFS {
	static int[][] map;
	static boolean[] visited;
	static int N;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0,0);
		System.out.println(ans);
	}
	
	static void DFS(int v, int len) {
		if(N/2 == len) {
			divideTeam();
		}else {
			for(int i=v+1; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					DFS(i,len+1);
				}
			}
		}
		visited[v] = false;
	}
	
	static void divideTeam() {
		int[] a = new int[N/2];
		int[] b = new int[N/2];
		int ai = 0;
		int bi = 0;
		
		for(int i=0; i<N; i++) {
			if(visited[i]) {
				a[ai++] = i;
			}else {
				b[bi++] = i;
			}
		}
		 
		int aStat = getStat(a);
		int bStat = getStat(b);
		int diff = Math.abs(aStat - bStat);
		if(ans>diff) {
			ans = diff;
		}
		
	}
	
	static int getStat(int[] arr) {
		int result = 0;
		int len = N/2;
		
		for(int i=0; i<len; i++) {
			for(int j=i+1; j<len; j++) {
				result += map[arr[i]][arr[j]];
				result += map[arr[j]][arr[i]];
			}
		}
		return result;
		
	}
}
