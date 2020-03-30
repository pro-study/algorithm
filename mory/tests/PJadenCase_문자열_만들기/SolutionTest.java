package PJadenCase_문자열_만들기;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solution() {
        Solution instance = new Solution();

        String[] s = {
                "3people unFollowed me",
                "for the last week"
        };

        String[] result = {
                "3people Unfollowed Me",
                "For The Last Week"
        };

        for (int i = 0; i < s.length; i++) {
            assertEquals(result[i], instance.solution(s[i]));
        }
    }
}