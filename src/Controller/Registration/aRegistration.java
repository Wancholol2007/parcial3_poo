/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Registration;

import Model.Plane;
import java.util.ArrayList;

/**
 *
 * @author HLLINAS
 */
public class aRegistration extends Registration<Plane>{
    
    @Override
    public boolean Find(ArrayList<Plane> planes, String id) {
       for (Plane p : planes) {
            if(p.getId().equals(id)) return true;
        }
        return false;
    }
    
    @Override
    public boolean[] Verification(Plane plane, ArrayList<Plane> planes) {
        boolean[] check = new boolean[1];
        
        boolean find = Find(planes, plane.getId());
        
        if (!plane.getId().matches("[A-Z]{2}[0-9]{5}") | find) {      
            check[0] = true;
        }
        
        return check;
    }
    
    @Override
    public String[] error(boolean[] check) {
        String[] e = new String[check.length];
        
        for (int i = 0; i < check.length; i++) {
            switch (i){
                case 0 -> {
                    if(check[0]) e[0] = "Id no valido";
                }
            }
        }
        return e;
    }

    @Override
    public boolean[] Verification(Plane t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    } 

    @Override
    public boolean Find(ArrayList ts, long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
