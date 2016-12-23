
package com.example.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SortingByPriceTests extends TestBase {

	public static final String AIRPLANE_TAB = "//span[@data-key='dw.flight']";
	public static final String BUS_TAB = "//span[@data-key='dw.bus']";

	@Test
	public void verifyThatSortingByPriceForTrainsIsCorrect() throws Exception {
		openResultsPage();
		comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForAirplanesIsCorrect() throws Exception {
		openResultsPage();
		app.switchTabTo(AIRPLANE_TAB);
		comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForBussesIsCorrect() throws Exception {
		openResultsPage();
		app.switchTabTo(BUS_TAB);
		comparePrices();
	}

	// -- private methods --
	private void openResultsPage() {
		app.openMainPage();
		app.goToResultsPage();
		app.isSortingByPriceByDeafault();
	}

	private void comparePrices() {
		List<Float> listOfPrices = app.getListOfPrices();
		List<Float> expectedList = new ArrayList<Float>(listOfPrices);
		Collections.sort(listOfPrices);
		assertTrue("the list of prices isn't sorted", expectedList.equals(listOfPrices));
	}
}
