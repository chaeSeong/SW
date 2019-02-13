package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15403DFS {
	static int N;
	static int M;
	static int row;
	static int col;
	static int dir;
	static int[] nx = {-1,1,0,0};
	static int[] ny = {0,0,-1,1};
	static int[][] arr;
	static int clear;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(row,col,dir);
		System.out.println(clear);
	}
	static void DFS(int row, int col, int dir) {
		//좌표가 벽일 경우
		if(arr[row][col] == 1) {
			return;
		}
		//청소 안되어있을 경우 청소
		if(arr[row][col] == 0) {
			arr[row][col] = 2;
			clear++;
		}
		
		for(int i=0; i<4; i++) {
			int dd = (dir+3)%4;
			int dx = nx[dd] + row;
			int dy = ny[dd] + col;
			
			if(arr[dx][dy] == 0) {
				DFS(dx, dy, dd);
				return;
			}else {
				dir = dd;
			}
		}
		
		//move
		
	}

}
