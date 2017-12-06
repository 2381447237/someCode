package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.bean.A;

public class Test {

	public static void main(String[] args) {
		
		List<A> list=new ArrayList<A>();
		list.add(new A(1));
		list.add(new A(2));
		list.add(new A(5));
		list.add(new A(4));
		list.add(new A(3));
		
		Comparator  comp=new SortComparator();
		Collections.sort(list, comp);
		System.out.println(list);
	}
	
}
