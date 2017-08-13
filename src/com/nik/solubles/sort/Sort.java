package com.nik.solubles.sort;

import java.util.Collection;

public interface Sort {

	public <E extends Comparable<E>> void sort(final Collection<E> coll);
}
