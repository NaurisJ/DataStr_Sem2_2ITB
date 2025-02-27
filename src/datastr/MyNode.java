package datastr;

public class MyNode <Ttype> {
	private Ttype element;
	private MyNode next = null;
	private MyNode previous = null;
	
	
	
	public Ttype getElement() {
		return element;
	}
	public MyNode getNext() {
		return next;
	}
	public MyNode getPrevious() {
		return previous;
	}
	
	
	public void setElement(Ttype element) {
		if (element != null) {
			this.element = element;
		} else {
			element = (Ttype) new Object();
		}
	}
	
	public void setNext(MyNode inputNext) {
		next = inputNext;
	}
	
	public void setPrevious(MyNode inputPrevious) {
		previous = inputPrevious;
	}
	
	
	public MyNode(Ttype inputElement) {
		setElement(inputElement);
	}
	
	public String toString() {
		return element + " ";
	}
	
}
