package cn.bdqn.entity;


public class Rainquality {

  private Integer id;
  private String districtName;
  private String monitorTime;
  private Integer rain;
  private String monitoringStation;
  private String monitoringAddress;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDistrictName() {
    return districtName;
  }

  public void setDistrictName(String districtName) {
    this.districtName = districtName;
  }

  public String getMonitorTime() {
    return monitorTime;
  }

  public void setMonitorTime(String monitorTime) {
    this.monitorTime = monitorTime;
  }

  public Integer getRain() {
    return rain;
  }

  public void setRain(Integer rain) {
    this.rain = rain;
  }

  public String getMonitoringStation() {
    return monitoringStation;
  }

  public void setMonitoringStation(String monitoringStation) {
    this.monitoringStation = monitoringStation;
  }

  public String getMonitoringAddress() {
    return monitoringAddress;
  }

  public void setMonitoringAddress(String monitoringAddress) {
    this.monitoringAddress = monitoringAddress;
  }

  public Rainquality() {
  }

  public Rainquality(Integer id, String districtName, String monitorTime, Integer rain, String monitoringStation, String monitoringAddress) {
    this.id = id;
    this.districtName = districtName;
    this.monitorTime = monitorTime;
    this.rain = rain;
    this.monitoringStation = monitoringStation;
    this.monitoringAddress = monitoringAddress;
  }

  public Rainquality(String districtName, String monitorTime, Integer rain, String monitoringStation, String monitoringAddress) {
    this.districtName = districtName;
    this.monitorTime = monitorTime;
    this.rain = rain;
    this.monitoringStation = monitoringStation;
    this.monitoringAddress = monitoringAddress;
  }
}
