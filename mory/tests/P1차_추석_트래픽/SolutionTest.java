package P1차_추석_트래픽;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void solution() {
        Solution s = new Solution();

        String[][] input = {
                {
                        "2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                {
                        "2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                {"2016-09-15 23:59:59.999 0.001s"},
                {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"}
        };

        int[] output = {
                1, 2, 1, 7
        };

        for (int i = 0; i < input.length; i++) {
            System.out.println(i + " Start");
            assertEquals(output[i], s.solution(input[i]));
        }

    }
}