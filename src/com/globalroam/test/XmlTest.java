package com.globalroam.test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.xmlpull.v1.XmlSerializer;

import com.globalroam.constants.ConstantValue;

import android.test.AndroidTestCase;
import android.util.Xml;

public class XmlTest extends AndroidTestCase {
	
	
	void createXML() {
		
		XmlSerializer serializer = Xml.newSerializer();
		Writer writer = new StringWriter();
		
		
		try {
			serializer.setOutput(writer );
			serializer.startDocument(ConstantValue.ENCODING,null);
			
			serializer.endDocument();
			
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
