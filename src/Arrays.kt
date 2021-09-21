fun main() {

    val arr1 = arrayOf(1, 2, "String", 3.4)

    val arr2 = intArrayOf(1, 2, 3, 4)

    val arr3 = arrayOfNulls<Int>(5)
    val arr4 = emptyArray<Int>()
    println(arr4.size)
    println("arr3 content: " + arr3.contentToString())
    println("arr4 content: " + arr4.contentToString())


    val arr5 = IntArray(5)
    val arr6 = IntArray(5) { i -> i * 2 }

    println(arr6.contentToString())


    val arr7 = arrayOf<Int>()

    val list1 = listOf(1, 2, 3, 4)
    val arr8 = list1.toTypedArray()

    val arr9 = IntArray(5)
    val list2 = arr9.toList()

    val arr10 = (1..10).toList().toTypedArray()
    val arr11 = IntArray(9) { x -> x + 1 }

    println(arr10.contentToString())


    val arr12 = IntArray(5)
}