package lt.solar.entity;

import jakarta.persistence.*;

@Entity
public class Inverter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;

    private String model;

    private String manufacturer;

    private double maxPowerKW;

    private String status;

    @ManyToOne
    private SolarPark park;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getMaxPowerKW() {
        return maxPowerKW;
    }

    public void setMaxPowerKW(double maxPowerKW) {
        this.maxPowerKW = maxPowerKW;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SolarPark getPark() {
        return park;
    }

    public void setPark(SolarPark park) {
        this.park = park;
    }
}