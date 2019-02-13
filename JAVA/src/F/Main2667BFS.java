package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667BFS {

	static boolean[][] graph;
	static int[][] check;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static int cnt=0;
	
	static class Pair{
		int x,y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n= Integer.parseInt(br.readLine());
		graph = new boolean[n][n];
		check = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(check[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<n;i++) {
			String str = br.readLine();
			
			for(int j=0; j<n; j++) {
				if(str.charAt(j)=='1') {
					graph[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(check[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				if(check[i][j] == 0 && graph[i][j]) {
					bfs(i,j,++cnt);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(check[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(cnt);
		
		int[] answer = new int[cnt];
		
		for(int i=0; i<n ; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j] != 0) {
					answer[check[i][j]-1]+=1;
				}
			}
		}
		Arrays.sort(answer);
		
		for(int i=0; i<answer.length;i++) {
			System.out.println(answer[i]);
		}
	}
	
	static void bfs(int x, int y, int cnt) {
		check[x][y] = cnt;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n) {
					if(check[nx][ny] == 0 && graph[nx][ny]) {
						check[nx][ny] = cnt;
						q.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
	
}
