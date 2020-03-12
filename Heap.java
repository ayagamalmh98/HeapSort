package eg.edu.alexu.csd.filestructure.sort;

import eg.edu.alexu.csd.filestructure.sort.INode;

import java.util.ArrayList;
import java.util.Collection;

public class Heap<T extends Comparable<T>> implements IHeap<T> {
	private int Length = 0;
	private ArrayList<INode<T>> elements = new ArrayList<>();

	@SuppressWarnings("hiding")
	private class Node<T extends Comparable<T>> implements INode<T> {
		private int index;
		private int size;
		private T value;

		public Node(int index) {
			this.index = index;
		}

		@SuppressWarnings("unchecked")
		@Override
		public INode<T> getLeftChild() {
			if (2 * index >= size) {
				return null;
			}
			return (INode<T>) elements.get(2 * index);
		}

		@SuppressWarnings("unchecked")
		@Override
		public INode<T> getRightChild() {
			if (2 * index + 1 >= size) {
				return null;
			}
			return (INode<T>) elements.get(2 * index + 1);
		}

		@SuppressWarnings("unchecked")
		@Override
		public INode<T> getParent() {
			if (index / 2 >= size) {
				return null;
			}
			return (INode<T>) elements.get(index / 2);
		}

		@Override
		public T getValue() {
			return value;
		}

		@Override
		public void setValue(T value) {
			this.value = value;

		}
	}

	public INode<T> getRoot() {
		if (elements.size() == 0) {
			return null;
		}
		return elements.get(1);
	}

	public int size() {
		return Length;
	}

	private void swap(final INode<T> node1, final INode<T> node2) {
		T temp = (T) node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(temp);
	}

	public void heapify(INode<T> node) {

		if (Length == 0) {
			return;
		}

		INode<T> left = node.getLeftChild();
		INode<T> right = node.getRightChild();
		INode<T> bigger = node.getRightChild();

		if (left != null && left.getValue().compareTo(node.getValue()) > 0) {
			bigger = left;
		} else {
			bigger = node;
		}
		if (right != null && right.getValue().compareTo(bigger.getValue()) > 0) {
			bigger = right;
		}
		if (bigger != node) {
			swap(node, bigger);
			heapify(bigger);
		}
	}

	public T extract() {
		T max = elements.get(1).getValue();
		elements.get(1).setValue(elements.get(Length).getValue());
		elements.remove(Length);
		Length--;
		if (Length != 0) {
			heapify(elements.get(1));
		}
		return max;
	}

	public void insert(T element) {
		if (Length == 0) {
			elements.add(null);
		}

		INode<T> node = new Node<T>(Length + 1);
		node.setValue(element);
		elements.add(Length + 1, node);
		Length++;
		heapifyUp(node);
	}

	private void heapifyUp(INode<T> node) {
		while (node != getRoot() && node.getParent() != null
				&& node.getValue().compareTo(node.getParent().getValue()) > 0) {
			swap(node, node.getParent());
			node = node.getParent();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void build(Collection unordered) {
		elements = (ArrayList<INode<T>>) unordered;
		for (int i = elements.size(); i > 0; i--) {
			heapify(elements.get(i));
		}

	}

}
