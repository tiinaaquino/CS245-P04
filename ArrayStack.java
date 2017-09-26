
public class ArrayStack implements Stack {

	private int top;
	private Object[] arr;
	
	public ArrayStack() {
		top = 0;
		arr = new Object[800];
	}
	
	@Override
	public void push(Object item) {
		if (top == arr.length)
			growStack();
		Assert.notFalse(top < arr.length);
		arr[top++] = item;	
	}

	@Override
	public Object pop() {
		if (!empty())
			return arr[--top];
		return null;
	}

	@Override
	public Object peek() {
		if (!empty())
			return arr[top-1];
		return null;
	}

	@Override
	public boolean empty() {
		if (top == 0)
			return true;
		return false;
	}
	
	private void growStack() {
		Object[] new_arr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, new_arr, 0, arr.length);
		arr = new_arr;
	}

}
