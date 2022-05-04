package org.bedework.schemaorg.model.values;

import java.net.URI;

/** Not to be created iteself. Used as a base type for
 * other geo classes
 *
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface SOGeoCoordinates extends SOGeo {
  /** Physical address of the item.
   */
  void setAddress(SOPostalAddress val);

  SOPostalAddress getAddress();

  /** Country  or
   The country. For example, USA. You can also provide the two-letter ISO 3166-1 alpha-2 country code.
   */
  void setAddressCountry(String val);

  String getAddressCountry();

  /** The elevation of a location (WGS 84). Values may be of
   * the form 'NUMBER UNITOFMEASUREMENT' (e.g., '1,000 m', '3,200 ft') while numbers alone should be assumed to be a value in meters.
   */
  void setElevation(double val);

  Double getElevation();

  /** Number or Text The latitude of a location. For example 37.42242 (WGS 84).
   */
  void setLatitude(double val);

  Double getLatitude();

  /** Number or Text longitude of a location. For example -122.08585 (WGS 84).
  postalCode 	Text 	The postal code. For example, 94043.
   */
  void setLongitude(double val);

  Double getLongitude();

  /** Set the coordinates from a uri
   *
   * @param val a geo uri
   */
  void setURI(URI val);

  /**
   *
   * @return a geo uri or null
   */
  URI getURI();
}
