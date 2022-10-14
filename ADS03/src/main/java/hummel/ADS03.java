package main.java.hummel;

import java.util.*;

public class ADS03 {
	public Node root;
	public ArrayList<Value> list = new ArrayList<>();
	public HashMap<Integer, Integer> rab = new HashMap<>();
	public HashMap<Integer, Integer> arb = new HashMap<>();
	public HashMap<Integer, Integer> abr = new HashMap<>();

	public ADS03() {
		root = null;
	}

	public void printLinked() {
		printLinked(root, "", "");
	}

	public void printLinked(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			print(root.left, s, "LL) ");
		}
		if (root.right != null) {
			print(root.right, s, "RL) ");
		}
	}

	public void print() {
		print(root, "", "");
	}

	public void print(Node root, String s, String isLeft) {
		System.out.println(s + isLeft + root.value);
		s += "   ";
		if (root.left != null) {
			print(root.left, s, "L) ");
		}
		if (root.right != null) {
			print(root.right, s, "R) ");
		}
	}

	public void printRAB() {
		printRAB(root);
	}

	public void printRAB(Node root) {
		System.out.print(root.value + " ");
		if (root.left != null) {
			rab.put(root.value, root.left.value);
			printRAB(root.left);
		}
		if (root.right != null) {
			rab.put(root.value, root.right.value);
			printRAB(root.right);
		}
	}

	public void printARB() {
		printARB(root);
	}

	public void printARB(Node root) {
		if (root.left != null) {
			arb.put(root.value, root.left.value);
			printARB(root.left);
		}
		System.out.print(root.value + " ");
		if (root.right != null) {
			arb.put(root.value, root.right.value);
			printARB(root.right);
		}
	}

	public void printABR() {
		printABR(root);
	}

	public void printABR(Node root) {
		if (root.left != null) {
			abr.put(root.value, root.left.value);
			printABR(root.left);
		}
		if (root.right != null) {
			abr.put(root.value, root.right.value);
			printABR(root.right);
		}
		System.out.print(root.value + " ");
	}

	public void push(int value) {
		root = push(root, value);
		Value val = new Value(value);
		list.add(val);
	}

	public void repush(int value) {
		root = push(root, value);
	}

	public void remove(int i) {
		this.root = null;
		for (Value val: list) {
			if (val.value == i) {
				list.remove(val);
				break;
			}
		}
		for (Value val: list) {
			this.repush(val.value);
		}
	}

	public void clear() {
	}

	public Node push(Node root, int key) {
		if (root == null) {
			return new Node(key);
		}
		if (key < root.value) {
			root.left = push(root.left, key);
		} else if (key > root.value) {
			root.right = push(root.right, key);
		}
		return root;
	}

	public static void main(String[] args) {
		ADS03 bst = new ADS03();
		bst.push(45);
		bst.push(10);
		bst.push(7);
		bst.push(12);
		bst.push(90);
		bst.push(50);
		bst.print();
		System.out.println();
		System.out.print("RAB: ");
		bst.printRAB();
		System.out.println();
		System.out.print("ARB: ");
		bst.printARB();
		System.out.println();
		System.out.print("ABR: ");
		bst.printABR();
		bst.remove(7);
		System.out.println();
		System.out.println();
		bst.print();
		System.out.println();
		System.out.print("RAB: ");
		bst.printRAB();
		System.out.println();
		System.out.print("ARB: ");
		bst.printARB();
		System.out.println();
		System.out.print("ABR: ");
		bst.printABR();
	}

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int data) {
			value = data;
			left = right = null;
		}
	}

	public static class Value {
		int value;

		public Value(int data) {
			value = data;
		}
	}
}