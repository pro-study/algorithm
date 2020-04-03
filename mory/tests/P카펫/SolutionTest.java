package P카펫;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void solution() {
        Solution s = new Solution();

        int[] brown = {
                10,
                8,
                24
        };

        int[] red = {
                2,
                1,
                24
        };

        int[][] result = {
                {4,3},
                {3,3},
                {8,6}
        };

        for (int i = 0; i < brown.length; i++)
            assertArrayEquals(result[i], s.solution(brown[i], red[i]));
    }
}