/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.projects.flight;

import java.util.ArrayList;
import java.util.List;
import thread.projects.flight.services.GoAirFlightSearchService;
import thread.projects.flight.services.IndigoFlightSearchService;

/**
 *
 * @author duyvu
 */
public class FlightSearchDemo {

    public static void main(String[] args) {
        List<AirlineFlightSearchInterface> listAirlineServices = new ArrayList<>();
        listAirlineServices.add(new GoAirFlightSearchService());
        listAirlineServices.add(new IndigoFlightSearchService());

        MmtSearchService searchService = new MmtSearchService(listAirlineServices);
        searchService.getFlightDataFromSrcDesMultiThreading("Vu", "Kim").forEach((data) -> {
            System.out.println(data.toString());
        });

    }
}
