import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_BJ_11656_접미사배열 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line = br.readLine();
		int n = line.length();
		String[] array = new String[line.length()];
		for(int i=0; i<n; i++) {
			array[i] = line.substring(i);
		}
		Arrays.sort(array);
		for(int i=0; i<n; i++) {
			sb.append(array[i]+"\n");
		}
		System.out.println(sb);
		

	}

}
