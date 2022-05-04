/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl;

import org.bedework.json.JsonRegistration;
import org.bedework.json.JsonTypeInfo;
import org.bedework.json.JsonValueFactory;
import org.bedework.schemaorg.impl.values.factories.SOContactPointFactory;
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

  private final static Map<String, List<String>> validFor =
          new HashMap<>();

  private final static Map<String, List<String>> contains =
          new HashMap<>();

  /* ===== info for types ======================= */

  static {
    type(SOTypes.typeContactPoint,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOContactPointFactory.class); // factoryClass

    type(SOTypes.typePostalAddress,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOPostalAddressFactory.class); // factoryClass

    type(SOTypes.typeThing,
         true, // requiresType
         false, // valueList
         false, // propertyList
         null, // elementType
         true, // object
         SOThingFactory.class); // factoryClass
  }

  private static void type(final String typeName,
                           final boolean requiresType,
                           final boolean valueList,
                           final boolean propertyList,
                           final String[] elementType,
                           final boolean object,
                           final Class<? extends JsonValueFactory> factoryClass) {
    types.put(typeName,
              new JsonTypeInfo(typeName, requiresType, valueList, propertyList,
                             elementType, object, factoryClass));
  }

  private static String[] types(final String... types) {
    return types;
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
