package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main3187BFS {
	static int R;
	static int C;
	
	static char[][] arr;
	static boolean[][] visited;
	
	static int cntV;	//늑대
	static int V = 0;
	static int cntK;	//양
	static int K = 0;
	
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
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
				
				if(arr[i][j] != '#') {
					visited[i][j] = true;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] != '#' && visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		System.out.println(K +" "+V);
	}
	
	static void bfs(int x, int y) {
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		visited[x][y] = false;
		
		cntV=0;
		cntK=0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(arr[p.x][p.y] =='v') {
				cntV++;
			}
			if(arr[p.x][p.y]=='k') {
				cntK++;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<R && ny<C) {
					if(arr[nx][ny]!='#'&&visited[nx][ny]) {
						visited[nx][ny] = false;
						q.offer(new Pair(nx, ny));
					}
					
				}
			}
		}
		V += (cntV >= cntK) ? cntV : 0;
		K += (cntK > cntV) ? cntK : 0;
	}
}
