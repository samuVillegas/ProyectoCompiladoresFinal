import java.util.ArrayList;
import java.util.Scanner;

public class AnalizadorPila{

    static Lexico lexico = new Lexico();
    static String cadena;
    static String cad1 = "0123456789.";
    static Analizador analizador = new Analizador();
    static char sim = ' ';
    static int index = 0;

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cadena a reconocer");
        cadena = in.nextLine();
        cadena = cadena+="¬";
        analisisLexico();

        analizador.adicionarNodo(new NoTerminal("v",0,0));
        analizador.adicionarNodo(new NoTerminal("s",0,0));

        NoTerminal nt = null;
        sim = lexico.darElemento(index).darTipo();
        
        do{

            switch(sim){
                case 'i':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "s": proceso1();
                        break;
                        case "elo": proceso2();
                        break;
                        case "el2": proceso5();
                        break;
                        case "er": proceso8();
                        break;
                        case "e": proceso21();
                        break;
                        case "me": proceso13();
                        break;
                        case "ma": proceso16();
                        break;
                        case "t": proceso25();
                        break;
                        case "p": proceso29();
                        break;
                        case "f": proceso33();
                        break;
                        default: rechace();
                        break;
                    }   

                break;
                case '+':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "el": proceso22();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '-':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "el": proceso23();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '*':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "tl": proceso26();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '/':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "tl": proceso27();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '^':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "pl": proceso30();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '<':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "erl": proceso9();
                        break;
                        case "or": proceso11();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;           
                    }
                break;
                case '>':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "erl": proceso9();
                        break;
                        case "or": proceso14();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break;           
                    }
                break;
                case '=':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "erl": proceso9();
                        break;
                        case "or": proceso17();
                        break;
                        case "me": proceso12();
                        break;
                        case "ma": proceso15();
                        break;
                        case "ig": proceso18();
                        break;
                        case "di": proceso20();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;
                        default: rechace();
                        break; 
                    }
                break;
                case '!':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "erl": proceso9();
                        break;
                        case "or": proceso19();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;     
                        default: rechace();
                        break;  
                    }
                break;
                case '|':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "elol": proceso3();
                        break;
                        case "el2l": proceso7();
                        break;
                        case "erl": proceso10();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;     
                        default: rechace();
                        break;   
                    }
                break;
                case '&':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "el2l": proceso6();
                        break;
                        case "erl": proceso10();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31(); 
                        break;     
                        default: rechace();
                        break;   
                    }
                break;
                case '(':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "s": proceso1();
                        break;
                        case "elo": proceso2();
                        break; 
                        case "el2": proceso5();
                        break;
                        case "er": proceso8();
                        break;
                        case "e": proceso21();
                        break;
                        case "me": proceso13();
                        break;
                        case "ma": proceso16();
                        break;
                        case "t": proceso25();
                        break;
                        case "p": proceso29();
                        break;
                        case "f": proceso32();
                        break;
                        default: rechace();
                        break;  
                    }
                break;
                case ')':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "elol": proceso4();
                        break;
                        case "el2l": proceso7();
                        break;
                        case "erl": proceso10();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;     
                        case ")": proceso12();
                        break;
                        default: rechace();
                        break;
                    }
                break;
                case '¬':
                    nt = analizador.getnode(analizador.ultimo());
                    switch(nt.getNombre()){
                        case "elol": proceso4();
                        break;
                        case "el2l": proceso7();
                        break;
                        case "erl": proceso10();
                        break;
                        case "el": proceso24();
                        break;
                        case "tl": proceso28();
                        break;
                        case "pl": proceso31();
                        break;     
                        default: rechace();
                        break; 
                    }
                break;
            }
        
            nt=analizador.getnode(analizador.ultimo());
            System.out.println(index);
            System.out.println("***********************");
            analizador.mostrarCadenaPila();
        }while(!nt.getNombre().equalsIgnoreCase("v"));

        if (nt.getNombre().equalsIgnoreCase("v"))
            System.out.println("Se acepta la secuencia");
        else
            System.out.println("Se rechaza la secuencia");


    }

    static void proceso1(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("elo",0,0));
    }
    static void proceso2(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("elol",0,0));
        analizador.adicionarNodo(new NoTerminal("el2",0,0));
    }

    static void proceso3(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("elol",0,0));
        analizador.adicionarNodo(new NoTerminal("el2",0,0));
        avance();
    }

    static void proceso4(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso5(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("el2l",0,0));
        analizador.adicionarNodo(new NoTerminal("er",0,0));
    }

    static void proceso6(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("el2l",0,0));
        analizador.adicionarNodo(new NoTerminal("er",0,0));
        avance();
    }
    
    static void proceso7(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso8(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("erl",0,0));
        analizador.adicionarNodo(new NoTerminal("e",0,0));
    }

    static void proceso9(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("e",0,0));
        analizador.adicionarNodo(new NoTerminal("or",0,0));
    }

    static void proceso10(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso11(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("me",0,0));
        avance();
    }

    static void proceso12(){
        analizador.removeNodo(analizador.ultimo());
        avance();
    }

    static void proceso13(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso14(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("ma",0,0));
        avance();
    }

    static void proceso15(){
        analizador.removeNodo(analizador.ultimo());
        avance();
    }

    static void proceso16(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso17(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("ig",0,0));
        avance();
    }

    static void proceso18(){
        analizador.removeNodo(analizador.ultimo());
        avance();
    }

    static void proceso19(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("di",0,0));
        avance();
    }

    static void proceso20(){
        analizador.removeNodo(analizador.ultimo());
        avance();
    }

    static void proceso21(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("el",0,0));
        analizador.adicionarNodo(new NoTerminal("t",0,0));
    }

    static void proceso22(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("el",0,0));
        analizador.adicionarNodo(new NoTerminal("t",0,0));
        avance();
    }

    static void proceso23(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("el",0,0));
        analizador.adicionarNodo(new NoTerminal("t",0,0));
        avance();
    }

    static void proceso24(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso25(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("tl",0,0));
        analizador.adicionarNodo(new NoTerminal("p",0,0));
    }

    static void proceso26(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("tl",0,0));
        analizador.adicionarNodo(new NoTerminal("p",0,0));
        avance();
    }

    static void proceso27(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("tl",0,0));
        analizador.adicionarNodo(new NoTerminal("p",0,0));
        avance();
    }

    static void proceso28(){
        analizador.removeNodo(analizador.ultimo());
    }

    static void proceso29(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("pl",0,0));
        analizador.adicionarNodo(new NoTerminal("f",0,0));
    }

    static void proceso30(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal("pl",0,0));
        analizador.adicionarNodo(new NoTerminal("f",0,0));
        avance();
    }

    static void proceso31(){
        analizador.removeNodo(analizador.ultimo());
    }
    
    static void proceso32(){
        analizador.removeNodo(analizador.ultimo());
        analizador.adicionarNodo(new NoTerminal(")",0,0));
        analizador.adicionarNodo(new NoTerminal("elo",0,0));
        avance();
    }

    static void proceso33(){
        analizador.removeNodo(analizador.ultimo());
        avance();   
    }


    static void rechace(){
        System.out.println("Cadena rechazada: Error sintáctico");
        System.exit(0);
    }

    static void avance(){
        index++;
        sim = lexico.darElemento(index).darTipo();
    }



    public static void analisisLexico(){
        // Este analizador es sencillo determina solo constantes enteras y reales positivas
        // Trabaja los diferentes elementos en un ArrayList que trabaja con la clase Clexico
        // la cual define el ArrayList con la clase CElemento
        // Almacen los valores para poder hallar los resultados
        
        Elemento ele1; 
        
        int i=0;
        int ind=0;
        char tip=0;
        char sim1=cadena.charAt(i);
        double val=0;
        
        while (sim1!='¬'){
            // determina si sim1 esta en la cadena de digitos cad1 que es global
            if (cad1.indexOf(sim1)!=-1){
                String num="";
                while(cad1.indexOf(sim1)!=-1){
                    num=num+sim1;
                    i++;
                    sim1=cadena.charAt(i);
        
                }
                // en el String num se almacena el entero y se lo almacena en val como doble
                // DeterminarNumero(num);
                if (determinarNumero(num)){
                    val=Double.parseDouble(num);
                    tip='i';
                
                    // se tipifica el valor como i
                }
                else{
                    System.out.println("Se rechaza la secuencia");
                    System.exit(0);
                }
        
            }
            else {
               // si el simbolo de entrada no esta en cad1 lo tipifica como tal ej
               // +,-,* (,) etc.
                
               tip=(char)sim1;
               i++;
               sim1=cadena.charAt(i);
              
               val=0;
              
            }
        
            // con los elementos establecidos anteriormente se crea el elemento y se lo
            // adicina a lex1 que es el objeto de la clase Clexico
            if(tip != ' '){
                ele1=new Elemento(tip,val,ind);
                lexico.adicionarElemento(ele1);
            }
            ind=ind+1;
            //System.out.print("indice ="+ind);
               
        }
        ele1=new Elemento('¬',0,ind);
        lexico.adicionarElemento(ele1);
        lexico.mostrarLexico();
        System.out.println(" cadena"+lexico.cadenaLexico());
    }
    
    public static boolean determinarNumero(String numero){
     // Este método recibe un número en string y determina mediante un autómata finito
     // si está o no correcto. El string es una cadena de dígitos y el punto.
     // Retorna un valor booleano.
     
        int estado=1,i=0;
        char simbolo;
        boolean b=true;
        while (i<numero.length()&&b) {
            simbolo = numero.charAt(i);
            switch (simbolo) {
                case '0':case '1':case '2':case '3':case '4':case '5':case '6':  
                case '7':case '8':case '9':    
                    switch (estado) {
                        case 1:
                           estado=2;
                           i++;
        
                           break;
                        case 2:
                           estado=2;
                           i++;
        
                           break;
                        case 3:
                           estado=4;
                           i++;
        
                           break;
                        case 4:
                            estado=4;
                           i++;
        
                           break;
                    
                    }
                    break;
                case '.':    
                    switch (estado) {
                        case 1:case 3: case 4:
                           b=false;
                           break;
                        case 2:
                           estado=3;
                           i++;
                           break;
                    }
                    break;
                default: b=false;
            }
    }
        return b;
    }
}