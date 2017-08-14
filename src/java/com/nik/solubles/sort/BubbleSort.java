package com.nik.solubles.sort;

import java.util.List;

import com.google.common.collect.Lists;

public class BubbleSort implements Sort {

	@Override
	public <E extends Comparable<E>> List<E> sort(final List<E> coll) {
		final int collSize = coll.size();
		final List<E> sorted = Lists.newArrayList(coll);
		for (int i = collSize; i > 0; i --) {
			bubblePass(sorted, i);
		}
		return sorted;
	}

	private <E extends Comparable<E>> void bubblePass(final List<E> coll, final int passSize) {
		int i = 0;
		int j = 1;
		while (i < passSize && j < passSize) {
			final E iElement = coll.get(i);
			final E jElement = coll.get(j);
			if (iElement.compareTo(jElement) >= 0) {
				swap(coll, i, j);
			}
			i ++;
			j ++;
		}
	}
}
