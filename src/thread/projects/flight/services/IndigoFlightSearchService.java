/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
public class IndigoFlightSearchService implements AirlineFlightSearchInterface {

    /**
     * Demonstrate the API call to the database to get the list of Indigo Flight
     *
     * @param src
     * @param des
     * @return
     */
    @Override
    public List<FlightData> getFlightBySrcDes(String src, String des) {
        List<FlightData> response = new ArrayList<>();
        response.add(new FlightData("DLI1", "BLR1", 5000.00));
        response.add(new FlightData("DLI2", "BLR2", 5000.00));
        response.add(new FlightData("DLI3", "BLR3", 5000.00));
        return response;
    }
}
