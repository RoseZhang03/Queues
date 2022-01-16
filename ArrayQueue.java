//**********************************************************
// ArrayQueue.java
// An array-based implementation of the classic FIFO queue interface.
//**********************************************************
public class ArrayQueue implements QueueADT
{
private final int DEFAULT_SIZE = 5;
private Object[] elements;
private int numElements;
private int front, back;
//---------------------------------------------
// Constructor; creates array of default size.
//---------------------------------------------
public ArrayQueue()
{
  elements = new Object[DEFAULT_SIZE];
  numElements = 0;
  front = 0;
  back = 0;
}

public ArrayQueue(int n)
{
  elements = new Object[n];
  numElements = 0;
  front = 0;
  back = 0;
}
//---------------------------------------------
// Puts item on end of queue.
//---------------------------------------------
public void enqueue(Object item)
{
  if (!isFull())
  {
    elements[numElements] = item;
    back = numElements;
    numElements++;
  }
}
//---------------------------------------------
// Removes and returns object from front of queue.
//---------------------------------------------
public Object dequeue()
{
  Object a = elements[0];
  if (!isEmpty())
  {
    for (int i = 1; i < elements.length; i++)
    {
      elements[i-1] = elements[i];
    }
    if (isFull())
      elements[elements.length-1] = null;
    numElements--;
    back = numElements - 1;
  }
  return a;
}
//---------------------------------------------
// Returns true if queue is empty.
//---------------------------------------------
public boolean isEmpty()
{
  if (numElements == 0)
    return true;
  else
    return false;
}
//-----------------------------------------
// Returns true if queue is full.
//-----------------------------------------
public boolean isFull()
{
  if (numElements == elements.length)
    return true;
  else 
    return false;
    
}
//---------------------------------------------
// Returns the number of elements in the queue.
//---------------------------------------------
public int size()
{
  return numElements;
}
//---------------------------------------------
// Returns a string containing the elements of the queue
// from first to last
//---------------------------------------------
public String toString()
{
String result = "\n";
for (int i = front, count=0; count < numElements; i=(i+1)%elements.length,count++)
result = result + elements[i]+ "\n";
return result;
}
}