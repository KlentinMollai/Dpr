/**
 * MyQueue class tests generic queue  class GenClass, using Employee class  
 * @author Klentin Mollai
 * @version 10/26/2019
 */
public class MyQueue 
{
  public static void main(String[] args)
  {
   GenQueue<Employee> empList = new GenQueue<Employee>();   
   
  empList.enqueue(new Employee("John", "Dove", 10.25));
  empList.enqueue(new Employee("Gimmy", "Bass", 15.25));
  empList.enqueue(new Employee("Shawn", "Fin", 20.50)); 
  System.out.println(empList.toString());
  System.out.println("\nQueue has " + empList.size() + " elements\n");
  empList.enqueue(new Employee("Bucky", "Black", 21.50)); 
  empList.enqueue(new Employee("Ben", "Jamin", 22.50)); 
  System.out.println(empList.toString());
  System.out.println("\nQueue has " + empList.size() + " elements"); 
  System.out.println("\nQueue's head: " + empList.peek()); 
  System.out.println("\nEmptying the queue one element at time in FIFO order.\n");
    while (empList.hasItems()) {
      Employee emp = empList.dequeue();
      System.out.println(emp.toString());
    }
    System.out.println("\nQueue has " + empList.size() + " elements"); 
  }
}