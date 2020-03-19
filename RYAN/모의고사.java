import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        final int[][] MARK = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] score = new int[MARK.length];
        int maxScore = 0;
        List<Integer> studentWithMaxScore = new ArrayList<>();
        
        for (int i = 0; i < MARK.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (MARK[i][j % MARK[i].length] == answers[j]) {
                    score[i]++;
                }
            }
        }
           
        for (int i = 0; i < score.length; i++) {
            if (score[i] > maxScore) {
                maxScore = score[i];
                studentWithMaxScore.clear();
                studentWithMaxScore.add(i + 1);
            } else if (score[i] == maxScore) {
                studentWithMaxScore.add(i + 1);
            }
        }
        
        return studentWithMaxScore.stream().mapToInt(i -> i.intValue()).toArray();
    }
}