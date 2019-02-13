package P;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2583BFS {

	static int M;
	static int N;
	static int K;
	static int[][] check;
	static boolean[][] graph;
	static int cnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Pair{
		int x,y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		check = new int[M][N];
		graph = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sX = Integer.parseInt(st.nextToken());
			int sY = Integer.parseInt(st.nextToken());
			int eX = Integer.parseInt(st.nextToken());
			int eY = Integer.parseInt(st.nextToken());
			
			for(int a=sY; a<eY; a++) {
				for(int b=sX; b<eX; b++) {
					check[a][b] = -1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] == 0) {
					graph[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(check[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j] == 0 && graph[i][j]) {
					bfs(i,j,++cnt);
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(check[i][j]);
			}
			System.out.println();
		}
		
		
		System.out.println(cnt);
		int[] answer = new int[cnt];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(check[i][j]  > -1) {
					answer[check[i][j] - 1] += 1;
				}
			}
		}
		Arrays.sort(answer);
		
		for(int i=0; i<answer.length;i++) {
			System.out.print(answer[i]+ " ");
		}
		
	}
	
	static void bfs(int x, int y, int cnt) {
		check[x][y] = cnt;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x,y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<M && ny<N) {
					if(check[nx][ny]==0 && graph[nx][ny]) {
						check[nx][ny] = cnt;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
}
