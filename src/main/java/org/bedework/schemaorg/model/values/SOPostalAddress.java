package org.bedework.schemaorg.model.values;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface SOPostalAddress extends SOContactPoint {
  /** Country  or
   The country. For example, USA. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
   */
  void setAddressCountry(String val);

  String getAddressCountry();

  /** The locality in which the street address is, and which is in the region. For example, Mountain View.
   */
  void setAddressLocality(String val);

  String getAddressLocality();

  /** The region in which the locality is, and which is in the country. For example, California or another appropriate first-level Administrative division
   */
  void setAddressRegion(String val);

  String getAddressRegion();

  /** The post office box number for PO box addresses.
   */
  void setPostOfficeBoxNumber(String val);

  String getPostOfficeBoxNumber();

  /** The postal code. For example, 94043.
   postalCode 	Text 	The postal code. For example, 94043.
   */
  void setPostalCode(String val);

  String getPostalCode();

  void setStreetAddress(String val);

  String getStreetAddress();
}
