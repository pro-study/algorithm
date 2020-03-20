package P올바른_괄호;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    제한사항
    문자열 s 길이가 100_000 이하
    문자열 s는 ( 과 ) 로만 이루어져있음
 */

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push('(');
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else return false; // 만약 스택에 값이 없다면 이미 틀린 상황이므로 false 를 반환
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}