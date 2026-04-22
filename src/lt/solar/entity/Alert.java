package lt.solar.entity;

import jakarta.persistence.*;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String level; // LOW / HIGH

    @ManyToOne
    private SolarPark solarPark;

    // getters/setters
    public Long getId() { return id; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public SolarPark getSolarPark() { return solarPark; }
    public void setSolarPark(SolarPark solarPark) { this.solarPark = solarPark; }
}