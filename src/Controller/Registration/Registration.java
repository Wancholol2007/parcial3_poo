package Controller.Registration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import java.util.ArrayList;

/**
 *
 * @author HLLINAS
 * @param <T>
 */
public abstract class Registration<T> {
    
    abstract public boolean Find(ArrayList<T> ts, long id);
    
    abstract public boolean Find(ArrayList<T> ts, String id);
    
    abstract public boolean[] Verification(T t);
    
    abstract public boolean[] Verification(T t, ArrayList<T> ts);
    
    public boolean Check(boolean[] check){
        for (int i = 0; i < check.length; i++) {
            if(check[i]) return true;
        }
        return false;
    }
    
    abstract public String[] error(boolean[] check);
}
