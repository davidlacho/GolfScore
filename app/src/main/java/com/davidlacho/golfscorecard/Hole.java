package com.davidlacho.golfscorecard;

/**
 * Created by david.lacho on 2019-06-28
 */
public class Hole {

  private String label;
  private Integer strokeCount;

  public Hole(String label, Integer strokeCount) {
    this.label = label;
    this.strokeCount = strokeCount;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public Integer getStrokeCount() {
    return strokeCount;
  }

  public void setStrokeCount(Integer strokeCount) {
    this.strokeCount = strokeCount;
  }


}
