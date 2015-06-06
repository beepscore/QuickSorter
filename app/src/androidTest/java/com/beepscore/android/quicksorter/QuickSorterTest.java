package com.beepscore.android.quicksorter;

import junit.framework.TestCase;

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

}
