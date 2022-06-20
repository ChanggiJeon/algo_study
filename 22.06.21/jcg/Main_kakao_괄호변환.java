import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_kakao_괄호변환 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String ans = process(line);
		System.out.println(ans);
	}

	private static String process(String input) {
		if(input == "") {
			return input;
		}
		
		Queue<Character> u = new LinkedList<Character>();
		int cnt = 0;
		
		//1. u와 v로 나누기
		int idx = 0;
		for(int i=0; i<input.length(); i++) {
			char o = input.charAt(i);
			if(o == '(') {
				cnt++;
			}else {
				cnt--;
			}
			u.add(o);
			if(cnt==0) {
				idx = i;
				break;
			}
		}
		String v;
		if(idx+1<input.length()) {
			v = input.substring(idx+1);
		}else {
			v = "";
		}
		
		//2. u가 올바른 괄호 문자열인지 체크
		boolean check = true;
		Stack<Character> temp = new Stack<Character>();
		int size = u.size();
		for(int i=0; i<size; i++) {
			char o = u.poll();
			switch(o) {
				case ')':
					if(temp.isEmpty() || temp.peek()!='(') {
						check = false;
						temp.add(o);
					}else {
						temp.pop();
					}
					u.add(o);
					break;
				case '(':
					temp.add(o);
					u.add(o);
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		//2-1 올바른 문자열이면 sb에 붙이고 v에 대해서 다시 진행.
		if(check) {
			for(int i=0; i<size; i++) {
				sb.append(u.poll());
			}
			sb.append(process(v));
		//2-2 올바른 문자열이 아니라면 앞뒤 문자열을 제거후, 나머지 괄호를 뒤집는다.
		}else {
			StringBuilder t = new StringBuilder();
			t.append('(').append(process(v)).append(')');
			//2-3 처음과 마지막은 버리고 나머지는 반대로 뒤집어서 붙이기.
			u.poll();
			int uSize = u.size();
			for(int i=0; i<uSize-1; i++) {
				if(u.poll()=='(') {
					t.append(')');
				}else {
					t.append('(');
				}
			}
			sb.append(t);
		}
		
		return sb.toString();
	}
}
