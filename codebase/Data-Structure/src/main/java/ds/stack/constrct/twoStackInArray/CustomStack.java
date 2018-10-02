package ds.stack.constrct.twoStackInArray;

public class CustomStack {

	int top1;
	int top2;
	int arr[];

	public CustomStack(int size) {
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}

	private int pop1() {
		if (top1 == -1) {
			System.out.println("underflow");
			System.exit(0);
		}

		return arr[top1--];

	}

	private int pop2() {
		if (top2 == arr.length) {
			System.out.println("underflow");
			System.exit(0);
		}

		return arr[top2++];

	}

	private void push2(int i) {

		if (top1 < top2 - 1) {
			arr[--top2] = i;
		} else {
			System.out.println("Overflow");
		}

	}

	private void push1(int i) {

		if (top1 < top2 - 1) {
			arr[++top1] = i;
		} else {
			System.out.println("Overflow");
		}

	}

	public static void main(String[] args) {
		CustomStack cs = new CustomStack(10);
		cs.push1(1);
		cs.push2(2);

		cs.push1(3);

		cs.push2(4);
		System.out.println(cs.pop1());
		System.out.println(cs.pop1());
		System.out.println(cs.pop2());
		System.out.println(cs.pop2());
		System.out.println(cs.pop2());
	}

}
