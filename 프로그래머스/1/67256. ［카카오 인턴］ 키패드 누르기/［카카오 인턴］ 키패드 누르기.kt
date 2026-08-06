class Solution {
    fun solution(numbers: IntArray, hand: String): String{
        var answer = ""

        var rights = intArrayOf(3, 6, 9)
        var lefts = intArrayOf(1, 4, 7)
        var middles = intArrayOf(0, 2, 5, 8)
        
        // x, y
        val pad = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(0, 0), intArrayOf(1, 0), intArrayOf(2, 0), 
            intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 1),
            intArrayOf(0, 2), intArrayOf(1, 2), intArrayOf(2, 2)
        )

        var curLeft = intArrayOf(0, 3)
        var curRight = intArrayOf(2, 3)

        for (currentNumber in numbers){
            val currentLocation = pad.get(currentNumber)

            if(currentNumber in rights){
                answer = answer.plus("R")
                curRight = currentLocation
            }
            if(currentNumber in lefts){
                answer = answer.plus("L")
                curLeft = currentLocation
            }
            if(currentNumber in middles){

                val leftDistance = distance(curLeft, currentLocation)
                val rightDistance = distance(curRight, currentLocation)

                if(leftDistance == rightDistance){
                    if(hand.equals("right")){
                        answer = answer.plus("R")
                        curRight = currentLocation
                    }else{
                        answer = answer.plus("L")
                        curLeft = currentLocation
                    }
                } else if(leftDistance < rightDistance){
                    answer = answer.plus("L")
                    curLeft = currentLocation
                } else if(leftDistance > rightDistance){
                    answer = answer.plus("R")
                    curRight = currentLocation
                }
            }

        }


        return answer
    }

    fun distance(cur: IntArray, dest: IntArray): Int {
        return Math.abs(cur[0] - dest[0]) + Math.abs(cur[1] - dest[1])
    }
    
}

fun main(){
    print(Solution().solution(intArrayOf(1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5), "right"))
}