package org.bedework.schemaorg.model.values;

import org.bedework.json.model.values.JsonValue;

/**
 * User: mike Date: 10/25/19 Time: 12:46
 */
public interface SOThing extends JsonValue {
  void setName(String val);

  String getName();

  /**
   *
   * @param val an identifier ISBN, GTIN code, UUID etc
   */
  void setIdentifier(String val);

  String getIdentifier();

  void setDescription(String val);

  String getDescription();

  void setUrl(String val);

  String getUrl();
}
