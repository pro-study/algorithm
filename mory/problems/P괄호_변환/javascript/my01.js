function solution(p) {
    function correctState(p) {
        let stack = [];

        for (let i = 0; i < p.length; i++) {
            if (p.charAt(i) === '(') {
                stack.push(1);
            } else {
                if (stack[stack.length - 1] === 1) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.length === 0;
    }

    function divide(str) {
        let u = 0;
        let v = 0;

        let i = 0;
        for (; i < str.length; i++) {
            if (str.charAt(i) === '(') {
                u++;
            } else {
                v++;
            }

            if (u === v) {
                break;
            }
        }

        return [str.substring(0, i+1), str.substring(i+1)];
    }

    function process(str) {
        if (str === '') return '';
        // 1. p 를 균형잡힌 괄호 문자열로 분리
        let [u, v] = divide(str);

        // 2. u 가 올바른 괄호 문자열이면 위에 과정을 다시 수행
        if (correctState(u)) {
            return u + process(v);
        } else {
            let pp = "(";
            pp += process(v);
            pp += ")";

            // v 구하기
            return pp + [...u.substr(1, u.length - 2)].map(v => v === ')' ? '(' : ')').join('');
        }
    }

    if (p === '') {
        return '';
    }

    if (correctState(p)) {
        return p;
    }

    // 괄호가 이미 올바른 괄호면 그대로 리턴
    // console.log(process(p));

    // 3. u가 올바른 괄호가 아니라면 빈 문자열에 ( 붙이고
    // 문자열 v에 대해서 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙임
    // ) 붙임
    // u의 첫번째 마지막 제거, 괄호 방향 뒤집어 붙이기

    return process(p);
}

/*
 균형 잡힌 괄호
 올바른 괄호

u, v 로 분리

[후기]
여기서 일단 나머지 괄호 모두 다 바꿔줘야하는 조건이 있었네
     return [str.substring(0, i+1), str.substring(i+1)];
     이부분 보면 문자열이 반환되는지 배열이 반환되는지 중요함!
 */

module.exports = solution;