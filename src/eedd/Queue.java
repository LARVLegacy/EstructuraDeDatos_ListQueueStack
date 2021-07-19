package eedd;

public class Queue {
    private Node first;
    private Node last;

    public Queue() {  
        //first = null;
        //last = null;
    }
    
    public boolean isEmpty()
    {
        return first == null && last == null;
    }
    
    public void Enqueue(Object data)  //guardar en la cola
    {
        if(isEmpty())
        {
            first = new Node(data);
            last = first;
        }
        else
        {
            Node n = new Node(data);
            last.setLink(n);
            last = n;
        }
    }
    
    public Object Dequeue()
    {
        Object data = null;
        if(!isEmpty())
        {
            data = first.getData();
            first = first.getLink();
            if(first==null)
                last = null;  //la lista queda vacia
        }
        return data;
    }
}
