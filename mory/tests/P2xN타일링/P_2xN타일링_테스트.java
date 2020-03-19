package P2xN타일링;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class P_2xN타일링_테스트 {

    @Test
    public void test() {
        Solution instance = new Solution();

        int[] n = {4,1,2,3};
        int[] answer = {5,1,2,3};

        for (int i = 0; i < n.length; i++) {
            assertEquals(instance.solution(n[i]), answer[i]);
        }
    }
}
