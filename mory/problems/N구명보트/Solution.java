package N구명보트;

/*
    최대 2명씩 밖에 탈 수 있고, 무게 제한있음
    모든 사람을 구하기 위한 최소 보트수
 */

import java.util.Arrays;

public class Solution {

    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people); // 정렬 부터

        int lastIndex = people.length - 1;

       for (int i = 0; i <= lastIndex; i++, answer++) {
           while (lastIndex > i && people[i] + people[lastIndex--] > limit) {
               // 만약에 제한 무게보다 크면 그냥 초과한거라서 그 친구는 어쩔 수 없이 보트 혼자 타야함
               answer++;
           }
       }

        return answer;
    }
}