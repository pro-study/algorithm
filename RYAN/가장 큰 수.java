import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {
	public String solution(int[] numbers) {
		return Arrays.stream(numbers).boxed()
			.sorted(new AlphabeticalNumber())
			.map(String::valueOf)
			.collect(Collectors.joining());
	}
}

class AlphabeticalNumber implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {

		String s1 = String.valueOf(o1);
		String s2 = String.valueOf(o2);
		int s1Length = s1.length();
		int s2Length = s2.length();
		int i = 0;

		for (; i < (s1Length < s2Length ? s1Length : s2Length); i++) {
			int s1Num = charToInt(s1.charAt(i));
			int s2Num = charToInt(s2.charAt(i));

			if (s1Num > s2Num) {
				return -1;
			} else if (s2Num > s1Num) {
				return 1;
			}
		}

		if (s1Length > s2Length) {
			int s1Num;
			int s2FirstNum = charToInt(s2.charAt(0));
			for (; i < s1Length; i++) {
				s1Num = charToInt(s1.charAt(i));
				if (s1Num > s2FirstNum) {
					return -1;
				} else if  (s1Num < s2FirstNum) {
					return 1;
				}
			}
		} else if (s2Length > s1Length) {
			int s1FirstNum = charToInt(s1.charAt(0));
			int s2Num;
			for (; i < s2Length; i++) {
				s2Num = charToInt(s2.charAt(i));
				if (s2Num > s1FirstNum) {
					return 1;
				} else if (s2Num < s1FirstNum) {
					return -1;
				}
			}
		}

		return 0;
	}

	private Integer charToInt(char c) {
		return Integer.parseInt(Character.toString(c));
	}
}