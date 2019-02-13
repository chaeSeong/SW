package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14502Multi {
	static int R;
	static int C;
	static int[][] arr;
	static int[][] map;
	static int[][] graph;
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int cnt=0;
	static int sol=0;
	
	static class Pair{
		int r, c;
		
		Pair(int r, int c){
			this.r = r;
			this.c =c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[R][C];
		map = new int[R][C];
//		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = arr[i][j];
			}
		}
		dfs(0);
		System.out.println(sol);
	}
	
	static void dfs(int L) {
		
		if(L==3) {
			bfs();			
			return;
		}

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==0) {
					map[i][j] = 1;
					dfs(L+1);
					map = arr.clone();
				}
			}
		}

	}
	
	static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		
		//바이러스 위치 찾기
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]==2) {
					q.offer(new Pair(i, j));
				}
			}
		}
		
		//바이러스 퍼트리기
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nc>=0 && nr<R && nc<C) {
					if(map[nr][nc]==0) {
						map[nr][nc] = 2;
					}
				}
			}
		}
		
		//안전영역 구하기
		int safe =0;
		for(int i=0;i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 0) {
					safe+=1;
				}
			}
		}
		sol = safe > sol ? safe : sol;
		
//		System.out.println("sol: " + sol);
	}
}
