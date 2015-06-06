package com.beepscore.android.quicksorter;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by stevebaker on 6/5/15.
 */
public class QuickSorterTest extends TestCase {

    QuickSorter sorter;

    ArrayList<Integer> mList = null;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sorter = new QuickSorter();

        mList = new ArrayList<>();
        mList.add(5);
    }

    public void testQuickSorterNotNull() {
        assertNotNull(sorter);
    }

    public void testQuickSorterSortListNull() {
        mList = null;
        ArrayList<Integer> actual = sorter.quickSort(mList);
        assertNull(actual);
    }

}
