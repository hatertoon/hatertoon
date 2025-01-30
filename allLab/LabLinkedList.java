package test;

class Link {
	  public int value; // integer data
	  public Link next; // reference to next link
	}

	class LinkList {
	  private Link first; // ref to first Link on list

	  public LinkList() {
	    first = null;
	  }

	  public static Link getnode(int value) {
	    Link n = new Link();
	    n.value = value;
	    n.next = null;
	    return n;
	  }

	  public void insertFirst(int value) {
	    Link newLink = getnode(value);
	    newLink.next = first; // it points to old first link
	    first = newLink; // now first points to this
	  }

	  public boolean islempty() {
	    return (first == null);
	  }

	  public void printlst() {
	    Link ptr = first;
	    while (ptr != null) {
	      System.out.print(ptr.value + " ");
	      ptr = ptr.next; // next node
	    }
	  }

	  // Method to find the max value in the linked list
	  public int findMax() {
	    if (islempty()) {
	      return -1; // Linked list is empty
	    }
	    Link current = first;
	    int max = current.value;
	    while (current != null) {
	      if (current.value > max) {
	        max = current.value;
	      }
	      current = current.next;
	    }
	    return max;
	  }

	  // Method to remove the max value from the linked list
	  public Integer removeMax() {
	    if (islempty()) {
	      System.out.println("Cannot find max. LinkedList is empty.");
	      return null;
	    }
	    Link current = first;
	    Link previous = null;
	    Link maxNode = first;
	    Link maxPrev = null;

	    // Find the max node
	    while (current != null) {
	      if (current.value > maxNode.value) {
	        maxNode = current;
	        maxPrev = previous;
	      }
	      previous = current;
	      current = current.next;
	    }

	    // If maxNode is the first node
	    if (maxPrev == null) {
	      first = first.next;
	    } else {
	      maxPrev.next = maxNode.next;
	    }

	    System.out.println(maxNode.value + " has been removed.");
	    return maxNode.value;
	  }
	}

	public class LabLinkedList {
	  public static void main(String[] args) {
	    LinkList numlist = new LinkList();

	    numlist.insertFirst(28);
	    numlist.insertFirst(96);
	    numlist.insertFirst(75);
	    numlist.insertFirst(162);

	    numlist.printlst();
	    System.out.println();

	    System.out.println("Max Value: " + numlist.findMax());

	    numlist.removeMax();
	    numlist.printlst();
	  }
	}
