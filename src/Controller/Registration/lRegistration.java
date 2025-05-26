package Controller.Registration;

import Model.Location;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author HLLINAS
 */
public class lRegistration extends Registration<Location>{
    
    @Override
    public boolean Find(ArrayList<Location> locations, String id) {
        for (Location l : locations) {
            if(l.getAirportId() == null ? id == null : l.getAirportId().equals(id)) return true;
        }
        return false;
    }
    
    @Override
    public boolean[] Verification(Location location, ArrayList<Location> locations) {
        boolean[] check = new boolean[3];
        
        boolean find = Find(locations, location.getAirportId());
        
        String id = location.getAirportId();
        if (!id.matches("[A-Z]{3}") | find) {
            check[0] = true;
        }

        double lat = location.getAirportLatitude();
        if (lat < -90 | lat > 90) {
            check[1] = true;
        }


        double lon = location.getAirportLongitude();
        if (lon < -180 | lon > 180) {
            check[2] = true;
        }

        return check;
    }
    
    @Override
    public String[] error(boolean[] check) {
        String[] e = new String[check.length];
        
        for (int i = 0; i < check.length; i++) {
            switch (i){
                case 0 -> {
                    if(check[0]) e[0] = "Ha digitado mal el ID. Por favor, inténtalo de nuevo.";
                }
                case 1 -> {
                    if(check[1]) e[1] = "Latitud erronea. Por favor, inténtalo de nuevo.";
                }
                case 2 -> {
                    if(check[2]) e[2] = "Longitud erronea. Por favor, inténtalo de nuevo.";
                }
            }
        }
        
        return e;
    }

    @Override
    public boolean[] Verification(Location t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean Find(ArrayList<Location> ts, long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
