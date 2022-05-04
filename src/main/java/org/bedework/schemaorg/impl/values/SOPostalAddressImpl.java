/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.impl.JsonFactory;
import org.bedework.schemaorg.model.SOPropertyNames;
import org.bedework.schemaorg.model.values.SOPostalAddress;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOPostalAddressImpl extends SOContactPointImpl
        implements SOPostalAddress {
  public SOPostalAddressImpl(final JsonFactory factory,
                             final String type,
                             final JsonNode node) {
    super(factory, type, node);
  }

  @Override
  public void setAddressCountry(final String val) {
    setProperty(SOPropertyNames.addressCountry, val);
  }

  @Override
  public String getAddressCountry() {
    return getStringProperty(SOPropertyNames.addressCountry);
  }

  @Override
  public void setAddressLocality(final String val) {
    setProperty(factory.makeProperty(SOPropertyNames.addressLocality,
                                     val));
  }

  @Override
  public String getAddressLocality() {
    return getStringProperty(SOPropertyNames.addressLocality);
  }

  @Override
  public void setAddressRegion(final String val) {
    setProperty(SOPropertyNames.addressRegion, val);
  }

  @Override
  public String getAddressRegion() {
    return getStringProperty(SOPropertyNames.addressRegion);
  }

  @Override
  public void setPostOfficeBoxNumber(final String val) {
    setProperty(SOPropertyNames.postOfficeBoxNumber, val);
  }

  @Override
  public String getPostOfficeBoxNumber() {
    return getStringProperty(SOPropertyNames.postOfficeBoxNumber);
  }

  @Override
  public void setPostalCode(final String val) {
    setProperty(SOPropertyNames.postalCode, val);
  }

  @Override
  public String getPostalCode() {
    return getStringProperty(SOPropertyNames.postalCode);
  }

  @Override
  public void setStreetAddress(final String val) {
    setProperty(SOPropertyNames.streetAddress, val);
  }

  @Override
  public String getStreetAddress() {
    return getStringProperty(SOPropertyNames.streetAddress);
  }
}
