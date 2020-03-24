#include <string>
#include <vector>

#if 0  // Time Out sol : 1, Success Sol : 0
#define TimeoutSol
#else
#define SuccessSol
#endif

using namespace std;

#if defined(TimeoutSol)
bool isLower[100000];
#endif

// sol : Compare with Next Index's Item

vector<int> solution(vector<int> prices) {

	int size = prices.size();

#if defined(TimeoutSol)
	vector<int> answer(size);
#else
	vector<int> answer;
#endif


	int price;

	for (int i = 0; i < size; i++) {

#if defined(TimeoutSol)
		for (int j = 0; j < i; j++) {
		  if (isLower[i] == 1) continue;
		  if (prices[i] < prices[j]) isLower[i] = true;
		  else answer[j]++;
		}
#else
		price = 0;
		for (int j = i + 1; j < size; j++) {
			if (prices[i] <= prices[j]) price++;
			else {
				price++;
				break;
			}
		}

		answer.push_back(price);
#endif
	}

	return answer;
}
