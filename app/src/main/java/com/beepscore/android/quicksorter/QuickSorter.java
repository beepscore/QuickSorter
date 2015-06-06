package com.beepscore.android.quicksorter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by stevebaker on 6/5/15.
 */
public class QuickSorter {

    ArrayList<Integer> mSortedList = null;

    /** Does not alter supplied list.
     *
     * @param list a list of elements that may be compared
     * @return a list sorted in increasing order
     */
    public ArrayList<Integer> quickSort(ArrayList<Integer> list) {

        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }

        // Make a new mSortedList as a copy of list.
        // This prevents changes to mSortedList from affecting mutable list
        mSortedList = new ArrayList<>(list);

        if (mSortedList.size() == 2) {
            if (mSortedList.get(0) <= mSortedList.get(1)) {
                return mSortedList;
            } else {
                Collections.swap(mSortedList, 0, 1);
                return mSortedList;
            }
        }

        return null;
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
