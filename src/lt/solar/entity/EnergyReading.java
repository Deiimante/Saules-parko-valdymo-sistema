package lt.solar.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EnergyReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double producedPower;
    private double consumption;

    private LocalDateTime timestamp;

    @ManyToOne
    private SolarPark solarPark;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getProducedPower() { return producedPower; }
    public void setProducedPower(double producedPower) { this.producedPower = producedPower; }

    public double getConsumption() { return consumption; }
    public void setConsumption(double consumption) { this.consumption = consumption; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public SolarPark getSolarPark() { return solarPark; }
    public void setSolarPark(SolarPark solarPark) { this.solarPark = solarPark; }
}