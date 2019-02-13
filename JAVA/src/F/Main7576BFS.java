package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main7576BFS {
	static int R;
	static int C;
	static int[][] arr;
	
	static class Pair{
		int r,c;
		
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new int[C][R];
		
		for(int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<R; j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		int max =0;
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				if(arr[i][j]==0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(arr[i][j], max);
			}
		}
		System.out.println(max-1);
	}
	
	static void bfs() {
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		Queue<Pair> q = new LinkedList<>();
		
		for(int i=0; i<C; i++) {
			for(int j=0; j<R; j++) {
				if(arr[i][j] ==1) {
					q.offer(new Pair(i,j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];
				
				if(nr>=0 && nc>=0 && nr<C && nc<R) {
					if(arr[nr][nc] == 0) {
						q.offer(new Pair(nr,nc));
						arr[nr][nc] = arr[p.r][p.c]+1;
					}
				}
			}
		}
		
		
	}
}
