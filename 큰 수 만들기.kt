import kotlin.math.max

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var remainedNumber = number
        var remainedK = k
        var maxFirstNumber: Int
        var maxFirstNumberIdx: Int

        while (remainedK > 0) {
            maxFirstNumber = findMaxFirstNumber(remainedNumber, remainedK)
            answer += maxFirstNumber

            maxFirstNumberIdx = remainedNumber.indexOf(maxFirstNumber.toString())
            remainedK -= maxFirstNumberIdx
            remainedNumber = remainedNumber.substring(maxFirstNumberIdx + 1)
        }

        return answer + remainedNumber
    }

    private fun findMaxFirstNumber(number: String, startRange: Int): Int {
        var maxFirstNumber = number[0].toString().toInt()
        for (i in 1..startRange) {
            maxFirstNumber = max(maxFirstNumber, number[i].toString().toInt())
        }
        return maxFirstNumber
    }
}