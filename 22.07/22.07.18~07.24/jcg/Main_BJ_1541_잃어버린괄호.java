import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_BJ_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numberList = br.readLine().split("\\-");
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for(int i=0; i<numberList.length; i++) {
			if(numberList[i].contains("+")) {
				String[] num = numberList[i].split("\\+");
				int ans = 0;
				for(int j=0; j<num.length; j++) {
					ans += Integer.parseInt(num[j]);
				}
				arr.add(ans);
			}else {
				arr.add(Integer.parseInt(numberList[i]));
			}
		}
		int ans = arr.get(0);
		for(int i=1; i<arr.size(); i++) {
			ans -= arr.get(i);
		}
		System.out.println(ans);
	}

}
