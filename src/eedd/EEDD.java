
package eedd;

import javax.swing.JOptionPane;


public class EEDD {

  
    public static void main(String[] args) {
        
        Stack exams = new Stack();
        
        Queue group1 = new Queue();
        Queue group2 = new Queue();
        Queue group3 = new Queue();
        List qualify = new List();
        String name, opt;
        double exam;
        int group;
        Exam e = null;
        String menu[]={"Add", "Qualify", "Register", "Print exams", "Print qualify", "Average", "Exit"};
        do{
            opt=(String) JOptionPane.showInputDialog(null, "Selected option", "Main menu", 1, null,
                    menu, menu[0]);
            switch(opt){
                case "Add":
                    name = JOptionPane.showInputDialog("Enter name");
                    boolean sw = true;
                    do{
                        if(sw){
                        group=Integer.parseInt(JOptionPane.showInputDialog("Enter group"));
                        sw = false;
                        }
                        else
                            group=Integer.parseInt(JOptionPane.showInputDialog(null, "Incorred code. " +
                                    " Enter group ", "", 0));
                    }while(group<1 || group>3); //Controla el ingreso entre 1 y 3
                    e = new Exam(name, group);
                    exams.Push(e);
                    JOptionPane.showMessageDialog(null, "Recived exam");
                    break;
                    
                case "Qualify":
                    if(!exams.isEmpty()){ //validamos que exitan examenes
                        e = (Exam)exams.Pop();
                        e.setExam(Math.random()*5); //la nota del examen la cambiamos por un número aleatorio entre 1 y 5
                        if(e.getGroup()==1)
                            group1.Enqueue(e);
                        else{
                            if(e.getGroup()==2)
                                group2.Enqueue(e);
                            else
                                group3.Enqueue(e);
                        }
                        JOptionPane.showMessageDialog(null,"Your exams is:" + e.toString());
                    }
                    else
                        JOptionPane.showMessageDialog(null,"The stack haven't exams");
                    break;
                    
                case "Registrer":
                    //Se sacan todos los de una cola y se pasan a la lista
                    boolean sww = true;
                    do{
                        if(sww){
                        group=Integer.parseInt(JOptionPane.showInputDialog("Enter group"));
                        sw = false;
                        }
                        else
                            group=Integer.parseInt(JOptionPane.showInputDialog(null, "Incorred code. " +
                                    " Enter group ", "", 0));
                    }while(group<1 || group>3); //Controla el ingreso entre 1 y 3
                    //while(group!=1 && group!= && group!=3);  ----> tambien se puede hacer de esta forma
                    if(group==1)
                        Add(qualify, group1);
                    else{
                        if(group==2)
                            Add(qualify, group2);
                        else
                            Add(qualify, group3);
                    }
                    
                    JOptionPane.showMessageDialog(null, "Registed exam");
                    break;
                
                case "Print exams":
                    JOptionPane.showMessageDialog(null,Print(group1), "Group 1", 1);
                    JOptionPane.showMessageDialog(null,Print(group2), "Group 2", 1);
                    JOptionPane.showMessageDialog(null,Print(group3), "Group 3", 1);
                    break;
            
                case "Print qualify":
                     JOptionPane.showMessageDialog(null,qualify.toString(), "List", 1);
                     break;
                     
                case "Average":
                    JOptionPane.showMessageDialog(null, "The average is: " + qualify.Average());
                    break;
            }
            
        }while(!opt.equals("Exit"));
        
    }
    
    public static void Add(List list, Queue q){
        while(!q.isEmpty())
            list.AddLast(q.Dequeue());
    }
    
    public static String Print(Queue q){
        String text = "";
        Queue aux = new Queue();
        Exam ex;
        while(!q.isEmpty()){
            ex=(Exam)q.Dequeue();
            text = text+ex.toString()+"\n";
            aux.Enqueue(ex);
        }
        while(!aux.isEmpty())
            q.Enqueue(aux.Dequeue());
        
        return text;
    }
    
}
