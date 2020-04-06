package N구명보트;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void solution() {

        int[][] people = {
                {70,50,80,50},
                {70,80,50}
        };

        int[] limit = {
                100, 100
        };

        int[] result = {
                3, 3
        };

        for (int i = 0; i < people.length; i++) {
            Solution s = new Solution();
            Assertions.assertEquals(s.solution(people[i], limit[i]), result[i]);
        }
    }
}