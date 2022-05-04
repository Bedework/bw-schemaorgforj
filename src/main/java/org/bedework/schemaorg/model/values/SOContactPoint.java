package org.bedework.schemaorg.model.values;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface SOContactPoint extends SOThing {
  void setTelephone(String val);

  String getTelephone();

  void setEmail(String val);

  String getEmail();
}
