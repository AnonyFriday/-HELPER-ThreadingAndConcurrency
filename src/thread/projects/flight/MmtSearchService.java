/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.projects.flight;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.directory.SearchResult;

/**
 *
 * @author duyvu
 */
public class MmtSearchService {

    private List<AirlineFlightSearchInterface> flightSearchServices;
    private ExecutorService executorService;

    public MmtSearchService(List<AirlineFlightSearchInterface> flightSearchServices) {
        this.flightSearchServices = flightSearchServices;
        executorService = Executors.newFixedThreadPool(2);
    }

    public List<FlightData> getFlightDataFromSrcDes(String src, String des) {
//        GoAirFlightSearchService goAirFlightSearchService = new GoAirFlightSearchService();
//
//        List<FlightData> goAirData = goAirFlightSearchService.getFlightBySrcDes(src, des);
//
//        IndigoFlightSearchService indigoFlightSearchService = new IndigoFlightSearchService();
//
//        List<FlightData> indigoData = indigoFlightSearchService.getFlightBySrcDes(src, des);

//        finalResponse.addAll(goAirData);
//        finalResponse.addAll(indigoData);
        List<FlightData> finalResponse = new ArrayList<>();
        for (AirlineFlightSearchInterface searchService : flightSearchServices) {
            finalResponse.addAll(searchService.getFlightBySrcDes(src, des));
        }

        return finalResponse;
    }

    public List<FlightData> getFlightDataFromSrcDesMultiThreading(String src, String des) {
        List<Callable<List<FlightData>>> callableTaskList = new ArrayList<>();
        List<FlightData> finalResponses = new ArrayList<>();

        // Adding the class that implements the Searching Src, Des Interface
        for (AirlineFlightSearchInterface searchService : flightSearchServices) {
            callableTaskList.add(new Callable<List<FlightData>>() {
                @Override
                public List<FlightData> call() throws Exception {
                    return searchService.getFlightBySrcDes(src, des);
                }
            });
        }

        try {
            // Return the list of future results
            List<Future<List<FlightData>>> futureReponses = executorService.invokeAll(callableTaskList);

            // Adding each future into the final response array
            futureReponses.stream().forEach((response) -> {
                try {
                    finalResponses.addAll(response.get());
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(MmtSearchService.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (InterruptedException ex) {
            Logger.getLogger(MmtSearchService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return finalResponses;
    }
}
