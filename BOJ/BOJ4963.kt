/**
 * 2020.08.04
 * DevHyeon
 * BOJ4963 : 섬의 개수
 */
import java.util.*
fun main(){
    val scan = Scanner(System.`in`)

    var testCase = scan.nextLine()
    while(testCase != "0 0"){
        val w: Int
        val h: Int
        var answer  = 0

        testCase.split(" ").let {
            w = it[0].toInt()
            h = it[1].toInt()
        }
        var map = Array(h) { IntArray(w) } // 맵
        var check = Array(h){ BooleanArray(w) } // 방문구역 체크

        for(i in map.indices){
            map[i] = IntArray(w)
            check[i] = BooleanArray(w)
            scan.nextLine().split(" ").let {
                for (j in it.indices) {
                    map[i][j] = it[j].toInt()
                }
            }
        }
        for(i in map.indices){
            for(j in map[i].indices){
                if(!check[i][j] && map[i][j]==1){
                    check[i][j] = true
                    bfs(check,map,i,j)
                    answer++
                }
            }
        }
        println(answer)
        testCase = scan.nextLine()
    }
}

fun bfs(check: Array<BooleanArray>, map: Array<IntArray>, i: Int, j:Int) {
    val di = arrayOf(-1,0,1,0,-1,-1,1,1)
    val dj = arrayOf(0,-1,0,1,-1,1,-1,1)
    val q: Queue<Node> = LinkedList()

    q.add(Node(i,j))

    while(!q.isEmpty()){
        q.poll().apply{
            for(i in di.indices){
                val dx = x+di[i]
                val dy = y+dj[i]
                if(dx>=0 && dy>=0 && dx<map.size && dy<map[0].size && !check[dx][dy] && map[dx][dy]==1){
                    q.offer(Node(dx,dy))
                    check[dx][dy] = true
                }
            }
        }
    }
}

data class Node(val x: Int, var y:Int)