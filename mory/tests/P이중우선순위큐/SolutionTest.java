package P이중우선순위큐;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {
        String[][] operations = {
                {"I 16" ,"D 1"},
                {"I 7","I 5","I -5","D -1"},
                {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}
        };

        int[][] result = {
                {0,0},
                {7,5},
                {0,0}
        };

        for(int i = 0; i < operations.length; i++) {
            assertArrayEquals(result[i], new Solution().solution(operations[i]));
        }
    }
}