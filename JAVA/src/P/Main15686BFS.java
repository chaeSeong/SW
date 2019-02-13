package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15686BFS {
	static int[][] map;
	static boolean[][] visited;
	static int M;
	static int S;
	static int total;
	
	static class Pair{
		int r;
		int c;
		
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][M+1];
		visited = new boolean[M+1][M+1];
		
		Queue<Pair> hq = new LinkedList<>();
		Queue<Pair> cq = new LinkedList<>();
		
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=M; i++) {
			for(int j=1; j<=M; j++) {
				if(map[i][j] == 1) {
					BFS(i,j);
				}
			}
		}
		System.out.println(total);
	}
	static void BFS(int r, int c) {
		visited = new boolean[M+1][M+1];
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(r, c));
		
		int MIN = 1000000000;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int i=1; i<=M; i++) {
				for(int j=1; j<=M; j++) {
					if(map[i][j] == 2) {
						int nr = Math.abs(p.r - i);
						int nc = Math.abs(p.c - j);
						int t = nr + nc;
						
						if(MIN > t) {
							MIN = t;
						}
					}
				}
			}
		}
		total = total+MIN; 
	}
}
