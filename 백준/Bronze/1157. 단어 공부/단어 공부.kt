fun main(){
    val n:String = readln()

    val upperN = n.uppercase()

    var countChar:Array<Int> = Array<Int>(26) {0}

    for (i in upperN){
        var intChar = i
        countChar[intChar - 'A']++
    }

    var ans:String = "?"
    var max:Int = 0
    for (i in 0..25){

        if(countChar[i] == max){
            ans = "?"
        }else if (countChar[i] > max){
            max = countChar[i]
            ans = ('A' + i).toString()
        }
    }
    println(ans)
}