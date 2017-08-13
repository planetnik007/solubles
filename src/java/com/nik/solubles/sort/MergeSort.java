package com.nik.solubles.sort;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.nik.solubles.sort.Sort;

public class MergeSort implements Sort {

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeSort.class);

	@Override
	public <E extends Comparable<E>> List<E> sort(final List<E> coll) {
		return split(coll);
	}

	private <E extends Comparable<E>> List<E> split(final List<E> coll) {
		if (coll.size() <= 1) {
			return coll;
		}
		final int mid = coll.size() / 2;
		final List<E> first = coll.subList(0, mid);
		final List<E> second = coll.subList(mid, coll.size());
		LOGGER.trace("SPLIT - first:{}", first);
		LOGGER.trace("SPLIT - second:{}", second);
		LOGGER.trace("-------");
		return merge(split(first), split(second));
	}

	private <E extends Comparable<E>> List<E> merge(final List<E> first, final List<E> second) {
		int firstIndex = 0;
		int secondIndex = 0;
		final List<E> sorted = Lists.newArrayListWithExpectedSize(first.size() + second.size());
		LOGGER.trace("MERGE - first:{} second:{}", first, second);
		while (firstIndex < first.size() && secondIndex < second.size()) {
			final E firstElement = first.get(firstIndex);
			final E secondElement = second.get(secondIndex);
			LOGGER.trace("COMPARING - firstElement:{} secondElement:{}", firstElement, secondElement);
			if (firstElement.compareTo(secondElement) < 0) {
				LOGGER.trace("ADDING - firstElement:{}", firstElement);
				sorted.add(firstElement);
				firstIndex ++;
			} else {
				LOGGER.trace("ADDING - secondElement:{}", secondElement);
				sorted.add(secondElement);
				secondIndex ++;
			}
		}
		if (firstIndex < first.size()) {
			sorted.addAll(first.subList(firstIndex, first.size()));
		} else if (secondIndex < second.size()) {
			sorted.addAll(second.subList(secondIndex, second.size()));
		}
		LOGGER.trace("MERGED - sorted:{}", sorted);
		LOGGER.trace("-------");
		return sorted;
	}
}
