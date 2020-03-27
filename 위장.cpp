#include <string>
#include <vector>

using namespace std;

// C++ 전역변수 초기화시 0임을 보장한다.
int element_cnt[31];
string kind[31];

// 조합 : 각각의 테이블은 공집합을 포함하여 +1, total 공집합 제외 -1
// answer = (element_cnt +1) * (element_cnt +1) * ... * (element_cnt +1) - 1;
int solution(vector<vector<string>> clothes) {

	int answer = 1;
	int size = (int)clothes.size(); // clothes.size() <- 계속 Access 하지 않도록 하기위함.
	bool isNewChecker; // 새로운 종류의 옷인지 확인해주는 변수
	int kind_cnt = 0; // 종류 counter

	for (int i = 0; i < size; i++) {

		isNewChecker = true;
		// << 분류 cycle
		for (int j = 0; j <= kind_cnt; j++) {
			if (clothes[i][1] == kind[j]) { // 분류된 기억이 있는가
				element_cnt[j]++;
				isNewChecker = false;
				break;
			}
		}

		if (isNewChecker == true) {
			kind[kind_cnt] = clothes[i][1];
			element_cnt[kind_cnt++]++;
		}
		// >>
	}

	// << Calc Method
	for (int i = 0; i < kind_cnt; i++)
		answer *= (element_cnt[i] + 1);
	// >>

	return answer - 1;
}
