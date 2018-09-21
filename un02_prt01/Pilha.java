package un02_prt01;

import java.util.LinkedList;
import java.util.Iterator;

public class Pilha<Type>{
    private LinkedList<Type> stack;

    public Pilha(){
        this.stack=new LinkedList<Type>();
    }

    public String toString(){
        return stack.toString();
    }

    public boolean estaVazia(){
        return stack.isEmpty();
    }

    public void empilha(Type x){
        this.stack.addFirst(x);
    }

    public Type desempilha(){
        return this.stack.removeFirst();
    }

    public Type topo(){
        return this.stack.getFirst();
    }
}
