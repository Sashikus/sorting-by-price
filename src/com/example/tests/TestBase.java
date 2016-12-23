package com.example.tests;

import org.junit.After;
import org.junit.Before;

import com.example.app.BaseHelper;

public class TestBase {

	protected BaseHelper helper;

	@Before
	public void setUp() throws Exception {
		helper = new BaseHelper();
	}

	@After
	public void tearDown() throws Exception {
		helper.stop();
	}
}