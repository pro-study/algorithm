package PJadenCase_문자열_만들기;

public class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();

        String lowerString = s.toLowerCase(); // 먼저 모두 소문자로 바꿔줍니다.

        boolean chk = false; // 탐색 전 문자가 공백 문자일 경우 true 로 변경됩니다.

        for (int i = 0; i < lowerString.length(); i++) {
            char firstChar = lowerString.charAt(i); // i 번째 문자를 가져옵니다.

            if (firstChar == ' ') {
                chk = true;
                sb.append(" "); // 공백은 그대로 공백을 추가해준다, 테스트 케이스 중 스페이스가 2개인 경우가 있기 때문이다.
                continue;
            } // 공백일 경우 true 바꾸고 넣어주고 점프!

            if (chk && firstChar != ' '
                    || i == 0
                    && firstChar >= 'A'
                    && firstChar <= 'z'
            ) {

                sb.append((char) (firstChar - 32)); // 소문자를 대문자로 바꿔줍니다.

                chk = false; // 변경 완료했으니 다시 소문자로 바꿔줍니다.
            } else {
                sb.append(firstChar);
            }
        }

        return sb.toString();
    }
}
