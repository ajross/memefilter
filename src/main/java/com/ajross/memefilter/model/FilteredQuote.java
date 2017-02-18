package com.ajross.memefilter.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * FilteredQuote
 */

public class FilteredQuote   {
  
    
    
  
  
  private String input = null;

  
    
    
  
  
  private String reality = null;

  
  
  
  public FilteredQuote input(String input) {
    this.input = input;
    return this;
  }
  
  

  
   /**
  
   * Quote to be filtered.
  
  
  
  
   * @return input
  **/
 
  @ApiModelProperty(value = "Quote to be filtered.")
  public String getInput() {
    return input;
  }
  

  public void setInput(String input) {
    this.input = input;
  }
  

  
  
  public FilteredQuote reality(String reality) {
    this.reality = reality;
    return this;
  }
  
  

  
   /**
  
   * Real meaning behind quote.
  
  
  
  
   * @return reality
  **/
 
  @ApiModelProperty(value = "Real meaning behind quote.")
  public String getReality() {
    return reality;
  }
  

  public void setReality(String reality) {
    this.reality = reality;
  }
  

  

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilteredQuote filteredQuote = (FilteredQuote) o;
    return Objects.equals(this.input, filteredQuote.input) &&
        Objects.equals(this.reality, filteredQuote.reality);
  }

  @Override
  public int hashCode() {
    return Objects.hash(input, reality);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilteredQuote {\n");
    
    sb.append("    input: ").append(toIndentedString(input)).append("\n");
    sb.append("    reality: ").append(toIndentedString(reality)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

