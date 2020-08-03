/**
 * 2020.08.04
 * DevHyeon
 * BOJ1748 : 수 이어 쓰기 1
 */
import java.util.*
fun main(){
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()

    var answer = 0

    for(i in 1..n){
        when(i){
            in 1..9 -> answer++
            in 10..99 -> answer+=2
            in 100..999 -> answer+=3
            in 1000..9999 -> answer+=4
            in 10000..99999 -> answer +=5
            in 100000..999999 -> answer += 6
            in 1000000..9999999 -> answer += 7
            in 10000000..99999999 -> answer += 8
            else -> answer += 9
        }
    }
    println(answer)
}