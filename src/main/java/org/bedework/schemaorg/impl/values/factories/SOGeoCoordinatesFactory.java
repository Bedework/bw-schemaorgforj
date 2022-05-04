/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values.factories;

import org.bedework.json.impl.JsonFactory;
import org.bedework.json.impl.values.JsonValueFactoryImpl;
import org.bedework.json.model.values.JsonValue;
import org.bedework.schemaorg.impl.values.SOGeoCoordinatesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class SOGeoCoordinatesFactory extends JsonValueFactoryImpl {
  @Override
  public JsonValue newValue(final JsonFactory factory,
                            final String typeName,
                            final JsonNode nd) {
    if (nd != null) {
      return new SOGeoCoordinatesImpl(factory, typeName,
                                      ensureType(typeName,
                                        (ObjectNode)nd));
    }

    return new SOGeoCoordinatesImpl(factory, typeName, newObject(typeName));
  }
}
