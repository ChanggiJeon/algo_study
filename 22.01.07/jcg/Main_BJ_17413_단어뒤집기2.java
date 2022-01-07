import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_BJ_17413_단어뒤집기2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack();

		String line = br.readLine();
		int start = 0;
		
		for (int i = 0; i < line.length(); i++) {
			char cur = line.charAt(i);
			if (cur == '<') {
				if(start != i) {
					sb.append(new StringBuilder().append(line.substring(start,i)).reverse());
				}
				start = i;
				while(cur != '>') {
					i++;
					cur = line.charAt(i);
				}
				sb.append(line.substring(start,i+1));
				start = i+1;
			} else {
				if(cur==' ') {
					sb.append(new StringBuilder().append(line.substring(start,i)).reverse());
					sb.append(' ');
					start = i+1;
				}
			}
		}

		if(start!=line.length()) {
			sb.append(new StringBuilder().append(line.substring(start,line.length())).reverse());
		}

		System.out.println(sb);
	}
}
