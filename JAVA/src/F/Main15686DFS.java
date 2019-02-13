package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main15686DFS {
	static class Pair{
		int x;
		int y;
		
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N;
	static int M;
	static int[][] arr;
	static ArrayList<Pair> chiecken;
	static ArrayList<Pair> person;
	static int[] output;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		result = Integer.MAX_VALUE;
		chiecken = new ArrayList<Pair>();
		person = new ArrayList<Pair>();
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == 1) {
					person.add(new Pair(i,j));
				}
				else if(arr[i][j] == 2) {
					chiecken.add(new Pair(i,j));
				}
			}
		}
		
		visited = new boolean[chiecken.size()];
		output = new int[chiecken.size()];
		
		for(int i=0; i<chiecken.size(); i++) {
			visited[i] = true;
			DFS(i,0); // 왜 0을 주지?
			visited[i] = false;
		}
		System.out.println(result);
	}
	static void DFS(int s, int d) {
		output[d] = s + 1; //이 배열은 왜 있는거지?
		
		for(int i=s; i<chiecken.size(); i++) {
			if(visited[i]) {
				continue;
			}
			
			visited[i] = true;
			DFS(i,d+1);
			visited[i] = false;
		}
		
		if(d == M-1) {
			int sum = 0;
			int currentM = 0;
			
			for(int i=0; i<person.size(); i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {	//M-1까지 돌려야 되는거 아닌가?
					Pair p1 = person.get(i);
					Pair p2 = chiecken.get(output[i]-1);//이건 왜 이렇게 하는거지?
					currentM = Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
					min = Math.min(min, currentM);
				}
					sum = sum + min;
			}
			result = Math.min(result, sum);
		}
	}
	
}
