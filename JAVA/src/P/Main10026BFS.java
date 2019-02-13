package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026BFS {
	static int N;
	static char[][] arr;
	static int[][] visit;
	static int cpn;
	static int grcpn;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Pair{
		int x,y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr= new char[N][N];
		visit= new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(visit[i][j]);
			}
			System.out.println();
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]==0) {
					cpn++;
					bfs(i,j,arr[i][j]);
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				visit[i][j] = 0;
				
				if(arr[i][j] == 'G') {
					arr[i][j] = 'R';
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j] == 0) {
					grcpn++;
					bfs(i,j,arr[i][j]);
				}
			}
		}
		
		System.out.println(cpn +" "+grcpn);
		
	}
	
	static void bfs(int x, int y, char cha) {
		visit[x][y] = 1;
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();

			for(int i=0; i<4;i++) {
				
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<N) {
					if(visit[nx][ny]==0 && cha == arr[nx][ny]) {
						visit[nx][ny] = 1;
						q.offer(new Pair(nx, ny));
					}
				}
			}
			
			
		}
		
		
	}
}
