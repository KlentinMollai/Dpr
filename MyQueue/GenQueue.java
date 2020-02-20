/**
 * The GenQueue class represents a first-in-first-out (FIFO) queue of
 * generic items that uses implementation of a singly-linked list. 
 * It supports the usual enqueue and dequeue operations, 
 * along with methods for peeking at the first item, testing if the
 * queue is empty and getting the number of items in the queue
 */
import java.util.LinkedList;
import java.util.NoSuchElementException;


class GenQueue<E> 
{
	
  private LinkedList<E> list = new LinkedList<E>();


  /**
   * Add the item to the queue.
   *
   * @param item the item to enqueue
   */
  public void enqueue(E item) 
  {
    list.addLast(item);
  }
  /**
   * Removes and returns the item on this queue that was least recently added.
   *
   * @return the item on this queue that was least recently added
   */
  public E dequeue() 
  {
    return list.poll();
  }
  /**
   * Returns the item least recently added to this queue.
   *
   * @return the item least recently added to this queue
   * @throws NoSuchElementException if this queue is empty
   */  
  public E peek() 
  {
      if (list.peek() == null) throw new NoSuchElementException("Queue underflow");
      return list.getFirst();
  }
  
  /**
   * Returns true if this queue is empty.
   */

  public boolean hasItems() 
  {
    return !list.isEmpty();
  }

  /**
   * Returns the number of items in this queue.
   *
   * @return the number of items in this queue
   */
  public int size() 
  {
    return list.size();
  }
@Override
  public String toString()
  {
	  
     StringBuilder s = new StringBuilder();
     for (E item : list)     	
         s.append(item);
         s.append(' ');       
      return s.toString();   
    	 
  }
  
}
