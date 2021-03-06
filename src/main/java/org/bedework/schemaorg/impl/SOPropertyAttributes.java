/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl;

import org.bedework.json.JsonRegistration;
import org.bedework.json.JsonTypeInfo;
import org.bedework.json.JsonValueFactory;
import org.bedework.schemaorg.impl.values.factories.SOContactPointFactory;
import org.bedework.schemaorg.impl.values.factories.SOGeoCoordinatesFactory;
import org.bedework.schemaorg.impl.values.factories.SOPlaceFactory;
import org.bedework.schemaorg.impl.values.factories.SOPostalAddressFactory;
import org.bedework.schemaorg.impl.values.factories.SOThingFactory;
import org.bedework.schemaorg.model.SOTypes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * User: mike Date: 5/3/22 Time: 22:19
 */
public class SOPropertyAttributes implements JsonRegistration {
  private final static String registrationName =
          "bw-schemaorgforj";

  // Type names for properties
  private final static Map<String, String> ptypes =
          new HashMap<>();

  // Type info for types
  private final static Map<String, JsonTypeInfo> types =
          new HashMap<>();

  private final static Map<String, String> schemas =
          new HashMap<>();

  private final static Map<String, List<String>> validFor =
          new HashMap<>();

  private final static Map<String, List<String>> contains =
          new HashMap<>();

  /* ===== info for types ======================= */

  static {
    type(SOTypes.typeContactPoint,
         "https://schema.org/ContactPoint",
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOContactPointFactory.class); // factoryClass

    type(SOTypes.typeGeoCoordinates,
         "https://schema.org/GeoCoordinates",
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOGeoCoordinatesFactory.class); // factoryClass

    type(SOTypes.typePlace,
         "https://schema.org/Place",
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOPlaceFactory.class); // factoryClass

    type(SOTypes.typePostalAddress,
         "https://schema.org/PostalAddress",
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOPostalAddressFactory.class); // factoryClass

    type(SOTypes.typeThing,
         "https://schema.org/Thing",
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOThingFactory.class); // factoryClass
  }

  private static void type(final String typeName,
                           final String schema,
                           final boolean requiresType,
                           final boolean valueList,
                           final boolean propertyList,
                           final String[] elementType,
                           final boolean object,
                           final Class<? extends JsonValueFactory> factoryClass) {
    types.put(typeName,
              new JsonTypeInfo(typeName, requiresType,
                               valueList, propertyList,
                               elementType, object,
                               factoryClass));
    if (schema != null) {
      schemas.put(typeName, schema);
    }
  }

  private static String[] types(final String... types) {
    return types;
  }

  public static String getSchema(final String typeName) {
    return schemas.get(typeName);
  }

  @Override
  public String getRegistrationName() {
    return registrationName;
  }

  @Override
  public Set<String> propertyNames() {
    return ptypes.keySet();
  }

  @Override
  public String getType(final String propertyName) {
    return ptypes.get(propertyName);
  }

  @Override
  public JsonTypeInfo getTypeInfo(final String name) {
    return types.get(name);
  }
}
