fun main(){

    val input = readln().split(" ")
    val N = input[0].toInt()
    val m = input[1].toInt()
    val M = input[2].toInt()
    val T = input[3].toInt()
    val R = input[4].toInt()

    // 운동을 N분 할 수 없는 경우
    if(m + T > M){
        println(-1)
        return
    }

    var time:Int = 0
    var currentPulse = m

    var workCounter = 0

    while(workCounter < N){
        time++

        if(currentPulse + T > M ){ // 휴식
            if(currentPulse - R < m){
                currentPulse = m
                continue
            }
            currentPulse -= R

        }else{
            currentPulse += T
            workCounter++
        }

    }

    println(time)
}