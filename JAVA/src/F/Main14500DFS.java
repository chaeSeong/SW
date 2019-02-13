package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500DFS {
	static int R;
	static int C;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		max=0;
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<R; i++) {
			for(int j=0; j<C; j++) {
				DFS(i,j,0,0);
				Exception(i,j);
			}
		}
		System.out.println(max);
			
	}
	
	public static void DFS(int r, int c, int depth, int sum) {
		
		if(depth==4) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<0 || nc<0 || nr>=R || nc>=C) {
				continue;
			}
			if(visited[nr][nc]) {
				continue;
			}
			
			visited[nr][nc] = true;
			DFS(nr, nc, depth+1, sum+map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	public static void Exception(int r, int c) {
		int wing = 4;
		int min = Integer.MAX_VALUE;
		int sum = map[r][c];
		
		for(int i=0; i<4; i++) {
			int nr = r +dr[i];
			int nc = c +dc[i];
			
			if(wing<=2) {
				return;
			}
			
			if(nr < 0 || nc < 0 || nr>=R || nc>=C) {
				wing--;
				continue;
			}
			
			min = Math.min(min, map[nr][nc]);
			sum = sum + map[nr][nc];
		}
		
		if(wing == 4) {
			sum = sum - min;
		}
		
		max = Math.max(max, sum);
	}
}
