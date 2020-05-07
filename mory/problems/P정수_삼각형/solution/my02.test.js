const s = require('./my02');

test.each([
    [[[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]], 30]
])('정수 삼각형 테스트', (data, result) => {
    expect(s(data)).toBe(result);
});