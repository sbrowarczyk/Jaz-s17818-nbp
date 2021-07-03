package pl.pjatk.jazs17818nbp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RequestData {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String currency;
  private String startDate;
  private String endDate;
  private Double averageCourse;
  private String dateAndStartRequest;

  public RequestData(String currency, String startDate, String endDate,
      Double averageCourse, String dateAndStartRequest) {
    this.currency = currency;
    this.startDate = startDate;
    this.endDate = endDate;
    this.averageCourse = averageCourse;
    this.dateAndStartRequest = dateAndStartRequest;

  }

  public RequestData() {

  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public Double getAverageCourse() {
    return averageCourse;
  }

  public void setAverageCourse(Double averageCourse) {
    this.averageCourse = averageCourse;
  }

  public String getDateAndStartRequest() {
    return dateAndStartRequest;
  }

  public void setDateAndStartRequest(String dateAndStartRequest) {
    this.dateAndStartRequest = dateAndStartRequest;
  }
}
