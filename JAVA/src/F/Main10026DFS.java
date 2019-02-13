package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026DFS {
	
	static int cpn =0;
	static int grcpn = 0;
	static char[][] rgb = null;
	static int[][] visit = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		rgb = new char[n][n];
		visit = new int[n][n];
		
		String s;
		for(int i=0; i<n;i++) {
			s = br.readLine();
			for(int j=0; j<n; j++) {
				rgb[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				if(visit[i][j]==0) {
					cpn++;
					dfs(i,j,rgb[i][j],n);
				}
			}
		}
		
		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				visit[i][j] = 0;
				if(rgb[i][j] == 'G') {
					rgb[i][j] = 'R';
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n;j++) {
				if(visit[i][j] == 0) {
					grcpn++;
					dfs(i,j,rgb[i][j],n);
				}
			}
		}
		
		System.out.println(cpn + " "+ grcpn);
		
	}
	
	public static void dfs(int x, int y, char cha, int size) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		
		visit[x][y] = 1;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<size && ny<size) {
				if(visit[nx][ny]==0 && cha == rgb[nx][ny]) {
					dfs(nx, ny, cha, size);
				}
			}
		}
		
		
	}
}
