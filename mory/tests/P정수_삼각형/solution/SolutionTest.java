package P정수_삼각형.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void solution() {
        int[][] triangle = {
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5},
        };

        int result = 30;

        assertEquals(result, new Solution().solution(triangle));
    }
}