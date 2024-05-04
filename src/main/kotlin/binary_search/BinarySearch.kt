package org.example.binary_search

// http://codekata.com/kata/kata02-karate-chop/
object BinarySearch {

    fun findIndex(searchList: List<Int>, searchElement: Int): Int? {
        return findIndexRecursive(searchList, searchElement)
    }

    fun findIndexLoop(searchList: List<Int>, searchElement: Int): Int? {
        var startIndex = 0
        var endIndex = searchList.lastIndex

        while (startIndex <= endIndex) {
            val index = (startIndex + endIndex) / 2

            val elementIsBigger = searchList[index] < searchElement
            val elementIsSmaller = searchList[index] > searchElement

            if (elementIsBigger) {
                startIndex = index + 1
            } else if (elementIsSmaller) {
                endIndex = index - 1
            } else {
                return startIndex
            }
        }
        return null
    }

    fun findIndexRecursive(
        searchList: List<Int>,
        searchElement: Int,
        startIndex: Int = 0,
        endIndex: Int = searchList.lastIndex
    ): Int? {
        if (startIndex > endIndex) {
            return null
        }

        val index = (startIndex + endIndex) / 2
        val elementIsBigger = searchList[index] < searchElement
        val elementIsSmaller = searchList[index] > searchElement

        return if (elementIsBigger) {
            findIndexRecursive(searchList, searchElement, index + 1, endIndex)
        } else if (elementIsSmaller) {
            findIndexRecursive(searchList, searchElement, startIndex, index - 1)
        } else {
            startIndex
        }
    }
}

fun List<Int>.myBinarySearch(element: Int): Int? {
    return BinarySearch.findIndex(this, element)
}

fun main() {
    println(listOf(-1, 0, 1, 2, 3, 4, 5, 20, 21).myBinarySearch(20))
}