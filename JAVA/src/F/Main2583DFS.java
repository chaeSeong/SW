package F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2583DFS {
	static int M;
	static int N;
	static int K;
	static int arr[][];
	static int result[];
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,-1,0,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str[] = br.readLine().split(" ");
		
		M = Integer.parseInt(str[0]);
		N = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		arr = new int[M][N];
		result = new int[1001];
		
		for(int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			int B = Integer.parseInt(str[0]);
			int A = Integer.parseInt(str[1]);
			int D = Integer.parseInt(str[2]);
			int C = Integer.parseInt(str[3]);
			
			for(int m=A; m<C;m++) {
				for(int n=B; n<D; n++) {
					arr[m][n] = -1;
				}
			}
		}
		
		int color=1;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N;j++) {
				if(arr[i][j] == 0) {
					DFS(i,j,color);
					color++;
				}
			}
		}
		System.out.println(color-1);
		Arrays.sort(result, 1, color);
		for(int i=1; i<color; i++) {
			System.out.print(result[i]+" ");
		}
	}
	
	public static void DFS(int i, int j, int color) {
		arr[i][j] = color;
		result[color]++;
		
		for(int k=0; k<4; k++) {
			int nx = i+dx[k];
			int ny = j+dy[k];
			
			if(nx>=0 && ny>=0 && nx<M && ny<N) {
				if(arr[nx][ny] == 0) {
					DFS(nx,ny, color);
				}
			}
		}
	}
}
