package 단어변환;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있음
 * 2. words 에 있는 단어로만 변환할 수 있음
 */
public class Solution {


    public int solution(String begin, String target, String[] words) {
        Queue<String> q = new LinkedList<>();
        int MAX = words.length + 100; // 처음 들어간 문자열은 인덱스 100의 위치로 사용할 것이라 + 100을 사용

        boolean[] check = new boolean[MAX];
        int[] dist = new int[MAX];
        int ans = 0;

        q.offer(begin); // 시작하는 문자열 집어넣기

        // 타겟안에 있는지부터 체크
        if (Arrays.stream(words).filter(v -> v.equals(target)).count() == 0) return 0;

        while (!q.isEmpty()) {
            String remove = q.remove();
            int index = findIndex(remove, words); // index를 찾아서 사용하도록 함

            // BFS 라서 조건만 만족하면, 최소값이 되니 그대로 반환처리
            if (remove.equals(target)) {
                ans = dist[index];
                break;
            }

            for (int i = 0; i < words.length; i++) {
                // 단어 하나씩 가져옴
                if (check[i]) continue;

                if (checkingString(words[i], remove)) {
                    // 하나의 문자만 변경되어있으면 큐에 넣어주기
                    q.offer(words[i]);
                    check[i] = true;
                    dist[i] = dist[index] + 1;
                }
            }
        }

        return ans;
    }

    // 찾은 결과 인덱스 반환, 없다면 100
    private int findIndex(String remove, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(remove)) {
                return i;
            }
        }
        return 100;
    }

    // 다른 문자가 1개 있는지 검사하는 메소드
    private boolean checkingString(String word, String remove) {
        int count = 0;
        for (int i = 0; i < word.length() && count <= 1; i++) {
            if (word.charAt(i) != remove.charAt(i)) {
                count++;
            }
        }

        if (count == 1) return true;
        else return false;
    }
}