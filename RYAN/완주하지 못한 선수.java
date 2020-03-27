import java.util.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;
import static java.util.function.Function.identity;

class Solution {
    
    private static final String EMPTY_STRING = "";
    
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> completionWithNameDupCount = Arrays.stream(completion)
            .collect(groupingBy(identity(), counting()));
        
        for (String participantName : participant) {
            
            Long nameDupCount = completionWithNameDupCount.remove(participantName);
            
            if (Objects.isNull(nameDupCount)) {
                return participantName;
            }
            
            if (nameDupCount > 1L) {
                completionWithNameDupCount.put(participantName, nameDupCount - 1L);
            }
        }
        
        return EMPTY_STRING;
    }
}