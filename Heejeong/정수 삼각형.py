from test import Test

def solution(triangle):
    for i in range(1, len(triangle)):
        triangle[i][0] += triangle[i - 1][0]
        triangle[i][-1] += triangle[i - 1][-1]

    for i in range(2, len(triangle)):
        for j in range(1, len(triangle[i]) - 1):
            triangle[i][j] += max(triangle[i - 1][j - 1], triangle[i - 1][j])

    return max(triangle[-1])

if __name__ == "__main__":
    test_case = [[[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]]]
    test_result = [30]
    t = Test(solution).test(test_case, test_result)