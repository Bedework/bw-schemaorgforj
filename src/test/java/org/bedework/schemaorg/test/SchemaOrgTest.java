/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.test;

import org.bedework.json.impl.values.JsonUnsignedIntegerImpl;
import org.bedework.json.impl.values.collections.JsonUnsignedIntArrayImpl;
import org.bedework.json.model.values.JsonValue;
import org.bedework.json.model.values.collections.JsonArray;
import org.bedework.schemaorg.impl.SOMapper;
import org.bedework.schemaorg.model.SOTypes;
import org.bedework.schemaorg.model.values.SOGeoCoordinates;
import org.bedework.schemaorg.model.values.SOPlace;
import org.bedework.schemaorg.model.values.SOPostalAddress;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: mike Date: 10/25/19 Time: 16:39
 */
public class SchemaOrgTest {
  private final static String dataPath =
          "src/test/resources/data/";

  private final static String specificPath =
          "src/test/resources/specific/";

  private static final SOMapper mapper = new SOMapper();

  private String glob;

  protected Iterator<Path> files;

  @BeforeClass
  public static void oneTimeSetUp() {

  }

  @AfterClass
  public static void oneTimeTearDown() {

  }

  @Test
  public void testReadData() {
    try {
      final Path jpath = FileSystems.getDefault().getPath(dataPath);

      if (!jpath.toFile().isDirectory()) {
        throw new RuntimeException("Not a directory");
      }

      final DirectoryStream<Path> filesStream;

      if (glob == null) {
        filesStream = Files.newDirectoryStream(jpath, "*.json");
      } else {
        filesStream = Files.newDirectoryStream(jpath, glob);
      }

      files = filesStream.iterator();

      while (files.hasNext()) {
        final File f = files.next().toFile();

        info("Test read of " + f.getName());

        if (!f.isFile()) {
          System.out.println("Not a file: " + f.getAbsolutePath());
          continue;
        }

        final JsonValue obj = mapper.parse(new FileReader(f));

        info(obj.writeValueAsStringFormatted(mapper));
      }
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  private JsonValue readSpecificFile(final String name) {
    try {
      final Path jpath = FileSystems.getDefault()
                                    .getPath(specificPath,
                                             name);

      final File theFile = jpath.toFile();
      if (!theFile.isFile()) {
        throw new RuntimeException("Not a file");
      }

      info("Test read of " + theFile.getName());

      return mapper.parse(new FileReader(theFile));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
      return null;
    }
  }

  @Test
  public void testBuildPa() {
    try {
      final SOPostalAddress pa =
              (SOPostalAddress)mapper.getJFactory().newValue(SOTypes.typePostalAddress);

      assertTrue("Not SOPostalAddress",
                 pa instanceof SOPostalAddress);

      pa.setIdentifier(UUID.randomUUID().toString());

      pa.setName("My new location");
      pa.setStreetAddress("123 Mystreet");
      pa.setAddressLocality("Mytown");
      pa.setAddressRegion("NY");
      pa.setAddressCountry("US");
      pa.setPostalCode("12345");

      //loc.setCoordinates("geo:40.7654,73.9876");

      pa.setEmail("tlurkey@turkeys.example.com");

      info("Dump of created postal address");
      info(pa.writeValueAsStringFormatted(mapper));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }

  @Test
  public void testBuildPlace() {
    try {
      final SOPlace pl =
              (SOPlace)mapper.getJFactory().newValue(SOTypes.typePlace);

      assertTrue("Not SOPlace",
                 pl instanceof SOPlace);

      final SOGeoCoordinates geo =
              (SOGeoCoordinates)mapper.getJFactory().newValue(SOTypes.typeGeoCoordinates);

      assertTrue("Not SOGeoCoordinates",
                 geo instanceof SOGeoCoordinates);

      geo.setLatitude(42.67333333333333);
      geo.setLongitude(-73.83666666666667);

      pl.setGeo(geo);

      final SOPostalAddress pa =
              (SOPostalAddress)mapper.getJFactory().newValue(SOTypes.typePostalAddress);

      assertTrue("Not SOPostalAddress",
                 pa instanceof SOPostalAddress);

      pa.setIdentifier(UUID.randomUUID().toString());

      pa.setName("Albany Capitol Buildings");
      pa.setStreetAddress("125 State Street");
      pa.setAddressLocality("Albany");
      pa.setAddressRegion("NY");
      pa.setAddressCountry("US");
      pa.setPostalCode("12207");

      pl.setAddress(pa);

      info("Dump of created place");
      info(pl.writeValueAsStringFormatted(mapper));
    } catch (final Throwable t) {
      t.printStackTrace();
      Assert.fail(t.getMessage());
    }
  }


  private void mustBeUnsignedInt(final JsonValue val) {
    if (val == null) {
      return;
    }

    assertEquals("Must be JSUnsignedInteger:",
                        JsonUnsignedIntegerImpl.class,
                        val.getClass());
  }

  private void mustBeUnsignedInts(final JsonValue val) {
    if (val == null) {
      return;
    }

    assertEquals("Must be JSArray<JSUnsignedInteger>:",
                        JsonUnsignedIntArrayImpl.class,
                        val.getClass());

    for (final var el: ((JsonArray<?>)val).get()) {
      mustBeUnsignedInt((JsonValue)el);
    }
  }

  private void info(final String msg) {
    System.out.println(msg);
  }
}
