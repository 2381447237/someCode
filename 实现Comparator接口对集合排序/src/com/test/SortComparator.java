package com.test;

import java.util.Comparator;

import com.test.bean.A;

public class SortComparator implements Comparator{

	public int compare(Object lhs, Object rhs) {
		
		A a=(A) lhs;
		A b=(A) rhs;
		return (b.getLevel()-a.getLevel());
	}
	
}
