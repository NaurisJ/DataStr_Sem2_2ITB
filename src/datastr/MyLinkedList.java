package datastr;

public class MyLinkedList<Ttype> {
	private MyNode firstNode = null;
	private MyNode lastNode = null;
	private int counter = 0;

	
	// var netaisit bezargumenta konstruktoru, jo tas bus no java object klases
	// get un set nevajag taisit frieks firstnode un lastnode, jo lietotajam nevajag laut piekluvi
	// counter bus tikai get funkcija, jo ar set nedrikst laut lietotajam mainit
	
	public int getCounter() {
		return counter;
	}
	
	
	public int length() {
		return counter;
	}
	
	public boolean isEmpty() {
		return (counter == 0);
	}
	
	// loti iespejams, ka nekad neizpildsisies, jo OS nodrosinas RAM parvaldibu
	private boolean isFull() {
		try {
			new MyNode<Integer>(45); // meginam RAM atmina ielikt mezglu
			return false; // ja tas izdodas tad saraksts nav pilns
		} catch(OutOfMemoryError e) {
			return true; // bet ja mezglu nevar vairs RAM atmina ielikt, tad saraksts ir pilns
		}
	}
	
	public void add (Ttype element) throws NullPointerException{
		if (element == null) {
			throw new NullPointerException("Elementa vertiba nevar but null");
		}
		
		if(!isFull()) {
			if(isEmpty()) { // tiks pirmais mezgls pieveinots, jo ir tukss saraksts
				MyNode newNode = new MyNode<Ttype>(element);
				lastNode = newNode;
				firstNode = newNode;
				counter++;
				
			} else {
				MyNode newNode = new MyNode<Ttype>(element);
				newNode.setPrevious(lastNode);
				lastNode.setNext(newNode);
				lastNode = newNode;
				counter++;
			}
		}
	}
	

	public void add(Ttype element, int position) throws Exception{
		if (element == null) {
			throw new NullPointerException("Nevar izpildit so funkciju!");
		}
		
		
		if (position == 1 ) { // grib ielikt 1. elementu
			MyNode newNode = new MyNode(element);
			newNode.setNext(firstNode);
			firstNode.setPrevious(newNode);
			firstNode = newNode;
			counter++;
			
		} else if (position == counter + 1) {
			add(element);
			
		} else if (position > 1 && position <= counter) {
			
			MyNode currentNode = firstNode;
			
			for (int i = 0; i < position - 1; i++) {
				
				currentNode = currentNode.getNext();
			}
			
			MyNode currentNodePrevious = currentNode.getPrevious();
			
			MyNode newNode = new MyNode(element);
			
			newNode.setNext(currentNode);
			currentNode.setPrevious(newNode);
			
			currentNodePrevious.setNext(newNode);
			newNode.setPrevious(currentNodePrevious);
			
			counter++;
		} else {
			throw new Exception("Šada pozīcija neder!");
		}
		

		
		
	}
		public void remove(int position) throws Exception{
		if (isEmpty()) {
			throw new Exception("List is empty and itis not possible to remove an element");
		}
		if (position <= 0 || position > counter) {
			throw new Exception("");
		}
		
		if (position == 1) {
			firstNode = firstNode.getNext();
			firstNode.setPrevious(null);
			System.gc();
			counter--;
		} else if (position == counter) {
			lastNode = lastNode.getPrevious();
			lastNode.setNext(null);
			System.gc();
			counter--;
		} else {
			MyNode currentNode = firstNode;
			for (int i = 0; i < position - i; i++ ) {
				currentNode = currentNode.getNext();
			}
			
			MyNode currentNodeNext = currentNode.getNext();
			MyNode currentNodePrevious = currentNode.getPrevious();
			currentNodeNext.setPrevious(currentNodePrevious);
			currentNodePrevious.setNext(currentNodeNext);
			currentNode = null;
			System.gc();
			counter--;
		}
	}
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("List is empty and it is not possible to print");
		}
		
		MyNode currentNode = firstNode;
		
		while (currentNode != null) {
			System.out.print(currentNode.getElement() + " ");
			currentNode = currentNode.getNext();
		}
		System.out.println();
	}

}
