package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3187DFS {
	static int R;
	static int C;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static char[][] arr;
	static int[][] map;

	static int Cnt=0;
	static int cntV=0;
	static int cntK=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[R][C];
		map = new int[R][C];
		
		for(int i=0; i<R;i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j]!='#') {
					dfs(i,j);
					Cnt++;
				}
			}
		}
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]+"  ");
			}
			System.out.println();
		}
		
	}
	
	private static void dfs(int x, int y) {
		map[x][y] = Cnt;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<R && ny<C) {
				if(arr[nx][ny] != '#') {
					map[nx][ny] = Cnt;
				}
			}
		}
	}
}
	