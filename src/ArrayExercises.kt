/* In this file, I simply rewrite some built-in functions for lists.
	- copy()	Returns a copy of the array
	- extend()	Add the elements of an array, to the end of the current array
	- index()	Returns the index of the first element with the specified value
	- insert()	Adds an element at the specified position
	- remove()	Removes the first item with the specified value
	- reverse()	Reverses the order of the list
	- sort()	Sorts the list (implement more than one algorithm)
 */

fun main() {
    val arr1 = arrayOf<Any>(1, 2, 3, "str1, str2", "str3")
    println("Inser 4 into 3: " + myArrayInsert(arr1, 4, 3).contentToString())

    val arr2 = arrayOf<Any>(1, 2, 3, "str1", "str2", "str3")
    println("Copied array: " + myArrayCopy(arr2).contentToString())

    val arr3 = arrayOf<Any>(4, 5, 6, "str4", "str5", "str6")
    println("Extended array: " + myArrayExtend(arr2, arr3).contentToString())

    println("Index of str4: " + myArrayIndexOf(arr3, "str4"))
    println("Index of str7: " + myArrayIndexOf(arr3, "str7"))

    println("Remove str4: " + myArrayRemove(arr3, "str4").contentToString())

    println("Reversed: " + myArrayReverse(arr3).contentToString())

    var arr4 = arrayOf(5, 4, 3, 2, 1)
    println("BubbleSort: " + myArrayBubbleSort(arr4).contentToString())

    println("InsertionSort: " + myArrayInsertionSort(arr4).contentToString())

    println("SelectionSort: " + myArraySelectionSort(arr4).contentToString())

}

fun myArraySelectionSort(arr: Array<Int>): Array<Int>{

    var temp = 0
    for (i in arr.indices){
        var minElement = arr[i]
        var indexOfMinElement = i
        for (j in i until arr.lastIndex){
            if (arr[j] < minElement){
                minElement = arr[j]
                indexOfMinElement = j
            }
        }
        temp = arr[indexOfMinElement]
        arr[indexOfMinElement] = arr[i]
        arr[i] = temp
    }
    return arr
}

fun myArrayInsertionSort(arr: Array<Int>): Array<Int> {
    for (i in 0 until arr.lastIndex - 1) {
        if (arr[i + 1] < arr[i]) {
            for (j in i downTo 1) {
                var temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            }
        }

    }
    return arr
}

fun myArrayBubbleSort(arr: Array<Int>): Array<Int> {
    for (i in arr.indices) {
        for (j in 0 until arr.size - 1) {
            if (arr[j + 1] < arr[j]) {
                var temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
            }
        }
    }
    return arr
}

fun myArrayReverse(arr: Array<Any>): Array<Any> {
    var temp: Any = 0
    for (i in 0 until arr.size / 2) {
        temp = arr[i]
        arr[i] = arr[arr.size - 1 - i]
        arr[arr.size - 1 - i] = temp
    }
    return arr
}

fun myArrayRemove(arr: Array<Any>, item: Any): Array<Any> {
    var newArr = arrayOfNulls<Any>(arr.size - 1)
    var j = 0
    for (i in arr.indices) {
        if (arr[i] != item) {
            newArr[j] = arr[i]
            j++
        }
    }
    return newArr as Array<Any>
}

fun myArrayIndexOf(arr: Array<Any>, item: Any): Int {
    for (i in arr.indices) {
        if (arr[i] == item)
            return i
    }
    return -1
}

fun myArrayExtend(arr1: Array<Any>, arr2: Array<Any>): Array<Any> {
    val newArray = arrayOfNulls<Any>(arr1.size + arr2.size)
    for (i in arr1.indices) {
        newArray[i] = arr1[i]
    }
    var i = arr1.size
    for (j in arr2.indices) {
        newArray[i] = arr2[j]
        i++
    }

    return newArray as Array<Any>
}

fun myArrayCopy(arr: Array<Any>): Array<Any> {
    val newArr = arrayOfNulls<Any>(arr.size)
    for (i in arr.indices)
        newArr[i] = arr[i]

    return newArr as Array<Any>
}

fun myArrayInsert(arr: Array<Any>, item: Any, index: Int): Array<Any> {
    for (i in index until arr.size - 1) { // this block can be extracted as a separate function
        arr[i + 1] = arr[i]
    }
    arr[index] = item

    return arr
}