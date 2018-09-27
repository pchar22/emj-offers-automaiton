package com.albertsons.api.framework.support.pojo.ucpservices;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * This class contains the pojo representation of error.
 * @author SKuna02
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "message", "msg"})
public class RewardsError {

  @JsonProperty("code")
  private int code;

  @JsonProperty("msg")
  private String msg;

  @JsonProperty("message")
  private String message;

  @JsonProperty("code")
  public int getCode() {
    return code;
  }

  @JsonProperty("code")
  public void setCode(int code) {
    this.code = code;
  }

  @JsonProperty("msg")
  public String getMsg() {
    return msg;
  }

  @JsonProperty("msg")
  public void setMsg(String msg) {
    this.msg = msg;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RewardsError that = (RewardsError) o;
    return code == that.code
        && Objects.equal(msg, that.msg)
        && Objects.equal(message, that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(code, msg, message);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("code", code)
        .add("msg", msg)
        .add("message", message)
        .toString();
  }
}
