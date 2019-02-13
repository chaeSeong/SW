package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178BFS {
	static int R;
	static int C;
	static int[][] arr;
	static boolean[][] visited;
	
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
		
		arr = new int[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j) - 48;
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 1 && visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(arr[R-1][C-1]);
	}
	
	static void bfs(int r, int c) {
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(r, c));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				
				int nr = p.r+dr[i];
				int nc = p.c+dc[i];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(arr[nr][nc] == 1 && visited[nr][nc]) {
						q.offer(new Pair(nr, nc));
						arr[nr][nc] = arr[p.r][p.c]+1;
					}
				}
			}
		}
		
	}
	
}
