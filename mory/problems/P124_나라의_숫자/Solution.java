package P124_나라의_숫자;

public class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int tmp = 0;

        while (n > 0) {
            tmp = n % 3; // 3진수, 나머지로 나눠서 그 값을 사용
            n /= 3; // 나눠주기

            if (tmp == 0) {
                // 만약 0 이면 4로 출력해야함
                tmp = 4;
                n -= 1; // 하나를 내려줘야 짝이 맞음
            }
            sb.insert(0, tmp); // 앞부분에 데이터 추가하기
        }
        return sb.toString();
    }
}