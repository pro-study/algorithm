package P올바른_괄호;

import org.junit.Test;

import static org.junit.Assert.*;

public class P올바른_괄호_테스트 {

    @Test
    public void solution() {
        Solution s = new Solution();

        String[] str = {"()()", "(())()", ")()(", "(()("};
        boolean[] answer = {true, true, false, false};

        for (int i = 0; i < str.length; i++) {
            assertEquals(s.solution(str[i]), answer[i]);
        }
    }
}