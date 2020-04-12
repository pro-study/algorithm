package P이중우선순위큐;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> min_q = new PriorityQueue<>();
        PriorityQueue<Integer> max_q = new PriorityQueue<>(Collections.reverseOrder());

        for (String target : operations) {
            String[] s = target.split(" ");

            if (s[0].equals("I")) {
                min_q.add(Integer.parseInt(s[1]));
                max_q.add(Integer.parseInt(s[1]));
            } else if (s[0].equals("D")) {
                if (min_q.isEmpty()) continue;
                if (s[1].equals("1")) {
                    calc(min_q,  max_q.poll());
                } else {
                    calc(max_q,  min_q.poll());
                }
            }
        }

        answer[0] = max_q.isEmpty() ? 0 : max_q.poll();
        answer[1] = min_q.isEmpty() ? 0 : min_q.poll();

        return answer;
    }

    private void calc(PriorityQueue<Integer> q, int target) {
        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == target) continue;
            list.add(poll);
        }
        q.addAll(list);
    }
}