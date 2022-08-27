import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_BJ_2002_추월 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		LinkedList<String> list = new LinkedList<String>();
		
		for(int i=0; i<N; i++) {
			String carNumber = br.readLine();
			list.add(carNumber);
		}
		
		int idx = 0;
		for(int i=0; i<N; i++) {
			String changedCarNumber = br.readLine();
			if(!list.get(idx).equals(changedCarNumber)) {
				list.remove(changedCarNumber);
				ans += 1;
			}else {
				idx++;
			}
		}
		System.out.println(ans);

	}

}
