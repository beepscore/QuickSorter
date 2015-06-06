package com.beepscore.android.quicksorter;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by stevebaker on 6/5/15.
 */
public class QuickSorterTest extends TestCase {

    QuickSorter sorter;

    ArrayList<Integer> mList = null;
    ArrayList<Integer> expectedList = null;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sorter = new QuickSorter();
        mList = null;
    }

    public void testQuickSorterNotNull() {
        assertNotNull(sorter);
    }

    public void testMedianOfThreeValues() {
        assertEquals(Integer.valueOf(0), sorter.medianOfThreeValues(0, 0, 0));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(3, 5, 7));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(3, 7, 5));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(5, 3, 7));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(5, 7, 3));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(7, 3, 5));
        assertEquals(Integer.valueOf(5), sorter.medianOfThreeValues(7, 5, 3));
    }

    public void testMedianOfThreeValuesDuplicates() {
        assertEquals(Integer.valueOf(-5), sorter.medianOfThreeValues(-5, 8, -5));
        assertEquals(Integer.valueOf(-8), sorter.medianOfThreeValues(6, -8, -8));
    }

    public void testQuickSorterSortListNull() {
        ArrayList<Integer> actual = sorter.quickSort(null);
        assertNull(actual);
    }

    public void testQuickSorterSortListOneElement() {
        mList = new ArrayList<Integer>();
        mList.add(5);
        ArrayList<Integer> actual = sorter.quickSort(mList);
        assertEquals(mList, actual);
    }

    public void testQuickSorterSortListTwoElements() {
        mList = new ArrayList<Integer>();
        mList.add(5);
        mList.add(4);
        expectedList = new ArrayList<Integer>();
        expectedList.add(4);
        expectedList.add(5);
        ArrayList<Integer> actual = sorter.quickSort(mList);
        assertEquals(expectedList, actual);
    }

    public void testQuickSorterSortListTwoElementsSorted() {
        mList = new ArrayList<Integer>();
        mList.add(4);
        mList.add(5);
        ArrayList<Integer> actual = sorter.quickSort(mList);
        assertEquals(mList, actual);
    }
}
