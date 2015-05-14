package com.springTest;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class Testspring {
	@Resource
	@Value("testfff")
	private String mString;

	public String getmString() {
		return mString;
	}

	public void setmString(String mString) {
		this.mString = mString;
	}

	public String Excute() {
		return mString;
	}
}
