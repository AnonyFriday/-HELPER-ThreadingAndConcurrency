/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package thread.projects.flight;

import java.util.List;

/**
 *
 * @author duyvu
 */
public interface AirlineFlightSearchInterface {
    List<FlightData> getFlightBySrcDes(String src, String des);
}
