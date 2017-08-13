package com.nik.solubles.sort;

import java.util.Collection;
import java.util.List;

public interface Sort {

	public <E extends Comparable<E>> List<E> sort(final List<E> coll);
}
