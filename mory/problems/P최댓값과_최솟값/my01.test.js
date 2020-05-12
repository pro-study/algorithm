const solution = require('./my01');

test.each([
    ['1 2 3 4', '1 4'],
    ['-1 -2 -3 -4', '-4 -1'],
    ['-1 -1', '-1 -1']
])('최댓값과 최솟값 테스트', (s, result) => {
    expect(solution(s)).toBe(result);
});