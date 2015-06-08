package com.beepscore.android.quicksorter;

import java.util.List;
import java.util.Collections;

/**
 * Created by stevebaker on 6/5/15.
 */
public class QuickSorter {

    /** Sorts list elements within inclusive range startIndex to endIndex.
     * Sorts supplied list in place.
     * @param list a mutable list of elements that may be compared
     * @param lo to sort entire list use 0
     * @param hi to sort entire list use list.size() - 1
     * Reference
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public void quickSort(List<Integer> list, int lo, int hi) {

        if (lo < hi) {
            Integer partitionIndex = partition(list, lo, hi);
            // recurse
            quickSort(list, lo, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, hi);
        }
    }

    /** Partition list elements within inclusive range lo to hi.
     * Alters supplied mutable list by sorting elements into two partitions.
     * Small elements on left side and large elements to right side.
     * @param list a mutable list of elements that may be compared
     * @param lo beginning of range to sort
     * @param hi end of range to sort
     * @return partitionIndex. return hi if list is fully sorted
     * return null if list null.
     * Reference
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public Integer partition(List<Integer> list, int lo, int hi) {

        if (list == null) {
            return hi;
        }

        if (list.size() == 1) {
            return hi;
        }

        int pivotIndex = calculatePivotIndex(list, lo, hi);
        int pivotValue = list.get(pivotIndex);

        // swap pivot value into hi if it isn't there already
        if (list.get(pivotIndex) != list.get(hi)) {
            Collections.swap(list, pivotIndex, hi);
        }

        int storeIndex = lo;
        for (int index = lo; index <= hi - 1; ++index) {

            if (list.get(index) < pivotValue) {
                Collections.swap(list, index, storeIndex);
                storeIndex = storeIndex + 1;
            }
        }

        // swap pivot value from hi to storeIndex
        Collections.swap(list, storeIndex, hi);

        return storeIndex;
    }

    public int calculateMiddleIndex(List<Integer> list, int lo, int hi) {
        // use lo + difference
        // Reduces chance of integer overflow from (lo + hi)
        // integer division truncates
        int middleIndex = lo + ((hi - lo) / 2);
        return middleIndex;
    }

    /**
     * Examines value at lo, hi, and middleIndex. If list.size() == 2, middleIndex == 0.
     * @param list a mutable list of elements that may be compared.
     * @param lo beginning of range for partition
     * @param hi end of range for partition
     * @return index containing median value.
     * This helps avoid worst case behavior if list has duplicates or is already sorted in either order.
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public int calculatePivotIndex(List<Integer> list, int lo, int hi) {
        // use start + difference
        // Reduces chance of integer overflow from (start + end)
        // integer division truncates
        int middleIndex = calculateMiddleIndex(list, lo, hi);

        int pivotIndex = middleIndex;

        if (((list.get(lo) > list.get(middleIndex) ) && (list.get(lo) <= list.get(hi)))
                || ((list.get(lo) < list.get(middleIndex) ) && (list.get(lo) >= list.get(hi)))) {
            pivotIndex = lo;
        }
        else if (((list.get(hi) > list.get(middleIndex) ) && (list.get(hi) <= list.get(lo)))
                || ((list.get(hi) < list.get(middleIndex) ) && (list.get(hi) >= list.get(lo)))) {
            pivotIndex = hi;
        }
        return pivotIndex;
    }

}
