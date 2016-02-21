package edu.harvard.chs.cite


import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail



/** Class to test cite library's CiteCollection class.
*/
class TestTIExemplar {

  @Test
  void testExemplar() {
    TextInventory ti = new TextInventory(new File("testdata/tiwexemplar.xml"))
    System.err.println "HERE ARE ctsnamespace triples: " + ti.ctsnamespaces

  }



}
