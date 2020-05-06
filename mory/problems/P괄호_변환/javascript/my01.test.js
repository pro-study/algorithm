const solution = require('./my01');


test.each([
    ["(()())()", "(()())()"],
    [")(", "()"],
    ["()))((()", "()(())()"]
])('테스트', (data, result) => {
    expect(solution(data)).toBe(result);
})