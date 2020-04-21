function solution(begin, target, words) {
    let answer = 0;

    const check = new Array(target.length + 100).fill(false);
    const dist = new Array(target.length + 100).fill(0);

    const q = []; // q
    q.push(begin);

    // 사전에 배열에 안들어있으면 아웃
    if (words.filter(v => v === target).length === 0) return 0;

    while (q.length !== 0) {
        const data = q.shift();
        let index = words.findIndex(v => v === data);
        if (index === -1)
            index = 100;

        if (target === data) {
            // 정답이면
            answer = dist[index];
            break;
        }

        for (let i = 0; i < words.length; i++) {
            if (check[i]) continue;
            if (checking(data, words[i])) {
                q.push(words[i]);
                check[i] = true;
                dist[i] = dist[index] + 1;
            }
        }
    }

    return answer;
}

// 일치하지 않는 값이 1일 경우에만 true 반환
function checking(dataString, wordsString) {
    let count = 0;

    for (let i = 0; i < wordsString.length; i++)
        if (dataString.charAt(i) !== wordsString.charAt(i)) count++;

    if (count == 1) return true;
    else return false;
}

// 테스트
const begin = ['hit', 'hit'];
const target = ['cog', 'cog'];
const words = [
    ["hot", "dot", "dog", "lot", "log", "cog"],
    ["hot", "dot", "dog", "lot", "log"]
];

const result = [4, 0];

for (let i = 0; i < begin.length; i++) {
    console.log(solution(begin[i], target[i], words[i]));
}
