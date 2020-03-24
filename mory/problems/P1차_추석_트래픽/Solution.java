package P1차_추석_트래픽;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*

    lines -> 1 <= N <= 2000
    S, T 공백으로 구분 중(응답완료시간, 처리시간)
    2016-09-15 hh:mm:ss.sss, 0.1s, 0.312s, 2s 최대 소수점 셋째 자리까지 기록
    타임아웃이 3초로 적용 처리 시간(T) 0.001 ~ 3.000

 */
class Solution {
    public int solution(String[] lines) {
        List<Traffic> lineList = new ArrayList<>(lines.length * 2); // 가공된 데이터 넣는 곳, 순서대로 있음

        Map<Long, Set<Traffic>> list = new HashMap<>();

        if (lines.length == 1) {
            return 1;
        }

        // 여기서 각 데이터들에 대해서 가공해주는 작업을 진행한다.
        for (int i = 0; i < lines.length; i++) {
            String S = lines[i].substring(0, 23); // 날짜 시간
            String T = lines[i].substring(24, lines[i].length() - 1); // s 삭제 됌

            int TtoMillsTime = (int) (Double.parseDouble(T) * 1000); // T의 밀리초로 계산

            LocalDateTime end_S_DateTime = LocalDateTime.parse(S, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")); // 처리 완료 시간
            LocalDateTime start_S_DateTime = end_S_DateTime.minusNanos((TtoMillsTime * 1_000_000L)); // 처리 시작 시간

            lineList.add(new Traffic(i + "a",
                    start_S_DateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() + 1,
                    end_S_DateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() // 밀리초 기준으로
            )); // 데이터 만들기
        }


        for (int i = 0; i < lineList.size(); i++) {
            Traffic d = lineList.get(i);
            long startTime = d.startTime;
            long endTime = d.endTime; // 이 시간부터 1초까지

            for (long j = startTime; j <= endTime; j++) {
                // 3 초를 넘지 않으니깐 범위는 괜찮을 듯(3 * 1000) * 2000
                if (list.get(j) == null) {
                    list.put(j, new HashSet<>());
                }
                list.get(j).add(d);
            }
        }

        int max = 0;
        Set<Traffic> set = new HashSet<>();

        for (int i = 0; i < lineList.size(); i++) {
            Traffic traffic = lineList.get(i);
            long endTime = traffic.endTime;
            long endTimePlus1sec = endTime + 1000;
            set.clear();

            for (long j = endTime; j < endTimePlus1sec; j++) {
                // 하나씩 검사해서 Set을 만들기 1000개 * 2000 2_000_000
                Set<Traffic> traffic1 = list.get(j);
                if (traffic1 != null && traffic1.size() != 0)
                    set.addAll(list.get(j)); // list 크기 2000
            }

            max = Math.max(set.size(), max);
        }

        return max;

    }

    private class Traffic {
        long startTime;
        long endTime;
        String name;

        public Traffic(String name, long startTime, long endTime) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Traffic traffic = (Traffic) o;
            return Objects.equals(name, traffic.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startTime, endTime, name);
        }
    }
}