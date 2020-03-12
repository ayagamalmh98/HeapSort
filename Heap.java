import java.util.Collection;

import eg.edu.alexu.csd.filestructure.sort.INode;

public class Heap implements IHeap {
	private int lenght;
	private INode[] elements;
	private final int maxLenght = 1000000;

	public Heap() {
		elements = new INode[maxLenght];
		lenght = 0;

	}

	@Override
	public INode getRoot() {

		return elements[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return lenght;
	}
	private void swap(final INode node1, final INode node2) {
		Comparable temp = node1.getValue();
		node1.setValue(node2.getValue());
		node2.setValue(temp);
	}

	
	@Override
	public void heapify(INode node) {
		if (node == null || node.getLeftChild() == null) {
			return;
		}
		while (node.getLeftChild()!=null) {
			int flag=0;
			if (node.getRightChild()!=null) {
				if ( node.getLeftChild().getValue().compareTo(node.getValue())>0 &&
						node.getLeftChild().getValue().compareTo(node.getRightChild().getValue())>0)  {
					swap( node , node.getLeftChild());
					heapify(node.getLeftChild());
				}
				if ( node.getRightChild().getValue().compareTo(node.getValue())>0 &&
						node.getLeftChild().getValue().compareTo(node.getRightChild().getValue())<0) { 
					swap(node,node.getRightChild());
					heapify(node.getRightChild());

				}
						
			
			}
			else if (node.getLeftChild().getValue().compareTo(node.getValue())>0) {
            	swap( node , node.getLeftChild());
				heapify(node.getLeftChild());

			}
				
		
			
						
				
					
			
		}

	}

	@Override
	public Comparable extract() {
		if (lenght == 0) {
			return null;
		}
		Comparable max=(Comparable) elements[1];
		elements[1]=elements[lenght];
		elements[lenght]=null;
		heapify(elements[1]);
		
		return max;
	}

	@Override
	public void insert(Comparable element) {
		if (element==null) return;
		
		 elements[++lenght].setValue(element);
		 heapifyUp(elements[lenght]);
		
		

	}
	private void heapifyUp (INode node) {
		if (node.getParent()==null) return;
		if (node.getValue().compareTo(node.getParent().getValue())>0) {
			swap(node,node.getParent());
			heapify(node.getParent());
		}
		else return;
		
	}
	@Override
	public void build(Collection unordered) {
		
				Comparable[] set=(Comparable[]) unordered.toArray(new Comparable[unordered.size()] );
				for (int i=0;i<set.length;i++) {
					elements[++lenght].setValue(set[i]);
					heapifyUp(elements[lenght]);
					
					
				}
	

	}

}
