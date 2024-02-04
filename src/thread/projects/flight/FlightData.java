/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread.projects.flight;

/**
 *
 * @author duyvu
 */
public class FlightData {

    private String src;
    private String des;
    private Double cost;

    public FlightData(String src, String des, Double cost) {
        this.src = src;
        this.des = des;
        this.cost = cost;
    }

    public FlightData() {
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return getDes() + "-" + getSrc() + "-" + getCost();
    }

}
