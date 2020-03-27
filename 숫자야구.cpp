#include <string>
#include <vector>

using namespace std;


// solution : all case to mask & masking
int solution(vector<vector<int>> baseball) {
	int answer = 0;

	int strike;
	int ball;

	int	numCase[3];
	string numMask;

	bool IsMasked;

	// << all case
	for (numCase[0] = 1; numCase[0] < 10; numCase[0]++) {
		for (numCase[1] = 1; numCase[1] < 10; numCase[1]++) {
			if (numCase[0] == numCase[1]) continue;
			for (numCase[2] = 1; numCase[2] < 10; numCase[2]++) {
				if ((numCase[1] == numCase[2]) || (numCase[0] == numCase[2])) continue;
	

				// <<< mask
				IsMasked = true;
				for (int i = 0; i < baseball.size(); i++) {
					strike = 0;
					ball = 0;

					for (int x = 0; x < 3; x++) {		// Case
						for (int y = 0; y < 3; y++) {	// Mask


							// <<<< Compare
							numMask = to_string(baseball[i][0]);
							if (x == y && numCase[x] == (numMask[y] - '0')) {
								strike++;
								break;
							}

							if (x != y && numCase[x] == (numMask[y] - '0')) {
								ball++;
								break;
							}
							// >>>>
						}
					}

					// <<<< masking
					if (strike != baseball[i][1] || ball != baseball[i][2]) {
						IsMasked = false;
						break;
					}
					// >>>>
				}
				// >>>

				// Make Result
				if (IsMasked == true) answer++;

			}
		}
	}
	// >>

	return answer;
}
