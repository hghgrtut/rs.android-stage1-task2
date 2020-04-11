package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val arr: Array<Int> = arrayOf(1, 2, 0)
        while (arr[0]*arr[1]<n){
            arr[1]=arr[1]+arr[0]
            arr[0]=arr[1]-arr[0]
        }
        if (arr[0]*arr[1]==n) arr[2]=1
        return arr.toIntArray()
    }
}
