package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1389BFS {
	static int M;
	static int C;
	static int[][] map;
	static boolean[] visited;
	static int[][] answer;
	
	static class Pair{
		int i;
		
		Pair(int i){
			this.i = i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][M+1];
		
		for(int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		for(int i=1; i<=M; i++) {
			BFS(i);
		}
	}
	static void BFS(int i) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(i));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int a=1; a<=M; a++) {
				if(map[p.i][a] == 1 && visited[a]) {
					q.offer(new Pair(a));
				}
			}
		}
		
	}
}