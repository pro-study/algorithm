import java.util.Arrays;

class Solution {
	public int solution(int[] numbers, int target) {
		return count(numbers, target, 0);
	}

	private int count(int[] numbers, int target, int sum) {
		if (numbers.length == 0) {
			if (sum == target) {
				return 1;
			} else {
				return 0;
			}
		}

		return count(Arrays.copyOfRange(numbers, 1, numbers.length), target, sum + numbers[0])
			+ count(Arrays.copyOfRange(numbers, 1, numbers.length), target, sum - numbers[0]);
	}
}