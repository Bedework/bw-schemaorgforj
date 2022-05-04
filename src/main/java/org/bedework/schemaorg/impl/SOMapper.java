/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.impl;

import org.bedework.json.impl.JsonMapper;

/**
 * User: mike Date: 5/3/22 Time: 23:15
 */
public class SOMapper extends JsonMapper {
  public SOMapper() {
    super();
    registerTypes(new SOPropertyAttributes());
  }
}
