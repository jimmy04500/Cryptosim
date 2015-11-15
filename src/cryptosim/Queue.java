package cryptosim;

public class Queue<E> {
	private int len;
	private Element head, tail;
	
	private class Element {
		private E item;
		private Element next;
		
		public Element(E item) {
			this.item = item;
			next = null;
		}
	}
	
	public Queue() {
		head = null;
		tail = null;
		len = 0;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int size() {
		return len;
	}
	
	public E peek() {
		if (isEmpty()) return null;
		return head.item;
	}
	
	public void enqueue(E e) {
		Element elem = new Element(e);
		if (isEmpty()) {
			head = elem;
			tail = elem;
		} else {
			tail.next = elem;
			tail = elem;
		}
		len++;
	}
	
	public E dequeue() {
		if (isEmpty()) return null;
		E elem = head.item;
		head = head.next;
		len--;
		if (isEmpty()) tail = null;
		return elem;
	}
	
	public E get(int index) {
		return getHelper(head, index);
	}
	
	private E getHelper(Element elem, int index) {
		if (index == 0) return elem.item;
		return getHelper(elem.next, index - 1);
	}
}
