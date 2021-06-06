import java.util.ArrayList;
import java.util.Scanner;

public class AnalizadorRecursivo{

    static Lexico lexico = new Lexico();
    static String cadena;
    static String cad1 = "0123456789.";
    static char INP;
    static int index = 0;

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese la cadena");
        cadena = in.nextLine();
        cadena = cadena+="¬";
        analisisLexico();
        INP = lexico.darElemento(index).darTipo();
        procesoS();
        if(INP!='¬') rechace();
        else acepte();
    }

    static void procesoS(){
        switch(INP){
            case 'i': case '(': 
                elo();
                break;
            default: rechace();
            break;
        }
    }

    static void elo(){
        switch(INP){
            case 'i': case '(': 
                el2();
                elo_l();
                break;
            default: rechace();
            break;
        }
    }

    static void elo_l(){
        switch(INP){
            case '|':
              avance();
              el2();
              elo_l();
              break;
            case ')': case '¬':
                break;
            default: rechace();
            break;
        }
    }

    static void el2(){
        switch(INP){
            case 'i': case '(':
                er();
                el2_l();
                break;
            default: rechace();
            break;
        }
    }

    static void el2_l(){
        switch(INP){
            case '&':
                avance();
                er();
                el2_l();
                break;
            case '|': case '¬': case ')':
                break;
            default:rechace();
            break;
        }
    }

    static void er(){
        switch(INP){
            case 'i': case '(':
                e();
                er_l();
                break;
            default:rechace();
            break;
        }
    }

    static void er_l(){
        switch(INP){
            case '<': case '>': case '=': case '!':
                or();
                e();
                break;
            case '¬': case ')': case '&': case '|':
                break;
            default:rechace();
            break;
        }
    }

    static void or(){
        switch(INP){
            case '<':
                avance();
                me();
                break;
            case '>':
                avance();
                ma();
                break;
            case '=':
                avance();
                ig();
                break;
            case '!':
                avance();
                di();
                break;
            default:rechace();
            break;
        }
    }

    static void me(){
        switch(INP){
            case '=':
                avance();
                break;
            case 'i': case '(':
                break;
            default:rechace();
            break;
        }
    }

    static void ma(){
        switch(INP){
            case '=':
                avance();
                break;
            case 'i': case '(':
                break;
            default:rechace();
            break;
        }
    }

    static void ig(){
        switch(INP){
            case '=':
                avance();
                break;
            default:rechace();
            break;
        }
    }
    
    static void di(){
        switch(INP){
            case '=':
                avance();
                break;
            default:rechace();
            break;
        }
    }

    static void e(){
        switch(INP){
            case 'i':case '(':
                t();
                e_l();
                break;
            default:rechace();
            break;
        }
    }

    static void e_l(){
        switch(INP){
            case '+':
                avance();
                t();
                e_l();
                break;
            case '-':
                avance();
                t();
                e_l();
                break;
            case '¬': case ')': case '&': case '|':case '<':case '>':case '=':case '!':
                break;
            default:rechace();
            break;
        }
    }

    static void t(){
        switch(INP){
            case 'i':case '(':
                p();
                t_l();
                break;
            default:rechace();
            break;
        }
    }

    static void t_l(){
        switch(INP){
            case '*':
                avance();
                p();
                t_l();
                break;
            case '/':
                avance();
                p();
                t_l();
                break;
            case '¬': case ')': case '&': case '|':case '<':case '>':case '=':case '!':case '+':case '-':
                break;
            default:rechace();
            break;
        }
    }

    static void p(){
        switch(INP){
            case 'i':case '(':
                f();
                p_l();
                break;
            default:rechace();
            break;
        }
    }

    static void p_l(){
        switch(INP){
            case '^':
                avance();
                f();
                p_l();
                break;
            case '¬': case ')': case '&': case '|':case '<':case '>':case '=':case '!':case '+':case '-':case '*':case '/':
                break;
            default:rechace();
            break;
        }
    }

    
    static void f(){
        switch(INP){
            case '(':
                avance();
                elo();
                avance();
                if(INP==')') rechace();
                break;
            case 'i':
                avance();
                break;
            default:rechace();
            break;
        }
    }

    static void avance(){
        index+=1;
        INP = lexico.darElemento(index).darTipo();
    }

    static void rechace(){
        System.out.println("La cadena ingresada no es valida:");
        System.out.println("Error en:"+INP);
    }

    static void acepte(){
        System.out.println("Cadena aceptada");
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