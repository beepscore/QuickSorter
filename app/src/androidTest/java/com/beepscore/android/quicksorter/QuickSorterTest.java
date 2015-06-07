package com.beepscore.android.quicksorter;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by stevebaker on 6/5/15.
 */
public class QuickSorterTest extends TestCase {

    QuickSorter sorter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        sorter = new QuickSorter();
    }

    public void testQuickSorterNotNull() {
        assertNotNull(sorter);
    }

    public void testCalculatePivotIndex() {

        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(4);
        list.add(5);
        assertEquals(2, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(3);
        list.add(5);
        list.add(7);
        assertEquals(1, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(3);
        list.add(7);
        list.add(5);
        assertEquals(2, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(7);
        assertEquals(0, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(5);
        list.add(7);
        list.add(3);
        assertEquals(0, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(7);
        list.add(3);
        list.add(5);
        assertEquals(2, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(7);
        list.add(5);
        list.add(3);
        assertEquals(1, sorter.calculatePivotIndex(list, 0, list.size() - 1));
    }

    public void testCalculatePivotIndexDuplicates() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-5);
        list.add(8);
        list.add(-5);
        assertEquals(0, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(6);
        list.add(-8);
        list.add(-8);
        assertEquals(1, sorter.calculatePivotIndex(list, 0, list.size() - 1));
    }

    public void testQuickSorterSortListNull() {
        ArrayList<Integer> actual = null;
        sorter.quickSort(actual, 0, 1);
        assertNull(actual);
    }

    public void testQuickSorterSortListOneElement() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSorterSortListTwoElements() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(5);
        actual.add(4);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSorterSortListTwoElementsSorted() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSorterSortListThreeElements() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        expected.add(10);
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(10);
        actual.add(4);
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

}
