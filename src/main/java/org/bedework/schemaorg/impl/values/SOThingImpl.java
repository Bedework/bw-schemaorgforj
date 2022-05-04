/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.impl.JsonFactory;
import org.bedework.json.impl.values.JsonValueImpl;
import org.bedework.schemaorg.model.SOPropertyNames;
import org.bedework.schemaorg.model.values.SOThing;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOThingImpl extends JsonValueImpl
        implements SOThing {
  public SOThingImpl(final JsonFactory factory,
                     final String type,
                     final JsonNode node) {
    super(factory, type, node);
  }

  @Override
  public void setName(final String val) {
    setProperty(SOPropertyNames.name, val);
  }

  @Override
  public String getName() {
    return getStringProperty(SOPropertyNames.name);
  }

  @Override
  public void setIdentifier(final String val) {
    setProperty(factory.makeProperty(SOPropertyNames.identifier,
                                     val));
  }

  @Override
  public String getIdentifier() {
    return getStringProperty(SOPropertyNames.identifier);
  }

  @Override
  public void setDescription(final String val) {
    setProperty(SOPropertyNames.description, val);
  }

  @Override
  public String getDescription() {
    return getStringProperty(SOPropertyNames.description);
  }

  @Override
  public void setUrl(final String val) {
    setProperty(SOPropertyNames.url, val);
  }

  @Override
  public String getUrl() {
    return getStringProperty(SOPropertyNames.url);
  }
}
