package P정수_삼각형.solution;

public class Solution {
    public int solution(int[][] triangle) {
        int[][] temp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            temp[i] = new int[i + 1];
        }

        for (int i = triangle.length - 1; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {

                if (i == triangle.length - 1) {
                    temp[i][j] = triangle[i][j];
                    continue;
                }

                temp[i][j] = triangle[i][j] + Math.max(temp[i+1][j], temp[i+1][j+1]);
            }
        }

        return temp[0][0];
    }
}