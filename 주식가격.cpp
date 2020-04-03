#include <string>
#include <vector>

using namespace std;

//bool isLower[100000];

// sol : Compare with Next Index's Item
// 주석처리는 시간초과
vector<int> solution(vector<int> prices) {

	int size = prices.size();
  /*vector<int> answer(size);*/
	vector<int> answer;
    
	int price;
    
	for (int i = 0; i < size; i++) {
        /* 
        for (int j = 0; j < i; j++) {
          if (isLower[i] == 1) continue;
          if (prices[i] < prices[j]) isLower[i] = true;
          else answer[j]++;
        }
        */
        price = 0;
        for (int j = i + 1; j < size; j++) {
            if(prices[i] <= prices[j]) price++;
            else {
                price++;
                break;
            }
		}
        
    answer.push_back(price);
	}


	return answer;
}
