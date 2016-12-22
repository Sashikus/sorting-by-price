package com.example.tests;

import org.junit.After;
import org.junit.Before;

import com.example.app.BaseHelper;

public class TestBase {

	protected BaseHelper app;

	@Before
	public void setUp() throws Exception {
		app = new BaseHelper();
	}

	@After
	public void tearDown() throws Exception {
		app.stop();
	}
}