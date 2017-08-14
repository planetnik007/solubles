package com.nik.solubles.sort;

import java.util.List;

import com.google.common.collect.Lists;

public class SelectionSort implements Sort {

	@Override
	public <E extends Comparable<E>> List<E> sort(final List<E> coll) {
		final int collSize = coll.size();
		final List<E> sorted = Lists.newArrayList(coll);
		E highest = null;
		int highestIndex = -1;
		for (int i = 0; i < collSize; i ++) {
			final E iElement = sorted.get(0);
			highest = iElement;
			highestIndex = 0;
			int j = 0;
			for (j = 0; j < (collSize - i); j++) {
				final E jElement = sorted.get(j);
				if (highest.compareTo(jElement) < 0) {
					highest = jElement;
					highestIndex = j;
				}
			}
			swap(sorted, highestIndex, j - 1);
		}
		return sorted;
	}

}
