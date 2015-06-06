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
