/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values.factories;

import org.bedework.json.impl.JsonFactory;
import org.bedework.json.impl.values.JsonValueFactoryImpl;
import org.bedework.json.model.values.JsonValue;
import org.bedework.schemaorg.impl.values.SOPostalAddressImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * User: mike Date: 10/25/19 Time: 14:59
 */
public class SOPostalAddressFactory extends JsonValueFactoryImpl {
  @Override
  public JsonValue newValue(final JsonFactory factory,
                            final String typeName,
                            final JsonNode nd) {
    if (nd != null) {
      return new SOPostalAddressImpl(factory, typeName,
                                     ensureType(typeName,
                                                (ObjectNode)nd));
    }

    return new SOPostalAddressImpl(factory, typeName, newObject(typeName));
  }
}
