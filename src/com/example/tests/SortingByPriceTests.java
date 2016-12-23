
package com.example.tests;

import org.junit.Test;

public class SortingByPriceTests extends TestBase {

	private static final String FLIGHT_TAB = "//span[@data-key='dw.flight']";
	private static final String BUS_TAB = "//span[@data-key='dw.bus']";

	@Test
	public void verifyThatSortingByPriceForTrainsIsCorrect() {
		openResultsPage();
		helper.verifyUrlContainsTabName("train");
		helper.comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForAirplanesIsCorrect() {
		openResultsPage();
		helper.switchTabTo(FLIGHT_TAB);
		helper.verifyUrlContainsTabName("flight");
		helper.comparePrices();
	}

	@Test
	public void verifyThatSortingByPriceForBussesIsCorrect() {
		openResultsPage();
		helper.switchTabTo(BUS_TAB);
		helper.verifyUrlContainsTabName("bus");
		helper.comparePrices();
	}

	// -- private methods --
	private void openResultsPage() {
		helper.openMainPage();
		helper.goToResultsPage();
		helper.verifySortByDefault();
	}
}
