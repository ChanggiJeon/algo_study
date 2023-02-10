
public class Solution_PG_풍선터트리기 {

	public static void main(String[] args) {
		int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		int[] minLeft = new int[a.length];
		int[] minRight = new int[a.length];
		
		// idx의 왼쪽에서 가장 작은 수
		minLeft[0] = a[0];
		for(int i=1; i<a.length; i++) {
			minLeft[i] = minLeft[i-1];
			if(a[i-1] < minLeft[i]) {
				minLeft[i] = a[i-1];
			}
		}
		// idx의 오른쪽에서 가장 작은 수
		minRight[a.length-1] = a[a.length-1];
		for(int i=a.length-2; i>=0; i--) {
			minRight[i] = minRight[i+1];
			if(a[i+1] < minRight[i]) {
				minRight[i] = a[i+1];
			}
		}
		
		int answer = 0;
		for(int i=0; i<a.length; i++) {
			if(minLeft[i] < a[i] && minRight[i] < a[i]) {
				continue;
			}
			answer++;
		}
		System.out.println(answer);
	}

}
