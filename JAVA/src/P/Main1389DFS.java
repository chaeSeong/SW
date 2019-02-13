package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1389DFS {
	static int M;
	static int[][] map;
	static int[][] connected;
	
	static int N;
	static int C;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		map = new int[M][M];
		connected = new int[M][M];
		N = Integer.parseInt(st.nextToken());
		
		//map 만들기
		for(int k=0; k<N; k++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
	
		for(int k=0; k<N; k++) {
			System.out.println("k="+k);
			for(int i=0; i<M; i++) {
				for(int j=0; j<M; j++) {
					System.out.println("K="+k+" i= "+i + "j= "+j);
					if(map[i][j]==1) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}

		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	static void DFS(int m, int n) {
		
	}
}
