/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.Table;

import Model.Flight;
import Model.Location;
import Model.Passenger;
import Model.Plane;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HLLINAS
 */
public class Order {

    static public void tablePassenger(DefaultTableModel model, ArrayList<Passenger> passengers) {
        model.setRowCount(0);

        if (model.getRowCount() != 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(0);
            }
        }

        passengers.sort(Comparator.comparingLong(Passenger::getId));

        for (Passenger passenger : passengers) {
            model.addRow(new Object[]{passenger.getId(), passenger.getFullname(), passenger.getBirthDate(), passenger.calculateAge(), passenger.generateFullPhone(), passenger.getCountry(), passenger.getNumFlights()});
        }
    }

    static public void tableAirplane(DefaultTableModel model, ArrayList<Plane> planes) {
        model.setRowCount(0);

        if (model.getRowCount() != 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(0);
            }
        }

        planes.sort(Comparator
                .comparing((Plane p) -> p.getId().substring(0, 2))
                .thenComparing(p -> Integer.valueOf(p.getId().substring(2)))
        );

        for (Plane plane : planes) {
            model.addRow(new Object[]{plane.getId(), plane.getBrand(), plane.getModel(), plane.getMaxCapacity(), plane.getAirline(), plane.getNumFlights()});
        }
    }

    static public void tableLocation(DefaultTableModel model, ArrayList<Location> locations) {
        model.setRowCount(0);

        if (model.getRowCount() != 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(0);
            }
        }

        locations.sort(Comparator.comparing((Location l) -> l.getAirportId()));

        for (Location location : locations) {
            model.addRow(new Object[]{location.getAirportId(), location.getAirportName(), location.getAirportCity(), location.getAirportCountry()});
        }
    }

    static public void tableFlight(DefaultTableModel model, ArrayList<Flight> flights) {
        model.setRowCount(0);

        if (model.getRowCount() != 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(0);
            }
        }

        flights.sort(Comparator.comparing(Flight::getDepartureDate));

        for (Flight flight : flights) {
            model.addRow(new Object[]{flight.getId(), flight.getDepartureLocation().getAirportId(), flight.getArrivalLocation().getAirportId(), (flight.getScaleLocation() == null ? "-" : flight.getScaleLocation().getAirportId()), flight.getDepartureDate(), flight.calculateArrivalDate(), flight.getPlane().getId(), flight.getNumPassengers()});
        }
    }
    
    static public void tableFlight(DefaultTableModel model,ArrayList<Passenger> passengers, long passengerId) {
 
        Passenger passenger = null;
        for (Passenger p : passengers) {
            if (p.getId() == passengerId) {
                passenger = p;
            }
        }

        ArrayList<Flight> flights = passenger.getFlights();
        
        flights.sort(Comparator.comparing(Flight::getDepartureDate));
        
        model.setRowCount(0);
        for (Flight flight : flights) {
            model.addRow(new Object[]{flight.getId(), flight.getDepartureDate(), flight.calculateArrivalDate()});
        }
    }
}
