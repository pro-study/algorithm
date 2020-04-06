package NHIndex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solution() {
        Solution s = new Solution();

        assertEquals(s.solution(new int[]{3,0,6,1,5}), 3);
    }
}