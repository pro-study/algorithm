#include <string>
#include <vector>

using namespace std;

// 단순비교 : 뒤에서 바라 봤을때 자신보다 큰 것을 확인하자. 없으면 : 0, 있으면 : index +1
vector<int> solution(vector<int> heights) {

    // << for문에서 계속 Access하지 않도록하기 위하여 지역변수로 초기화
    int size = heights.size();
    int cur_height; // 비교하려는 피연산자
    // >>
    
    vector<int> answer(size);
	
    // last index부터 확인
    for (int i = size - 1; i >= 0; i--) {
	cur_height = heights[i];
        // << 뒤에서 부터 앞으로 바라본다.
        for (int j = i - 1; j >= 0; j--) {
                if (cur_height < heights[j]) {
                answer[i] = j + 1;
                break; // 결과를 찾으면 탈출
            }
        }
        // >>
    }

    return answer;
}
