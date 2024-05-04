package binary_search

import org.example.binary_search.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class BinarySearchKtTest {

    @Test
    fun `takes a list of integers and a integer`() {
        BinarySearch.findIndex(listOf(1, 2, 3), 2)
    }

    @Test
    fun `if empty list return null`() {
        val search: Int? = BinarySearch.findIndex(listOf(), 4)
        assertThat(search).isNull()
    }

    @Test
    fun `if element not in the list returns null`() {
        val search: Int? = BinarySearch.findIndex(listOf(1), 4)
        assertThat(search).isNull()
    }

    @Test
    fun `if list length is one and exists must return index 0`() {
        val search: Int? = BinarySearch.findIndex(listOf(1), 1)
        assertThat(search).isEqualTo(0)
    }

    @Test
    fun `if 2 elements and element in first place should return 0`() {
        val search: Int? = BinarySearch.findIndex(listOf(1, 2), 1)
        assertThat(search).isEqualTo(0)
    }

    @Test
    fun `if 2 elements and element in second place should return 1`() {
        val search: Int? = BinarySearch.findIndex(listOf(1, 2), 2)
        assertThat(search).isEqualTo(1)
    }

    @Test
    fun `if 11 elements and last place should return 10`() {
        val search: Int? = BinarySearch.findIndex(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11), 11)
        assertThat(search).isEqualTo(10)
    }

    @Test
    fun `finds negative number too`() {
        val search: Int? = BinarySearch.findIndex(
            listOf(-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11),
            -1
        )
        assertThat(search).isEqualTo(1)
    }
}