package eu.ase.functional;

public class CloudResource {
    private String id;
    private String type;
    private String region;
    private double costPerHour;
    private double uptimeHours;

    public CloudResource(String id, String type, String region, double costPerHour, double uptimeHours) {
        this.id = id;
        this.type = type;
        this.region = region;
        this.costPerHour = costPerHour;
        this.uptimeHours = uptimeHours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCostPerHour() {
        return costPerHour;
    }

    public void setCostPerHour(double costPerHour) {
        this.costPerHour = costPerHour;
    }

    public double getUptimeHours() {
        return uptimeHours;
    }

    public void setUptimeHours(double uptimeHours) {
        this.uptimeHours = uptimeHours;
    }

    @Override
    public String toString() {
        return "CloudResource{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", region='" + region + '\'' +
                ", costPerHour=" + costPerHour +
                ", uptimeHours=" + uptimeHours +
                '}';
    }

    public double uptimeCost() {
        return this.uptimeHours * this.costPerHour;
    }
}
