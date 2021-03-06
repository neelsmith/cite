package cite.citeUrn;

import edu.harvard.chs.cite.CiteUrn;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import org.concordion.integration.junit3.ConcordionTestCase;

public class ComponentsTest extends ConcordionTestCase {


    public String getNs(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getNs();
    }


    public String getObjComponent(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getObjectComponent();
    }

    public String getCollection(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getCollection();
    }

    public String getVersion(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getObjectVersion();
    }

    public String reduceToColl(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.reduceToCollection();
    }


    

    public String getExtendedRef(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getExtendedRef();
    }

    

    public boolean hasObjId(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.hasObjectId();
    }

    public boolean hasVersion(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.hasVersion();
    }

    public boolean hasExtendedRef(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.hasExtendedRef();
    }


    
    public String getObjId(String urnStr)
    throws Exception {
	CiteUrn urn = new CiteUrn(urnStr);
	return urn.getObjectId();
    }
    
    

    
    public boolean isValid(String urnStr) {
	try {
	    CiteUrn urn = new CiteUrn(urnStr);
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }


    public String uForm(String str)
    throws Exception {
	if (Normalizer.isNormalized(str, Normalizer.Form.NFC)) {
	    return ("NFC (composed)");
	} else 	if (Normalizer.isNormalized(str, Normalizer.Form.NFD)) {
	    return ("NFD (decomposed)");

	} else 	if (Normalizer.isNormalized(str, Normalizer.Form.NFKC)) {
	    return ("NFKC");

	} else 	if (Normalizer.isNormalized(str, Normalizer.Form.NFKD)) {
	    return ("NFKD");
	    
	}  else  {
	    throw new Exception("Unknown Unicode normalization form.");
	}
    }
    
    public Integer getBytes(String str)
	throws Exception {
	try {
	    byte[] byteArray = str.getBytes("UTF-8");
	    return byteArray.length;
	    
	} catch (Exception e) {
	    System.err.println ("UNable to get bytearray for " + str);
	    throw e;
	    }
    }




    public boolean matchesOutput(String urnStr) {
	Integer debug = 1;
	if (debug > 0) {
	    System.err.println ("Look for  matching urn from input " + urnStr);
	}

	try {
	    CiteUrn urn  = new CiteUrn(urnStr);
	    byte[] srcBytes = urn.toString().getBytes("UTF-8");
	    if (debug > 0) {
		System.err.println ("Src string in bytes: " + srcBytes.length);
		System.err.println ("NFC? " + Normalizer.isNormalized(urnStr, Normalizer.Form.NFC));
	    }
	    byte[] urnBytes = urn.toString().getBytes("UTF-8");
	    if (debug > 0) {
		System.err.println ("Urn string in bytes: " + urnBytes.length);
		System.err.println ("NFC? " + Normalizer.isNormalized(urn.toString(), Normalizer.Form.NFC));
	    }
	    return urnStr.equals(urn.toString());
	    
	} catch (Exception e) {
	    System.err.println ("Failed to make comparison.");
	    System.err.print(e);
	    return false;
	}
    }



    
}
