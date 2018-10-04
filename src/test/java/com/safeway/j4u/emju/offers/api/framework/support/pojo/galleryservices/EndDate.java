package com.safeway.j4u.emju.offers.api.framework.support.pojo.galleryservices;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "displayEffectiveEndDate",
        "offerEffectiveEndDate",
        "offerTestEffectiveEndDate"
})
public class EndDate {

    @JsonProperty("displayEffectiveEndDate")
    public String displayEffectiveEndDate;
    @JsonProperty("offerEffectiveEndDate")
    public String offerEffectiveEndDate;
    @JsonProperty("offerTestEffectiveEndDate")
    public String offerTestEffectiveEndDate;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("displayEffectiveEndDate", displayEffectiveEndDate).append("offerEffectiveEndDate", offerEffectiveEndDate).append("offerTestEffectiveEndDate", offerTestEffectiveEndDate).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(offerTestEffectiveEndDate).append(offerEffectiveEndDate).append(displayEffectiveEndDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof EndDate) == false) {
            return false;
        }
        EndDate rhs = ((EndDate) other);
        return new EqualsBuilder().append(offerTestEffectiveEndDate, rhs.offerTestEffectiveEndDate).append(offerEffectiveEndDate, rhs.offerEffectiveEndDate).append(displayEffectiveEndDate, rhs.displayEffectiveEndDate).isEquals();
    }

}