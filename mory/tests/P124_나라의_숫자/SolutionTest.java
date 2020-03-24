package P124_나라의_숫자;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solution() {
        Solution solution = new Solution();


        int[] n = {1,2,3,4};
        int[] result = {1,2,4,11};


        for (int i = 0; i < n.length; i++) {
            assertEquals(String.valueOf(result[i]), solution.solution(n[i]));
        }
    }
}