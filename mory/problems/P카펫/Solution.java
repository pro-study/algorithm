package P카펫;

public class Solution {
    public int[] solution(int brown, int red) {
        // 최소 세로 길이는 3이상
        // 최소 가로 길이도 3이상
        int x = 0; // 가로길이
        int y = 0; // 세로길이
        int brownRedSum = brown + red;

        for (int i = 3; i <= brownRedSum / 2; i++) {
            // 가로 세로 곱하기는 쌍으로 적용되니 나누기 2!
            int width = i; // 가로
            int height = brownRedSum / width; // 세로

            if (brownRedSum % width == 0
                    && width >= height
                    && height >= 3
                    && brown == (width* 2) + (height - 2) * 2
            ) {
                // 가로세로 길이 비율이 맞아 떨어져야 하며,
                // 가로 길이는 세로 길이보다 크거나 같아야 한다.
                // 크기는 기본적으로 3이상이 되어야한다.
                // 가로 만큼 곱하기 2배랑, 각 세로 크기 -2 에서 2개씩 있어야함
                // 브라운 색깔이 첫번째, 마지막번째 줄 크기 만큼 있어야 되며, 중간 줄에 있는 브라운에 첫째,마지막 째 줄을 제외한 나머지 줄에 대한 개수가 각각 2개씩 존재함
                x = width;
                y = height;
                break;
            }
        }

        return new int[]{x, y};
    }
}