/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.model.values;

/**
 * User: mike Date: 5/4/22 Time: 14:53
 */
public interface SOPlace extends SOThing {
  /** Physical address of the item.
   */
  void setAddress(SOPostalAddress val);

  SOPostalAddress getAddress();

  /** The geo coordinates of the place.
   */
  void setGeo(SOGeo val);

  SOGeo getGeo();

  /**
   *
   * @param val A URL to a map of the place
   */
  void setHasMap(String val);

  String getHasMap();

  /**
   *
   * @param val A flag to signal that the item, event, or place
   *            is accessible for free.
   */
  void setIsAccessibleForFree(boolean val);

  boolean getIsAccessibleForFree();

  void setTelephone(String val);

  String getTelephone();
}
