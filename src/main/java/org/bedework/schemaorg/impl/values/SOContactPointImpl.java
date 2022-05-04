/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.impl.JsonFactory;
import org.bedework.schemaorg.model.SOPropertyNames;
import org.bedework.schemaorg.model.values.SOContactPoint;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOContactPointImpl extends SOThingImpl
        implements SOContactPoint {
  public SOContactPointImpl(final JsonFactory factory,
                            final String type,
                            final JsonNode node) {
    super(factory, type, node);
  }

  @Override
  public void setTelephone(final String val) {
    setProperty(SOPropertyNames.telephone, val);
  }

  @Override
  public String getTelephone() {
    return getStringProperty(SOPropertyNames.telephone);
  }

  @Override
  public void setEmail(final String val) {
    setProperty(factory.makeProperty(SOPropertyNames.email,
                                     val));
  }

  @Override
  public String getEmail() {
    return getStringProperty(SOPropertyNames.email);
  }
}
