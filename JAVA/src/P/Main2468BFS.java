package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2468BFS {
	static int N;
	static int[][] arr;
	static boolean[][] graph;
	static int[][] check;
	static int cnt;
	static int Max = 0;
	static int Min = 1000;
	
	
	static class Pair{
		int r,c;
		
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Max = Math.max(Max, arr[i][j]);
				Min = Math.min(Min, arr[i][j]);
			}
		}
		
		int[] answer = new int[Max+2];
		
		for(int k=Min-1; k<=Max+1; k++) {
			graph = new boolean[N][N];
			check = new int[N][N];
			cnt = 0;

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]>k) {
						graph[i][j] = true;
					}
				}
			}
			
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]>k && graph[i][j]) {
						bfs(i,j,++cnt,k);
						answer[k] = cnt;
					}
				}
			}
		}
		
		int safe=0;
		
		for(int i=Min-1; i<answer.length;i++) {
			safe = Math.max(safe, answer[i]);
		}

		
		System.out.println(safe);
	}
	
	static void bfs(int x, int y, int n, int m) {
		check[x][y] = n;
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		Queue<Pair> q= new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nc>=0 && nr<N && nc<N) {
					if(arr[nr][nc]>m && graph[nr][nc]) {
						check[nr][nc] = n;
						graph[nr][nc] = false;
						q.offer(new Pair(nr, nc));
					}
				}
			}
		}
	}
}
