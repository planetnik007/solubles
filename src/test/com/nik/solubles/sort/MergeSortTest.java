package com.nik.solubles.sort;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class MergeSortTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeSortTest.class);

	private Sort mergeSort = new MergeSort();

	@Test
	public void testSmallSorted() {
		final String prefix = "testSmallSorted";
		final List<Integer> unsorted = Lists.newArrayList(1, 2, 3, 4, 5);
		assertSort(prefix, unsorted);
	}

	@Test
	public void testSorted() {
		final String prefix = "testSorted";
		final List<Integer> unsorted = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
		assertSort(prefix, unsorted);
	}

	@Test
	public void testSmallReverseSorted() {
		final String prefix = "testSmallReverseSorted";
		final List<Integer> unsorted = Lists.newArrayList(7, 6, 5, 4, 3, 2, 1);
		assertSort(prefix, unsorted);
	}

	@Test
	public void testReverseSorted() {
		final String prefix = "testReverseSorted";
		final List<Integer> unsorted = Lists.newArrayList(20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		assertSort(prefix, unsorted);
	}

	@Test
	public void testHugeRandom() {
		final String prefix = "testHugeRandom";
		final int LIST_SIZE = 50000;
		final Random random = new Random();
		//final Set<Integer> integerSet = Sets.newHashSetWithExpectedSize(LIST_SIZE);
		final List<Integer> unsorted = Lists.newArrayListWithExpectedSize(LIST_SIZE);
		for (int i = 0; i < LIST_SIZE; i ++) {
			final Integer randomInt = random.nextInt(Integer.MAX_VALUE);
			unsorted.add(randomInt);
		}
		assertSort(prefix, unsorted);
	}

	@Test
	public void testHugeReverseSorted() {
		final String prefix = "testHugeReverseSorted";
		final int LIST_SIZE = 50000;
		final List<Integer> unsorted = Lists.newArrayListWithExpectedSize(LIST_SIZE);
		for (int i = LIST_SIZE; i >= 0; i --) {
			unsorted.add(i);
		}
		assertSort(prefix, unsorted);
	}

	private void assertSort(final String prefix, final List<Integer> unsorted) {
		LOGGER.info("{} - unsorted:{}", prefix, unsorted);
		final List<Integer> sorted = mergeSort.sort(unsorted);
		LOGGER.info("{} - sorted:{}", prefix, sorted);
		Assert.assertEquals(prefix + " failure: sorted list size does not match", sorted.size(), unsorted.size());
		int prevVal = Integer.MIN_VALUE;
		for (final int val : sorted) {
			if (val < prevVal) {
				Assert.fail(prefix + " failure: list sorting failed");
			}
			prevVal = val;
		}
	}
}
