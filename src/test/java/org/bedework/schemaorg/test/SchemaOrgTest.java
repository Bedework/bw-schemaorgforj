/* ********************************************************************
    Appropriate copyright notice
*/
package org.bedework.schemaorg.test;

import org.bedework.json.impl.values.JsonUnsignedIntegerImpl;
import org.bedework.json.impl.values.collections.JsonUnsignedIntArrayImpl;
import org.bedework.json.model.values.JsonValue;
import org.bedework.json.model.values.collections.JsonArray;
import org.bedework.schemaorg.impl.SOMapper;

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

import static org.junit.Assert.assertEquals;

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
