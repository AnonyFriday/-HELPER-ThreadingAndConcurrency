/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.projects.flight.services;

import java.util.ArrayList;
import java.util.List;
import thread.projects.flight.AirlineFlightSearchInterface;
import thread.projects.flight.FlightData;

/**
 *
 * @author duyvu
 */
public class GoAirFlightSearchService implements AirlineFlightSearchInterface {

    @Override
    public List<FlightData> getFlightBySrcDes(String src, String des) {
        List<FlightData> response = new ArrayList<>();
        response.add(new FlightData("AL1", "BLR", 5000.00));
        response.add(new FlightData("AL2", "BLR", 5000.00));
        response.add(new FlightData("AL3", "BLR", 5000.00));

        return response;
    }
}
