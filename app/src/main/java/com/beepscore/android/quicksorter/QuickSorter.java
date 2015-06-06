package com.beepscore.android.quicksorter;

import java.util.ArrayList;

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

        if (list.size() == 2) {
            if (list.get(0) <= list.get(1)) {
                return list;
            } else {
                mSortedList = new ArrayList<Integer>();
                mSortedList.add(list.get(1));
                mSortedList.add(list.get(0));
                return mSortedList;
            }
        }

        return null;
    }
}
