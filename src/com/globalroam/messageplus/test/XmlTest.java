package com.globalroam.messageplus.test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.xmlpull.v1.XmlSerializer;

import android.test.AndroidTestCase;
import android.util.Xml;

import com.globalroam.messageplus.constants.ConstantValue;
import com.globalroam.messageplus.modle.net.protocol.elementImpl.UserLoginElement;
import com.umeng.socialize.utils.Log;

public class XmlTest extends AndroidTestCase {
	
	
	public void createXMLTest() {
		
		XmlSerializer serializer = Xml.newSerializer();
		Writer writer = new StringWriter();
		
		
		try {
			serializer.setOutput(writer );
			serializer.startDocument(ConstantValue.ENCODING,null);
			
			UserLoginElement login = new UserLoginElement();
			login.serializableElement(serializer);
			
			serializer.endDocument();
			Log.i("============"+writer.toString()+"============");
			
			
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
