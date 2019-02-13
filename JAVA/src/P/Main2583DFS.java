package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2583DFS {

	private static int M;	//가로
	private static int N;	//세로
	private static int K;	//수
	private static int[][] map;
	
	private static int groupIdx =0;
	private static int[] groupContInGrop = null;
	
	public static void main(String[] agrs) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
//		System.out.println(M+" "+N+" "+K);
		map = new int[N][M];
		groupContInGrop = new int[N*M];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());
			
			for(int a=sx; a<ex; a++) {
				for(int b=sy; b<ey; b++) {
					map[a][b] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 0) {
					groupIdx++;
					dfs(i,j);
				}
			}
		}
		Arrays.sort(groupContInGrop, 1, groupIdx);
		
		StringBuilder sb = new StringBuilder();
		sb.append(groupIdx).append("\n");
		
		for(int i=1; i<=groupIdx; i++) {
			sb.append(groupContInGrop[i]+" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	private static void dfs(int x, int y) {
		map[x][y] = 1;
		groupContInGrop[groupIdx]++;
				
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<M) {
				if(map[nx][ny] == 0) {
					dfs(nx,ny);
				}
			}
			
		}
		
	}
	
	
}
