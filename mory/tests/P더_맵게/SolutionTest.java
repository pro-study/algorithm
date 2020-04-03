package P더_맵게;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solution() {
        Solution s = new Solution();

        assertEquals(2, s.solution(new int[]{1,2,3,9,10,12}, 7));
    }
}