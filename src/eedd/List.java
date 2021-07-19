package eedd;

public class List {
    private Node first;
    
    public List()
    {
       first=null;
    }

    public Node getFirst() {
        return first;
    }
    
    public boolean isEmpty()
    {
        return first==null;
//        if(first==null)
//            return true;
//        else
//            return false;
    }
    
    //AddFirst-> que el elemento que vamos a guardar
    //queda de primero en la lista
    public void AddFirst(Object data)
    {
        if(isEmpty())
        {
            first = new Node(data);
            //first = new Node(data, null);
        }
        else
        {
//            Node n = new Node(data);
//            n.setLink(first);
            Node n = new Node(data,first);
            first=n;                     
        }
    }
    
    @Override
    public String toString()
    {
        String text = "";
        Node aux = first;
        while(aux!=null)
        {
            text = text + aux.getData() + "\n";
            aux = aux.getLink();
        }
        return text;
    }
    
    //Devuelve el ultimo nodo de la lista
    public Node Last()
    {
        Node aux = first, pre= null;
        while(aux!=null)
        {
            pre = aux;
            aux=aux.getLink();
        }
        return pre;
    }
    
    public void AddLast(Object data)
    {
        if(isEmpty())
            first = new Node(data);
        else
        {
            Node n = new Node(data);
            Node last = Last();
            last.setLink(n);
        }
    }
    
    public Node Previous(Object data)
    {
        Node aux = first, pre = null;
        while(aux != null  && !aux.getData().equals(data))   //funciona cuando en el nodo hay un string
        {
            pre = aux;
            aux = aux.getLink();
        }
        if(aux==null)
            return null;
        else
            return pre;
    }
    
    public void Add(Object data, int pos)
    {
        if(pos == 1)
            AddFirst(data);
        else
        {
            if(pos == Size() + 1)
                AddLast(data);
            else
            {
                //recorremos la lista buscando la posicion
                Node aux = first;
                int cont = 1;
                while (cont != pos)   
                {
                    aux=aux.getLink();
                    cont++;
                }
                Node p = Previous(aux.getData());
                Node n = new Node(data, aux);
                p.setLink(n);
            }
        }
    }
    
    public int Size()
    {
        Node aux=first;
        int cont = 0;
        while(aux!=null)
        {
            cont++;
            aux=aux.getLink();
        }
        return cont;
    }
    
    public boolean RemoveFirst()
    {
        if(!isEmpty())
        {
            Node aux = first;
            first = first.getLink();  // con esta linea es suficiente
            aux=null;
            return true;
        }
        return false;
    }
  
    public boolean RemoveLast(){
        if(!isEmpty())
        {
            Node last = Last();  //devuelve el ultimo nodo de la lista
            Node pre = Previous(last.getData());  
                    //devuelve el que esta antes del ultimo
            if(pre!=null)
                pre.setLink(null);
            else
                first=null;
            
            last = null;  //no es necesario
            return true;
        }
        return false;       
    }
    
    public boolean Remove(int pos) //garantizando pos valida
    {
        if(!isEmpty())
        {
            if(pos==1)
                RemoveFirst();
            else
            {
                if(pos==Size())
                    RemoveLast();
                else
                {
                    Node aux = first;
                    int cont = 1;
                    while(cont<pos)
                    {
                        aux = aux.getLink();
                        cont++;
                    }                       
                    Node pre = Previous(aux.getData());  //buscamos el anterior
                    pre.setLink(aux.getLink());  //guarda en pre la dir de q le sigue al aux
                    aux=null;  //no es necesaria                    
                }
            }
            return true;
        }
        return false;
    }
    
    public double Average(){ //Calcular promedio
        double average = 0;
        Node aux = first;
        while(aux!=null){ //Recorrer mientras aux sea diferente de null
            average += ((Exam)aux.getData()).getExam(); 
            aux = aux.getLink();
        }
        return average/Size();
    }
}
