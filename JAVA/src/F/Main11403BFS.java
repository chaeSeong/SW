package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main11403BFS {
	static int N;
	static int[][] arr;
	static int[][] answer;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		visited = new boolean[N];
		answer = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			Queue<Integer> q = new LinkedList<>();
			q.offer(i);
			
			while(!q.isEmpty()) {
				int p = q.poll();
				
				for(int j=0; j<N; j++) {
					if(arr[p][j]==1 && !visited[j]) {
						q.offer(j);
						visited[j] = true;
						answer[i][j] =1;
					}
				}
			}
			
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(answer[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
