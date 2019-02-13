package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1012BFS {

	static int R;
	static int C;
	static int test;
	static int TC;
	static int[][] map;
	static boolean[][] visited;
	static int CNT;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
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
		
		//테스트케이스
		test = Integer.parseInt(st.nextToken());
		
		for(int a=0; a<test; a++) {
			//가로, 세로, 좌표수
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			TC = Integer.parseInt(st.nextToken());
			
			map = new int[R][C];
			visited = new boolean[R][C];
			CNT = 0;
			
			//배추 위치
			for(int i=0; i<TC; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[m][n] = 1;
				visited[m][n] = true;
			}
			
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if(map[i][j] == 1 && visited[i][j]) {
						BFS(i,j);
					}
				}
			}
			System.out.println(CNT);
		}
		
	}
	static void BFS(int r, int c) {
		visited[r][c] = false;
		CNT++;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(r, c));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(map[nr][nc]==1 && visited[nr][nc]) {
						visited[nr][nc] = false;
						q.offer(new Pair(nr, nc));
					}
				}
			}
		}
		
	}
}
