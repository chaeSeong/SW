package F;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main2667DFS {

	//개행 문자열 상수
	private static final String NEW_LINE = "\n";
	
	//단지의 상태 상수
	private static final int IS_HOUSE = 1;
	private static final int IS_NOT_HOUSE =0;
	
	//위, 아래, 오른쪽, 왼쪽 상수
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0 ,-1, 1};
	
	//지도의 크기, 지도 저장 배열
	private static int N =0;
	private static int[][] map =null;
	
	//단지 인덱스, 단지별 포함되어있는 집의 갯수 저 배열
	private static int groupIdx = 0;
	private static int[] houseContInGroup =null;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		//지도 배열 초기화
		map = new int[N][N];
		
		//단지별 포함되어 있는 집의 갯수 저장 배열 초기화
		houseContInGroup = new int[N*N];
		
		//루프를 돌며 지도를 만듬
		for(int i=0; i<N;i++) {
			String line = br.readLine();
			
			for(int j=0; j<N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		
		br.close();
		
		//루프를 돌며 집인 경우 dfs를 시작
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == IS_HOUSE) {
					//단지 번호를 1증가시킴(새로운 단지가 형성 된 것임으)
				groupIdx++;
				dfs(i,j);
				}
			}
		}
		//단지별 포함되어있는 집의 갯수를 오름차순으로 정렬
		Arrays.sort(houseContInGroup, 1, groupIdx+1);
		
		//버퍼를 통해 결과 값을 만듬
//		StringBuilder sb = new StringBuilder();
//		sb.append(groupIdx).append(NEW_LINE);
//		
//		for(int i =0; i<=groupIdx; i++) {
//			//sb.append(houseContInGroup[i]).append(NEW_LINE);
//			sb.append(houseContInGroup[i]);
//		}
		
		System.out.println(groupIdx);
		for(int i=1; i<=groupIdx; i++)
		{
			System.out.println(houseContInGroup[i]);
		}
		
		//결과 값 한꺼번에 출력
		//System.out.println(sb.toString());
	}
	
	/**dfs
	 * @param x
	 * @param y
	 */
	private static void dfs(int x, int y) {
		//현재 점을 집-> 집이 아님 상태로 변경하여 다시 방문하지 않도록 설정
		map[x][y] = IS_NOT_HOUSE;
		
		//해당 단지의 포함되어있는 집의 갯수 1증가
		houseContInGroup[groupIdx]++;
		
		//지도의 위, 아래, 오른쪽, 왼쪽을 찾아가며 집인 경우 다시 dfs를 시작
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(map[nx][ny] == 1) {
					dfs(nx, ny);
				}
			}
		}
	}

}
