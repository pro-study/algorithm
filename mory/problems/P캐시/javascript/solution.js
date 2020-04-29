function solution(cacheSize, cities) {

    let time = 0; // 시간초 설정
    const CACHE_HIT = 1;
    const CACHE_MISS = 5;

    let cacheStore = []; // 기본적으로 Queue 방식으로 진행되어야함

    if (cacheSize === 0) {
        return cities.length * 5;
    }

    cities.forEach(v => {
        const transStr = v.toLowerCase();

        let idx = cacheStore.indexOf(transStr);

        if (idx >= 0) {
            // 이미 있다면
            let target = cacheStore.splice(idx, 1);
            cacheStore.push(target.join(""));
            time += CACHE_HIT;
        } else {
            if (cacheStore.length == cacheSize) {
                cacheStore.shift(); // 빼주기
            }
            cacheStore.push(transStr);
            time += CACHE_MISS;
        }
    });
    console.log(time);
    return time;
}

solution(2, ["Jeju", "Pangyo", "NewYork", "newyork"]);
solution(3, ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"]);
solution(3, ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"]);
/*
    캐시크기 만큼 배열에다가 담아두고, 최대가 30이니깐 비교할만하네
    그리고 그 캐시만큼 최근에 사용되면 마지막에 넣어줘서 마지막만 검사하게 끔 하면 좋을 듯
    찾으면 그 부분 제거하고 마지막에 넣어주고, 이런식으로 하면 될듯
    그런데 만약에 중복된 값이 들어있으면? 이것도 상관없는거 일듯
 */