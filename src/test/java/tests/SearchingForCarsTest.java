package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.SearchingForCarsPageObject;

public class SearchingForCarsTest extends TestBase {

	SearchingForCarsPageObject Object;

	@Test
	public void SearchTest()
	{
		Object = new SearchingForCarsPageObject(driver);
		try {
			Object.SearchingForCars();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


