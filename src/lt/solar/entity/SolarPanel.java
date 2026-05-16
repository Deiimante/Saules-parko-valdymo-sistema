package lt.solar.entity;

import jakarta.persistence.*;

@Entity
public class SolarPanel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private double power;
    private String status;

    @ManyToOne
    private SolarPark solarPark;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPower() { return power; }
    public void setPower(double power) { this.power = power; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public SolarPark getSolarPark() { return solarPark; }
    public void setSolarPark(SolarPark solarPark) { this.solarPark = solarPark; }
}