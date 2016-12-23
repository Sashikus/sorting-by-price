
package com.example.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SortingByPriceTests extends TestBase {

	private static final String TRAIN_TAB = "//span[@data-key='dw.bus']";
	private static final String FLIGHT_TAB = "//span[@data-key='dw.flight']";
	private static final String BUS_TAB = "//span[@data-key='dw.bus']";

	@Test
	public void verifyThatSortingByPriceForTrainsIsCorrect() throws Exception {
		openResultsPage();
		app.validateThatTabIsOpened("train");
		comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForAirplanesIsCorrect() throws Exception {
		openResultsPage();
		app.switchTabTo(FLIGHT_TAB);
		app.validateThatTabIsOpened("flight");
		comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForBussesIsCorrect() throws Exception {
		openResultsPage();
		app.switchTabTo(BUS_TAB);
		app.validateThatTabIsOpened("bus");
		comparePrices();
	}

	// -- private methods --
	private void openResultsPage() {
		app.openMainPage();
		app.goToResultsPage();
		app.isSortingByPriceByDefault();
	}

	private void comparePrices() {
		List<Float> listOfPrices = app.getListOfPrices();
		List<Float> expectedList = new ArrayList<Float>(listOfPrices);
		Collections.sort(listOfPrices);
		assertTrue("the list of prices isn't sorted", expectedList.equals(listOfPrices));
	}
}
