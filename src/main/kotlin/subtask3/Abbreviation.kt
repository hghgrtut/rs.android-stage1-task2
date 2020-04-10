package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var k=0
        for (i in a){if (b[k]==i || b[k].toLowerCase()==i){
            k++
            if (k==b.length) return "YES"}}
        return  "NO"
    }
}
