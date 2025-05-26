package Controller.Registration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.Passenger;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author wanch
 */
public class pRegistration extends Registration<Passenger>{
    
    LocalDate hoy = LocalDate.now();
    
    @Override
    public boolean Find(ArrayList<Passenger> passengers, long id){
        for (Passenger p : passengers) {
            if(p.getId() == id) return true;
        }
        return false;
    }
    
    @Override
    public boolean[] Verification(Passenger passenger, ArrayList<Passenger> passengers) {
        boolean[] check = new boolean[4];
        
        boolean find = Find(passengers, passenger.getId());
        
        if (passenger.getId() < 0 | (passenger.getId() / 10e14) > 1 | find) {      
            check[0] = true;
        }
        
        if (passenger.getCountryPhoneCode() < 0 | (passenger.getCountryPhoneCode() / 10e2) > 1){
            check[1] = true;
        }
        
        if (passenger.getPhone() < 0 | (passenger.getPhone() / 10e10) > 1){
            check[2] = true;
        }
        
        if(passenger.getBirthDate().isAfter(hoy)){
            check[3] = true;
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
                case 1 -> {
                    if(check[1]) e[1] = "Codigo Teléfonico no valido";
                }
                case 2 -> {
                    if(check[2]) e[2] = "Teléfono no valido";
                }
                case 3 -> {
                    if(check[3]) e[3] = "Fecha no valida";
                }
            }
        }
        return e;
    }

    @Override
    public boolean[] Verification(Passenger t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Find(ArrayList<Passenger> ts, String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
