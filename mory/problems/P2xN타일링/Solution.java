package P2xN타일링;

/*
    제한사항
    1. 가로 길이 n 은 6만 이하 자연수
    2. 1_000_000_007 로 나눈 값을 return
 */

public class Solution {
    public int solution(int n) {
        int[] d = new int[n+1];

        d[0] = 1;
        d[1] = 1; // 인덱스 1 부터 시작한다.

        // input 값은 1부터 들어올 수 있고, 6만 이하 자리라서 1부터 들어오는 값을 고려해야한다.

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
            d[i] %= 1_000_000_007;
        }

        return d[n];
    }
}
