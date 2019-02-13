package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14503 {
	static int R;
	static int C;
	
	static int[][] map;
	static int[][] visited;
	
	static int curR;
	static int curC;
	static int curD;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new int[R][C];
		
		st = new StringTokenizer(br.readLine());
		curR = Integer.parseInt(st.nextToken());
		curC = Integer.parseInt(st.nextToken());
		curD = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { //벽인경우
					visited[i][j] = -1;
				}
			}
		}
		
		clean(curR,curC,curD);
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	/*
	1. 현재 위치를 청소한다.
	2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	 - 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다 - OK
	 - 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다. - OK
	 - 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	 - 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	*/
	static void clean(int r, int c, int d) {
		System.out.println("r:"+r+" c:"+c+" d:"+d);
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr>0 && nc>0 && nr<R && nc<C) {
				//네방향모두 벽일때
				if(map[nr][nc] ==1 && visited[nr][nc]==-1) {
					return;
				}
				else {
					if(d==0) {
						if(c+2>0 && c+2<C) {
								clean(r,c+2,d);

						}
					}
				}
//				if(visited[nr][nc] == 1 || map[nr][nc] == 1) {
//					//뒤쪽방향이 벽이라 후진도 할 수 없는 경
//					if(d == 0) {
//						if(map[r][c+2]==1) {
//							return;
//						}else {
//							clean(r,c+2,d);
//						}
//					}
//					else if(d == 3) {
//						if(map[r+2][c]==1) {
//							return;
//						}else {
//							clean(r+2,c,d);
//						}
//					}
//					else if(d == 2) {
//						if(map[r][c-2]==1) {
//							return;
//						}else {
//							clean(r,c-2,d);
//						}
//					}
//					else if(d == 1) {
//						if(map[r-2][c]==1) {
//							return;
//						}else {
//							clean(r-2,c,d);
//						}
//					}
//				}
			}
		}
		
		//1. 현재 위치를 청소한다.
		visited[r][c] = 1;
		//2. 현재 위치에서 현재방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		if(r>0 && c>0 && r<R && c<C) {
			if(d == 0) {
				if(map[r-1][c] == 0 && visited[r-1][c] == 0) {
					d = 3;
					clean(r-1,c,d);
				}else {
					d=3;
					clean(r,c,d);
				}
			}
			else if(d == 3) {
				if(map[r][c+1] == 0 && visited[r][c+1] == 0) {
					d = 2;
					clean(r,c+1,d);
				}else {
					d = 2;
					clean(r,c,d);
				}
			}
			else if(d == 2) {
				if(map[r+1][c] == 0 && visited[r+1][c] == 0) {
					d = 1;
					clean(r+1,c,d);
				}else {
					d = 1;
					clean(r,c,d);
				}
			}
			else if(d == 3) {
				if(map[r][c-1] == 0 && visited[r][c-1] == 0) {
					d = 0;
					clean(r,c-1,d);
				}else {
					d = 0;
					clean(r,c,d);
				}
			}
		}
	}

}
