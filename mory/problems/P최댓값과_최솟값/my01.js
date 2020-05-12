function solution(s) {
    const sArr = s.split(' ').map(v => parseInt(v));

    return `${Math.min.apply(null, sArr)} ${Math.max.apply(null, sArr)}`;
}

module.exports = solution;
/*
    https://programmers.co.kr/learn/courses/30/lessons/12939
 */