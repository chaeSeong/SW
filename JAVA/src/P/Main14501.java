package P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main14501 {
	static class Pay{
		int t;
		int p;
		Pay(int t, int p){
			this.t = t;
			this.p = p;
		}
	}
	static ArrayList<Pay> work;
	static int n;
	static int result =0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		work = new ArrayList<Pay>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			work.add(new Pay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		DFS(0,0,0);
	}
	
	static void DFS(int start,int sum, int day) {
		System.out.println(day);
		if(day >= n) {
			//System.out.println(result);
			return;
		}else {
				Pay p = work.get(start);
				System.out.println(work.get(start).t+" "+work.get(start).p);
				result = p.p+sum;//돈 합계
				day = day+p.t;
				DFS(start+p.t,result,day);
		}
		
	}
}
