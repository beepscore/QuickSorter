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
     * @param startIndex to sort entire list use 0
     * @param endIndex to sort entire list use list.size() - 1
     * Reference
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public void quickSort(ArrayList<Integer> list, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            Integer partitionIndex = partition(list, startIndex, endIndex);
            // recurse
            quickSort(list, startIndex, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, endIndex);
        }

    }

    /** Partition list elements within inclusive range startIndex to endIndex.
     * Alters supplied mutable list by sorting elements into two partitions.
     * Small elements on left side and large elements to right side.
     * @param list a mutable list of elements that may be compared
     * @param startIndex beginning of range to sort
     * @param endIndex end of range to sort
     * @return partitionIndex. return endIndex if list is fully sorted
     * return null if list null.
     * Reference
     * https://en.wikipedia.org/wiki/Quicksort
     */
    public Integer partition(ArrayList<Integer> list, int startIndex, int endIndex) {

        if (list == null) {
            return endIndex;
        }

        if (list.size() == 1) {
            return endIndex;
        }

        if (list.size() == 2) {
            if (list.get(0) > list.get(1)) {
                Collections.swap(list, 0, 1);
            }
            return endIndex;
        }

        // TODO: fixme. May want to find pivotIndex
        // list has >= 3 elements
        // use start + difference to reduce chance of integer overflow (start + end)
        // integer division truncates
        int middleIndex = startIndex + ((endIndex - startIndex) / 2);

        // use median to help avoid worst case behavior if list is already sorted
        // https://en.wikipedia.org/wiki/Quicksort
        int pivot = medianOfThreeValues(list.get(startIndex),
                list.get(middleIndex), list.get(endIndex));

        // move 2 indices inward, swap as necessary
        // increment startIndex until find a swappable
        for (int index = startIndex; index <= middleIndex; ++index) {
            if (list.get(startIndex) > pivot) {

                // decrement currentEndIndex until find a swappable
                for (int currentEndIndex = endIndex; currentEndIndex >= middleIndex; --currentEndIndex) {

                    if (list.get(currentEndIndex) < pivot) {
                        Collections.swap(list, startIndex, currentEndIndex);
                    }
                }
                // ending side has no more values to swap, so starting side is done too
                break;
            }
        }
        return middleIndex;
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

}
