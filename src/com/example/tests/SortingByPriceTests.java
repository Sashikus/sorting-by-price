
package com.example.tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class SortingByPriceTests extends TestBase {
	@Test
	public void verifyThatSortingByPriceForTrainsIsCorrect() throws Exception {
		app.openMainPage();
		app.goToResultsPage();
		comparePrices();
	}

	// verifyThatSortingByPriceForAirplanesIsCorrect
	// TODO

	// verifyThatSortingByPriceForBussesIsCorrect
	// TODO

	// -- private methods --

	private void comparePrices() {
		List<Float> listOfPrices = app.getListOfPrices();
		List<Float> expectedList = new ArrayList<Float>(listOfPrices);
		Collections.sort(listOfPrices);
		assertTrue("the list of prices isn't sorted", expectedList.equals(listOfPrices));
	}
}
