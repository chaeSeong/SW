package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14500BFS {
	static int R;
	static int C;
	static int[][] map;
	static boolean[][] visited;
	
	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int MAX = -1;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>MAX) {
					MAX = map[i][j];
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(MAX == map[i][j]) {
					BFS(i,j);
				}
			}
		}
	}
	static void BFS(int r, int c) {
		Queue<Pair> q = new LinkedList<>();
		visited = new boolean[R][C];
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		int qr=0, qc=0;
		
		q.offer(new Pair(r,c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int max =-1;
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				
				if(nr>=0 && nc>=0 && nr<R && nc <C) {
					if(max<map[nr][nc]) {
						max = map[nr][nc];
						qr = nr;
						qc = nc;
					}
				}
			}
			q.offer(new Pair(qr,qc));			
		}
	}

}
