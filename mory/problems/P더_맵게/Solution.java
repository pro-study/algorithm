package P더_맵게;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int solution(int[] scoville, int K) {

        Queue<Integer> q = new PriorityQueue<>(); // 우선순위 큐를 이용하여, 맨 앞쪽은 무조건 작은 값이 들어가게 함

        int answer = 0;

        for (int i : scoville) {
            q.offer(i);
        }

        while (true) {
            answer++;

            int first = q.remove();
            int second = q.remove();

            int result = first + (second * 2);

            q.offer(result);

            // 모든 음식이 이상인지 체크하는건 쉽지
            if (q.peek() >= K) {
                return answer;
            }

            // 만약 사이즈가 1개 남았는데도 불구하고 K를 넘지 못했다면 -1을 출력
            if (q.size() == 1) {
                return -1;
            }
        }
    }
}