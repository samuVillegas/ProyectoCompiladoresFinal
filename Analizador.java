/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author SistemaInvestigacion
 */
import java.util.*;

public class Analizador {

    private ArrayList<NoTerminal> pila;
    
    // metodos
    
    public Analizador(){
        pila = new ArrayList();
    }
    
    public int ultimo(){
        return pila.size()-1;
    }
    
    public NoTerminal getnode(int u){
        return (NoTerminal)pila.get(u);
    }
    
    public void removeNodo(int i){
        pila.remove(i);
    }
    
    public void adicionarNodo(NoTerminal nt){
        pila.add(nt);
        NoTerminal nt1=pila.get(pila.size() -1);
    }
    
    public void mostrarCadenaPila(){
        int tam=pila.size();
        NoTerminal nt;
        for (int i=0;i<tam;i++){
            nt=pila.get(i);
            System.out.println("Indice "+i+" nombre "+nt.getNombre()+" valor1 "+nt.getDirec()+
                    " valor2 " + nt.getValor());
        }
    }
    
   
}
