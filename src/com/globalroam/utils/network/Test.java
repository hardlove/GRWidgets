package com.globalroam.utils.network;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import android.test.AndroidTestCase;

public class Test extends AndroidTestCase{

	
	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
	}
	public void testURL() {
		
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("name", "chenlu");
		params.put("age", 25+"");
		params.put("sex", "man");
		String url = HttpUtils.createParamsUrl("www.baidu.com", params);
		System.out.println(url);
	}

}
