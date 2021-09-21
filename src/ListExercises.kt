import kotlin.math.min

/* In this file, I simply rewrite some built-in functions for lists.
    - append()	Adds an element at the end of the list
	- copy()	Returns a copy of the list
	- count()	Returns the number of elements with the specified value
	- extend()	Add the elements of a list (or any iterable), to the end of the current list
	- index()	Returns the index of the first element with the specified value
	- insert()	Adds an element at the specified position
	- remove()	Removes the first item with the specified value
	- reverse()	Reverses the order of the list
	- sort()	Sorts the list (implement more than one algorithm)
 */
fun main() {

    val lst = listOf<Int>(1, 2, 3, 4, 5)
    println("Append 6: ${myListAppend(lst, 6)}")

    val lst2 = myListCopy(lst)
    println("Copy lst into lst2: $lst2")

    println("Count of lst2: ${myListCount(lst2)}")

    println("Extended list: ${myListExtend(lst, lst2)}")

    println("index of 4: ${myListIndexOf(lst, 4)}")

    val lst3 = listOf<Any>("Str1", "Str2", "Str3", 1.1, 2.2, 3.3)
    println("Insert 0 into 3: ${myListInsert(lst3, 3, 0)}")

    println("Removed 1.1: ${myListRemove(lst3, 1.1)}")

    println("Reversed list: ${myListReverse(lst3)}")

    val lst4 = listOf<Int>(5,4,3,2,1)
    println("BubleSort on $lst4: ${myListBubbleSort(lst4)}")

    println("InsertionSort on $lst4: ${myListInsertionSort(lst4)}")

    println("SelectionSort on $lst4: ${myListSelectionSort(lst4)}")

}

fun myListSelectionSort(lst: List<Int>): List<Int>{
    var newList = lst.toMutableList()


    for (i in 0 until newList.size){
        var minElement = newList[i]
        var index = i
        for (j in i until newList.size){ // can be extracted as findMin
            if (newList[j] < minElement){
                minElement = newList[j]
                index = j
            }
        }
        // switch
        val temp = newList[i]
        newList[i] = newList[index]
        newList[index] = temp

    }

    return newList.toList()
}

fun myListInsertionSort(lst: List<Int>): List<Int>{
    var newList = lst.toMutableList()
    for (i in 1 until newList.size){
        if (newList[i] < newList[i-1]){
            var j = i
            while (j > 0){ // can be extracted as function
                var temp = newList[j]
                newList[j] = newList[j-1]
                newList[j-1] = temp
                j--
            }
        }
    }

    return newList.toList()
}

fun myListBubbleSort(lst: List<Int>): List<Int>{
    var newList = lst.toMutableList()
    for (i in newList.indices){
        var j = 0
        while (j < newList.size-1){
            // this if block can be extracted as function called switch for the sake of readability
            if (newList[j] > newList[j+1]){
                val temp = newList[j]
                newList[j] = newList[j+1]
                newList[j+1] = temp
            }
            j++
        }
    }
    return newList.toList()
}

fun myListReverse(lst: List<Any>): List<Any> {
    var newList = arrayListOf<Any>()
    var i = lst.size - 1
    while (i >= 0) {
        newList.add(lst[i])
        i--
    }
    return newList.toList()
}

fun myListRemove(lst: List<Any>, item: Any): List<Any> {

    var index = 0
    // for the sake of readability, this for loop can be extracted as a function called findIndex, or I may use myListIndexOf function
    for (i in lst) {
        if (i == item)
            break
        index++
    }
    var newList = lst.subList(0, index).toMutableList()
    newList.addAll(index, lst.subList(index+1, lst.size))

    return newList.toList()


}

fun myListInsert(lst: List<Any>, index: Int, item: Any): List<Any> {
    var newList = lst.subList(0, index).toMutableList()
    newList.add(item)
    newList.addAll(newList.size, lst.subList(index, lst.size))

    return newList.toList()
}

fun myListIndexOf(lst: List<Any>, item: Any): Int {
    for (i in lst.indices) {
        if (lst[i] == item)
            return i
    }
    return -1
}

fun myListExtend(list1: List<Any>, list2: List<Any>): List<Any> {
    var newList = arrayListOf<Any>()
    for (i in list1)
        newList.add(i)
    for (i in list2)
        newList.add(i)

    return newList.toList()

}

fun myListCount(lst: List<Any>): Int {
    var counter = 0
    for (i in lst)
        counter++

    return counter
}

fun myListCopy(lst: List<Any>): List<Any> {
    var tempArray = arrayListOf<Any>()
    tempArray.ensureCapacity(lst.size)
    for (i in lst.indices) {
        tempArray.add(lst[i])
    }

    return tempArray.toList()

}

fun myListAppend(lst: List<Int>, number: Int): List<Int> {

    val newList = lst.toMutableList()
    newList.add(number)
    return newList.toList()

}