package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestRemove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> myList= new ArrayList<>();
		System.out.println(myList);
		myList.add(null);myList.add(null);myList.add(null);myList.add(5);myList.add(null);
		System.out.println(myList);
		myList.removeIf(TestRemove::isNullActionFormValidator);
		System.out.println(myList);
	}
	protected static boolean isNullActionFormValidator(final Object formValidator) {
		return Objects.isNull(formValidator);
	}
}
