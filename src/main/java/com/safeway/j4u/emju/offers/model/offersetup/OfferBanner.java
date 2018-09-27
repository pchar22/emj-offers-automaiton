package com.safeway.j4u.emju.offers.model.offersetup;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@XmlRootElement(name="OfferBanner")
@XmlAccessorType(XmlAccessType.NONE)
public class OfferBanner {
	@XmlElement(name="BannerCode")
	private String bannerCode;
	@XmlElement(name="VendorBannerCode")
	private String vendorBannerCode;
}
