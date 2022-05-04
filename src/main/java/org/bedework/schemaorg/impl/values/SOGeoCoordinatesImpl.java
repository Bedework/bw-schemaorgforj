/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.JsonException;
import org.bedework.json.impl.JsonFactory;
import org.bedework.schemaorg.model.SOPropertyNames;
import org.bedework.schemaorg.model.values.SOGeoCoordinates;
import org.bedework.schemaorg.model.values.SOPostalAddress;

import com.fasterxml.jackson.databind.JsonNode;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOGeoCoordinatesImpl extends SOGeoImpl
        implements SOGeoCoordinates {
  public SOGeoCoordinatesImpl(final JsonFactory factory,
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
  public void setAddressCountry(final String val) {
    setProperty(SOPropertyNames.addressCountry, val);
  }

  @Override
  public String getAddressCountry() {
    return getStringProperty(SOPropertyNames.addressCountry);
  }

  @Override
  public void setElevation(final double val) {
    setProperty(SOPropertyNames.elevation, val);
    removeProperty(SOPropertyNames.url);
  }

  @Override
  public Double getElevation() {
    return getDoubleProperty(SOPropertyNames.elevation);
  }

  @Override
  public void setLatitude(final double val) {
    setProperty(SOPropertyNames.latitude, val);
    removeProperty(SOPropertyNames.url);
  }

  @Override
  public Double getLatitude() {
    return getDoubleProperty(SOPropertyNames.latitude);
  }

  @Override
  public void setLongitude(final double val) {
    setProperty(SOPropertyNames.longitude, val);
    removeProperty(SOPropertyNames.url);
  }

  @Override
  public Double getLongitude() {
    return getDoubleProperty(SOPropertyNames.longitude);
  }

  @Override
  public void setURI(final URI val) {
    if (!"geo".equals(val.getScheme())) {
      throw new JsonException("Bad geo uri");
    }

    final var path = val.getPath();
    final String[] comps = path.split(",");

    if (comps.length < 2) {
      throw new JsonException("Bad geo uri");
    }

    setLatitude(Long.parseLong(comps[0]));
    setLongitude(Long.parseLong(comps[1]));

    if (comps.length > 2) {
      setElevation(Long.parseLong(comps[2]));
    }

    setProperty(SOPropertyNames.url, val.toString());
  }

  @Override
  public URI getURI() {
    var uriVal = getStringProperty(SOPropertyNames.url);
    if (uriVal == null) {
      if ((getLatitude() == null) || (getLongitude() == null)) {
        return null;
      }
      final var sb = new StringBuilder("geo:");
      sb.append(getLatitude());
      sb.append(",");
      sb.append(getLongitude());
      if (getElevation() != null) {
        sb.append(",");
        sb.append(getElevation());
      }

      uriVal = sb.toString();
    }

    try {
      return new URI(uriVal);
    } catch (final URISyntaxException use) {
      throw new JsonException(use);
    }
  }
}
