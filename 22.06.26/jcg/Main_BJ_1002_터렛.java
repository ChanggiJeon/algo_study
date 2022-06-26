import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_1002_터렛 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			double dis = Math.pow(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)),0.5);
			
			if(x1==x2&&y1==y2) {
				if(r1==r2 && r1>0) {
					sb.append(-1+"\n");
					continue;
				}else {
					sb.append(0+"\n");
					continue;
				}
			}
			
			if(r1+r2>dis) {
				if(Math.max(r1, r2)<Math.min(r1, r2)+dis) {
					sb.append(2+"\n");
				}else if(Math.max(r1, r2) == Math.min(r1, r2)+dis){
					sb.append(1+"\n");
				}else{
					sb.append(0+"\n");
				}
			}else if(r1+r2==dis) {
				sb.append(1+"\n");
			}else {
				sb.append(0+"\n");
			}
			
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
