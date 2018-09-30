import java.util.LinkedList;

class Pilha<Type>{
    private final LinkedList<Type> stack;

    public Pilha(){
        this.stack=new LinkedList<>();
    }

    @Override
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
        if(estaVazia()){
            throw new Error("Empty stack");
        }
        else{
            return this.stack.removeFirst();
        }
    }
    
    public void clear() {stack.clear();}

    public Type topo(){
        if(estaVazia()){
            throw new Error("Empty stack");
        }
        else{
            return this.stack.getFirst();
        }
    }
    static void test1() {
        Pilha<Double> aPilha = new Pilha<>();
        aPilha.empilha(1.1);
        aPilha.empilha(2.1);
        aPilha.empilha(3.1);
        aPilha.empilha(4.1);
        aPilha.empilha(5.1);
        double valor = 0.0;
        valor = aPilha.topo();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.topo();
        System.out.println("topo pilha = " + valor);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor);
    }

    static void test2() {
        Pilha<Double> aPilha = new Pilha<Double>();
        System.out.println(aPilha);
        aPilha.empilha(1.1);
        System.out.println(aPilha);
        aPilha.empilha(2.1);
        System.out.println(aPilha);
        aPilha.empilha(3.1);
        System.out.println(aPilha);
        double valor = 0.0;
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        valor = aPilha.desempilha();
        System.out.println("topo pilha = " + valor );
        System.out.println(aPilha);
        }
        
    public static void main(String[] args) {
    
    }
}