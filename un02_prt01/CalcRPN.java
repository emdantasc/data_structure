package un02_prt01;

import java.io.*;

class CalcRPN {
    // vari´aveis da instancia :
    // uma pilha para os c´alculos
    Pilha<Double> aPilha;

    // construtor
    CalcRPN() {
        aPilha=new Pilha<>();
    }

    // Adi¸c~ao de dois elementos do topo da pilha
    void mais() {
        Double A=aPilha.desempilha();
        Double B=aPilha.desempilha();
        aPilha.empilha(A+B);
    }

    // Subtra¸c~ao de dois elementos do topo da pilha
    void menos() {
        Double A=aPilha.desempilha();
        Double B=aPilha.desempilha();
        aPilha.empilha(B-A);
    }

    // Multiplica¸c~ao de dois elementos do topo da pilha
    void vezes() {
        Double A=aPilha.desempilha();
        Double B=aPilha.desempilha();
        aPilha.empilha(A*B);
    }

    // Divis~ao de dois elementos no topo da pilha
    void dividido() {
        Double A=aPilha.desempilha();
        Double B=aPilha.desempilha();
        aPilha.empilha(B/A);
    }

    // retorna o conteudo do topo da pilha
    Double resultado() {
        return aPilha.topo();
    }

    // interpretador de comandos
    void exec(String cmd) {
        if(("+".equals(cmd))||("-".equals(cmd))||("*".equals(cmd))||("*".equals(cmd))){
            if("+".equals(cmd)){this.mais();}
            else if ("-".equals(cmd)){this.menos();}
            else if ("*".equals(cmd)){this.vezes();}
            else{this.dividido();}
        }
        else{
            aPilha.empilha(Double.parseDouble(cmd));
        }
    }

    static void test() {
        CalcRPN calc = new CalcRPN();
        System.out.print("3 2 + = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 - = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.menos();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 * = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.vezes();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("3 2 / = ");
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(2.0);
        calc.dividido();
        System.out.println(calc.resultado());
        calc = new CalcRPN();
        System.out.print("1 2 + 3 4 - / 10 3 - * = ");
        calc.aPilha.empilha(1.0);
        calc.aPilha.empilha(2.0);
        calc.mais();
        calc.aPilha.empilha(3.0);
        calc.aPilha.empilha(4.0);
        calc.menos();
        calc.dividido();
        calc.aPilha.empilha(10.0);
        calc.aPilha.empilha(3.0);
        calc.menos();
        calc.vezes();
        System.out.println(calc.resultado());
    }
    
    static void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            for (String s : line.split(" ")) {
                calc.exec(s);
            }
            System.out.println("Pilha = " + calc.aPilha);
        }
        System.out.println("Ate logo");
    }
    
    public static void main(String[] args) throws IOException{
        interfaceUsuario();
    }
}