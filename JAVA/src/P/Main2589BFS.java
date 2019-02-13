package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2589BFS {
	static int R;
	static int C;
	static char[][] map;
	static int[][] arr;
	static boolean[][] visited;
	static int max;
	
	static class Pair{
		int r,c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
//		arr = new int[R][C];
		
		//입력
		
		max = -1;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'L' && !visited[i][j]) {
					BFS(i,j);
					visited = new boolean[R][C];
				}
			}
		}
		System.out.println(max);
	}
	
	static void BFS(int r, int c) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};

		arr = new int[R][C];
		
		visited[r][c] = true;
		int cnt =0;
		arr[r][c] = cnt;
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(r, c));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(map[nr][nc]=='L' && !visited[nr][nc]) {
						visited[nr][nc] = true;
						arr[nr][nc] = arr[p.r][p.c]+1;
						cnt+=1;
						q.offer(new Pair(nr, nc));
					}
				}
			}
		}
		
//		for(int i=0; i<R; i++) {
//			for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		for(int i=0;i<R; i++) {
			for(int j=0; j<C; j++) {
				if(max<arr[i][j]) {
					max = arr[i][j];
				}
			}
		}
//		System.out.println("max : " + max);
//		if(max == 8)
//		{
//			for(int i=0;i<R; i++) {
//				for(int j=0; j<C; j++) {
//				System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}
//		}
		
	}
}
