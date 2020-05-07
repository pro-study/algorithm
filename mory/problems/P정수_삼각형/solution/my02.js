function solution(triangle) {

    // 체크할 것 하나 있으면 되고
    // for 이중 으로 돌리면서 올라가면 되나

    let tmp = [];
    let triangleLength = triangle.length - 1;

    for (let i = 0; i < triangle.length; i++)
        tmp[i] = new Array(i + 1).fill(0);

    for (let i = triangleLength; i >= 0; i--) {
        for (let j = 0; j < triangle[i].length; j++) {
            if (i === triangleLength) {
                tmp[i][j] = triangle[i][j];
                continue;
            }

            tmp[i][j] = triangle[i][j] + Math.max(tmp[i + 1][j], tmp[i + 1][j + 1]);
        }
    }

    return tmp[0][0];
}


module.exports = solution;