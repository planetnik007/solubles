package com.nik.solubles.sort;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class SelectionSortTest extends BaseSortTest {

	public SelectionSortTest() {
		super(new SelectionSort());
	}

	@Test
	public void testSmallReverseSorted() {
		final String prefix = "testSmallReverseSorted";
		final List<Integer> unsorted = Lists.newArrayList(7, 6, 5, 4, 3, 2, 1);
		assertSort(prefix, unsorted);
	}
}
