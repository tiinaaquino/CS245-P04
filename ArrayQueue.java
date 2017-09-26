
public class ArrayQueue implements Queue {

	private int head;
	private int tail;
	private Object[] arr;
	
	public ArrayQueue() {
		head = 0;
		tail = 0;
		arr = new Object[800];
	}
	
	@Override
	public Object dequeue() {
		if (empty()) 
			return null;	
		
		Object item = arr[head];
		head++;
		
		if (head >= arr.length) 
			head = 0;
		return item;
	}

	@Override
	public void enqueue(Object item) {
		if (full()) 
			growQueue();
		
		arr[tail] = item;
		tail++;
		if (tail >= arr.length) 
			tail = 0;
	}

	@Override
	public boolean empty() {
		if (head == tail) 
			return true;
		return false;
	}
	
	private void growQueue() {
		if (arr.length == 0) {
			Object[] new_arr = new Object[1];
			System.arraycopy(arr, 0, new_arr, 0, arr.length);
			arr = new_arr;	
		}
		Object[] new_arr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;		
	}
	
	public boolean full() {
		if ((tail + 1) % arr.length == head) 
			return true;
		return false;
		
	}

}
