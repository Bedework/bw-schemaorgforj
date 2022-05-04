/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl.values;

import org.bedework.json.impl.JsonFactory;
import org.bedework.schemaorg.model.values.SOGeo;

import com.fasterxml.jackson.databind.JsonNode;

/** Not to be created iteself. Used as a base type for
 * other geo classes
 * User: mike Date: 10/25/19 Time: 12:45
 */
public class SOGeoImpl extends SOThingImpl
        implements SOGeo {
  public SOGeoImpl(final JsonFactory factory,
                   final String type,
                   final JsonNode node) {
    super(factory, type, node);
  }
}
