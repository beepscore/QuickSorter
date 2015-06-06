package com.beepscore.android.quicksorter;

import java.util.ArrayList;
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
    public void quickSort(ArrayList<Integer> list, int lo, int hi) {

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
    public Integer partition(ArrayList<Integer> list, int lo, int hi) {

        if (list == null) {
            return hi;
        }

        if (list.size() == 1) {
            return hi;
        }

        if (list.size() == 2) {
            if (list.get(0) > list.get(1)) {
                Collections.swap(list, 0, 1);
            }
            return hi;
        }

        // TODO: fixme.
        // list has >= 3 elements
        int middleIndex = calculateMiddleIndex(list, lo, hi);
        int pivotIndex = calculatePivotIndex(list, lo, hi);
        int pivotValue = list.get(pivotIndex);

        // move pivot value to middleIndex if necessary
        if (list.get(middleIndex) != list.get(pivotIndex)) {
            Collections.swap(list, middleIndex, pivotIndex);
        }

        // move 2 indices inward, swap as necessary
        // increment index until find a swappable
        int index;
        for (index = lo; index <= middleIndex; ++index) {

            if (list.get(index) > pivotValue) {

                // decrement currentEndIndex until find a swappable
                for (int currentEndIndex = hi; currentEndIndex > middleIndex; --currentEndIndex) {

                    if (list.get(currentEndIndex) < pivotValue) {
                        Collections.swap(list, lo, currentEndIndex);
                        //storeIndex += 1;
                    }
                }
            }
        }
        return index;
    }

    public Integer medianOfThreeValues(Integer a, Integer b, Integer c) {

        Integer median = a;

        if (((b > a) && (b <= c))
                || ((b < a) && (b >= c))) {
            median = b;
        }
        else if (((c > a) && (c <= b))
                || ((c < a) && (c >= b))) {
            median = c;
        }
        return median;
    }

    public int calculateMiddleIndex(ArrayList<Integer> list, int lo, int hi) {
        // use lo + difference
        // Reduces chance of integer overflow from (lo + hi)
        // integer division truncates
        int middleIndex = lo + ((hi - lo) / 2);
        return middleIndex;
    }

    /**
     * Examines value at lo, hi, and middleIndex
     * @param list a mutable list of elements that may be compared. list length must be >= 3.
     * @return index with median value.
     * This helps avoid worst case behavior if list has duplicates or is already sorted in either order.
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public int calculatePivotIndex(ArrayList<Integer> list, int lo, int hi) {
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
