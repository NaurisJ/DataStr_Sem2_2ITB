package service;

import datastr.MyLinkedList;

public class MainService {
	
	public static void main(String[] args) {
		MyLinkedList<Integer> linkedListForInt = new MyLinkedList<Integer>();
		
		linkedListForInt.add(45); // 45
		linkedListForInt.add(100); // 45 100
		linkedListForInt.add(-200); // 45 100 -200
		linkedListForInt.add(1000); // 45 100 -200 1000
		
		try {
			linkedListForInt.print();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
