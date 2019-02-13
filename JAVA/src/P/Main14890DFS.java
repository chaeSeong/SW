package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14890DFS {
	static int[][] map1;
	static int[][] map2;
	static int N;
	static int L;
	static int result = 0;
	static int[] slop;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map1 = new int[N][N];
		map2 = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map1[i][j] = map2[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			checkBuild(i,map1);
			checkBuild(i,map2);
		}
		System.out.println(result);
	}

	static void checkBuild(int index, int[][] arr) {
		slop = new int[N];
		for(int i = 0; i<N; i++) {
			if(arr[index][i] != arr[index][i+1]) {
				int diff = arr[index][i] - arr[index][i+1];
				
				if(diff != -1 && diff !=1) {
					return;
				}
				
				if(diff == -1) {
					for(int j=0; j<L; j++) {
						if(i-j <0 || slop[i-j]==1) {
							slop[i-j] = 1;
						}else {
							return;
						}
					}
				}else {
					for(int j=1; j<=L; j++) {
						if(i+j >= N || slop[i+j]==1)return;
						
					}
				}
			}
		}
	}
}
