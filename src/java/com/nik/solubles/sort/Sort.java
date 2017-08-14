package com.nik.solubles.sort;

import java.util.Collection;
import java.util.List;

public interface Sort {

	public <E extends Comparable<E>> List<E> sort(final List<E> coll);

	default <E extends Comparable<E>> void swap(final List<E> coll, final int swapIndexFor, final int swapIndexWith) {
		final E temp = coll.get(swapIndexFor);
		coll.set(swapIndexFor, coll.get(swapIndexWith));
		coll.set(swapIndexWith, temp);
	}
}
