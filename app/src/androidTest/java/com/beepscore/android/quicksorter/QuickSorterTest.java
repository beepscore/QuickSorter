package com.beepscore.android.quicksorter;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void testCalculatePivotIndexListSizeTwo() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        assertEquals(0, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(4);
        list.add(5);
        assertEquals(0, sorter.calculatePivotIndex(list, 0, list.size() - 1));
    }

    public void testCalculatePivotIndexListSizeThree() {
        List<Integer> list = new ArrayList<Integer>();
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
        List<Integer> list = new ArrayList<Integer>();
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

    public void testCalculatePivotIndexListSizeFour() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        list.add(-8);
        list.add(0);
        list.add(3);
        assertEquals(3, sorter.calculatePivotIndex(list, 0, list.size() - 1));

        list = new ArrayList<Integer>();
        list.add(4);
        list.add(0);
        list.add(3);
        list.add(-8);
        assertEquals(1, sorter.calculatePivotIndex(list, 0, list.size() - 1));
    }

    public void testCalculatePivotIndexList() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(23);
        list.add(19);
        list.add(7);
        list.add(4);
        list.add(10);
        list.add(0);
        list.add(3);
        list.add(-8);
        assertEquals(3, sorter.calculatePivotIndex(list, 0, list.size() - 1));
    }

    public void testPartitionListSizeTwo() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(5);
        actual.add(4);
        sorter.partition(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testPartitionListSizeThree() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        expected.add(10);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(10);
        actual.add(4);
        actual.add(5);
        sorter.partition(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testPartitionListSizeFour() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-8);
        expected.add(0);
        expected.add(3);
        expected.add(4);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(-8);
        actual.add(0);
        actual.add(3);
        assertEquals(3, sorter.calculatePivotIndex(actual, 0, actual.size() - 1));
        sorter.partition(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testPartitionListSizeFour2() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-8);
        expected.add(0);
        expected.add(3);
        expected.add(4);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(-8);
        actual.add(0);
        actual.add(3);
        sorter.partition(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testPartitionList() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(3);
        expected.add(-8);
        expected.add(0);
        expected.add(4);
        expected.add(10);
        expected.add(19);
        expected.add(7);
        expected.add(23);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(19);
        actual.add(7);
        actual.add(23);
        actual.add(10);
        actual.add(-8);
        actual.add(0);
        actual.add(3);
        sorter.partition(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSortListNull() {
        List<Integer> actual = null;
        sorter.quickSort(actual, 0, 1);
        assertNull(actual);
    }

    public void testQuickSortListSizeOne() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSortListSizeTwo() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(5);
        actual.add(4);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSortListSizeTwoSorted() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSortListSizeThree() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(5);
        expected.add(10);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(10);
        actual.add(4);
        actual.add(5);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    public void testQuickSortList() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-8);
        expected.add(0);
        expected.add(3);
        expected.add(4);
        expected.add(7);
        expected.add(10);
        expected.add(19);
        expected.add(23);
        List<Integer> actual = new ArrayList<Integer>();
        actual.add(4);
        actual.add(19);
        actual.add(7);
        actual.add(23);
        actual.add(10);
        actual.add(-8);
        actual.add(0);
        actual.add(3);
        sorter.quickSort(actual, 0, actual.size() - 1);
        assertEquals(expected, actual);
    }

    /** Test instantiate interface List as LinkedList instead of ArrayList
     */
    public void testQuickSortLinkedList() {
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(-8);
        expected.add(0);
        expected.add(3);
        expected.add(4);
        expected.add(7);
        expected.add(10);
        expected.add(19);
        expected.add(23);
        List<Integer> actual = new LinkedList<Integer>();
        actual.add(4);
        actual.add(19);
        actual.add(7);
        actual.add(23);
        actual.add(10);
        actual.add(-8);
        actual.add(0);
        actual.add(3);
        sorter.quickSort(actual, 0, actual.size() - 1);
        // assertEquals can compare LinkedList and ArrayList as equal
        assertEquals(expected, actual);
    }

}
