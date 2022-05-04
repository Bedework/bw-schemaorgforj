/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.impl.JsonFactory;
import org.bedework.schemaorg.model.SOPropertyNames;
import org.bedework.schemaorg.model.values.SOGeo;
import org.bedework.schemaorg.model.values.SOPlace;
import org.bedework.schemaorg.model.values.SOPostalAddress;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOPlaceImpl extends SOThingImpl
        implements SOPlace {
  public SOPlaceImpl(final JsonFactory factory,
                     final String type,
                     final JsonNode node) {
    super(factory, type, node);
  }

  @Override
  public void setAddress(final SOPostalAddress val) {
    setProperty(factory.makeProperty(
            SOPropertyNames.address, val));
  }

  @Override
  public SOPostalAddress getAddress() {
    return (SOPostalAddress)getPropertyValue(
            SOPropertyNames.address);
  }

  @Override
  public void setGeo(final SOGeo val) {
    setProperty(factory.makeProperty(
            SOPropertyNames.geo, val));
  }

  @Override
  public SOGeo getGeo() {
    return (SOGeo)getPropertyValue(
            SOPropertyNames.geo);
  }

  @Override
  public void setHasMap(final String val) {
    setProperty(SOPropertyNames.hasMap, val);
  }

  @Override
  public String getHasMap() {
    return getStringProperty(SOPropertyNames.hasMap);
  }

  @Override
  public void setIsAccessibleForFree(final boolean val) {
    setProperty(SOPropertyNames.isAccessibleForFree, val);
  }

  @Override
  public boolean getIsAccessibleForFree() {
    return getBooleanProperty(SOPropertyNames.isAccessibleForFree);
  }

  @Override
  public void setTelephone(final String val) {
    setProperty(SOPropertyNames.telephone, val);
  }

  @Override
  public String getTelephone() {
    return getStringProperty(SOPropertyNames.telephone);
  }
}
