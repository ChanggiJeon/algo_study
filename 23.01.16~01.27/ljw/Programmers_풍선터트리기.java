package A202301;

public class Programmers_풍선터트리기 {

	public int solution(int[] a) {
		int answer = 1;
		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minValue) {
				minValue = a[i];
				minIndex = i;
			}
		}
		int left = 0;
		int leftMin = Integer.MAX_VALUE;
		int rightMin = Integer.MAX_VALUE;
		int right = a.length - 1;
		while (left < minIndex) {
			if (a[left] < leftMin) {
				answer++;
				leftMin = a[left];
			}
			left++;
		}
		while (minIndex < right) {
			if (a[right] < rightMin) {
				answer++;
				rightMin = a[right];
			}
			right--;
		}
		return answer;
	}

}
