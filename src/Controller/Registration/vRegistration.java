/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Registration;

import Model.Flight;
import Model.Location;
import Model.Plane;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author wanch
 */
public class vRegistration extends Registration<Flight> {
    LocalDateTime hoy = LocalDateTime.now();
    
    @Override
    public boolean Find(ArrayList<Flight> ts, long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Find(ArrayList<Flight> flights, String id) {
        for (Flight p : flights) {
            if (p.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean[] Verification(Flight t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean[] Verification(Flight flight, ArrayList<Flight> flights, ArrayList<Plane> planes) {
        boolean[] check = new boolean[8];

        boolean find = Find(flights, flight.getId());

        if (!flight.getId().matches("[A-Z]{3}[0-9]{3}") | find) {
            check[0] = true;
        }

        if (flight.getPlane() == null) {
            check[1] = true;
        }

        if (flight.getDepartureDate() == null | flight.getArrivalLocation() == null) {
            check[2] = true;
        } else {
            if (flight.getDepartureLocation().equals(flight.getArrivalLocation())) {
                check[3] = true;
            }
        }
        
        if(flight.getScaleLocation() == null){
            if(flight.getHoursDurationScale() + (flight.getMinutesDurationScale() / 60) > 0) {
                check[4] = true;
            }
        } else {
            Location scaleLocation = flight.getScaleLocation();
            if(flight.getHoursDurationScale() + (flight.getMinutesDurationScale() / 60) <= 0) {
                check[4] = true;
            }
            if(scaleLocation.equals(flight.getArrivalLocation()) | scaleLocation.equals(flight.getDepartureLocation())){
                check[5] = true;
            }
        }
        
        if(flight.getDepartureDate().isBefore(hoy)){
            check[6] = true;
        }
        
        if(flight.getHoursDurationArrival() + (flight.getMinutesDurationArrival() / 60) <= 0) {
            check[7] = true;
        }
       
        return check;
    }

    @Override
    public String[] error(boolean[] check) {
        String[] e = new String[check.length];
        
        System.out.println(check.length);
        
        for (int i = 0; i < check.length; i++) {
            System.out.println(i + ". " + check[i]);
            switch (i){
                case 0 -> {
                    if(check[0]) e[0] = "Id no valido";
                }
                case 1 -> {
                    if(check[1]) e[1] = "Avion no valido";
                }
                case 2 -> {
                    if(check[2]) e[2] = "Lugares no valido";
                }
                case 3 -> {
                    if(check[3]) e[3] = "Salida y Llegada iguales";
                }
                case 4 -> {
                    if(check[4]) e[4] = "Hora de escala no valida";
                }
                case 5 -> {
                    if(check[5]) e[5] = "Escala es igual a Salido y/o LLegada";
                }
                case 6 -> {
                    if(check[6]) e[6] = "Fecha no valida";
                }
                case 7 -> {
                    if(check[7]) e[7] = "Hora de salida no valida";
                }
            }
        }
        
        return e;
    }

    @Override
    public boolean[] Verification(Flight t, ArrayList<Flight> ts) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
