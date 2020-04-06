package NHIndex;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 0, 1, 3, 5, 6
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {

            int right = citations.length - i;

            if (citations[i] >= right) {
                answer = right;
                break;
            }
        }

        return answer;
    }
}