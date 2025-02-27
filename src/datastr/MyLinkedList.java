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

}
