package edu.harvard.chs.cite



import org.junit.Test
import static groovy.test.GroovyAssert.shouldFail


class TestCiteUrnManipRangeParts {

  // getRangeBegin()
  @Test
  void testGetRangeBegin(){

   CiteUrn notRange1 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013")
   CiteUrn notRange2 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1")
   CiteUrn notRange3 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1@0.12,0.12,0.12,0.12")
   assert shouldFail {
     CiteUrn notRange4 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013@0.12,0.12,0.12,0.12")
   }
   CiteUrn range1 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1-VA024RN_0025")
   assert shouldFail {
     CiteUrn range2 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013-VA024RN_0025@0.1532,0.1021,0.4014,0.0225")
   }
   CiteUrn range3 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1@0.1532,0.1021,0.4014,0.0225-VA024RN_0025.v1@0.1532,0.1021,0.4014,0.0225")
   assert shouldFail {
     CiteUrn range4 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013@0.1532,0.1021,0.4014,0.0225-VA024RN_0025@0.1532,0.1021,0.4014,0.0225")
   }
   
   assert notRange1.getRangeBegin() == "urn:cite:hmt:vaimg.VA012RN_0013"
   assert notRange2.getRangeBegin() == "urn:cite:hmt:vaimg.VA012RN_0013.v1"
   assert notRange3.getRangeBegin() == "urn:cite:hmt:vaimg.VA012RN_0013.v1@0.12,0.12,0.12,0.12"
   assert range1.getRangeBegin() == "urn:cite:hmt:vaimg.VA012RN_0013.v1"

   assert range3.getRangeBegin() == "urn:cite:hmt:vaimg.VA012RN_0013.v1@0.1532,0.1021,0.4014,0.0225"
  }

  // getRangeEnd()
  @Test
  void testGetRangeEnd(){

   CiteUrn notRange1 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013")
   CiteUrn notRange2 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1")
   CiteUrn notRange3 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1@0.12,0.12,0.12,0.12")
   assert shouldFail {
     CiteUrn notRange4 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013@0.12,0.12,0.12,0.12")
   }
   CiteUrn range1 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1-VA024RN_0025")
   assert shouldFail {
     CiteUrn range2 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013-VA024RN_0025@0.1532,0.1021,0.4014,0.0225")
   }
   CiteUrn range3 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013.v1@0.1532,0.1021,0.4014,0.0225-VA024RN_0025.v1@0.1532,0.1021,0.4014,0.0225")
   assert shouldFail {
     CiteUrn range4 = new CiteUrn("urn:cite:hmt:vaimg.VA012RN_0013@0.1532,0.1021,0.4014,0.0225-VA024RN_0025@0.1532,0.1021,0.4014,0.0225")
   }

   assert notRange1.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013"
   assert notRange2.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013.v1"
   assert notRange3.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013.v1@0.12,0.12,0.12,0.12"
   assert notRange1.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013"
   assert notRange2.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013.v1"
   assert notRange3.getRangeEnd() == "urn:cite:hmt:vaimg.VA012RN_0013.v1@0.12,0.12,0.12,0.12"
   assert range1.getRangeEnd() == "urn:cite:hmt:vaimg.VA024RN_0025.v1"
   assert range3.getRangeEnd() == "urn:cite:hmt:vaimg.VA024RN_0025.v1@0.1532,0.1021,0.4014,0.0225"

  }

}