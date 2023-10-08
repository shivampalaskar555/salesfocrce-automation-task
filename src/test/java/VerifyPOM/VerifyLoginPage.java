package VerifyPOM;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencsv.exceptions.CsvValidationException;

public class VerifyLoginPage extends BaseClass {
	
	@Test
	void VerifyLoignScenarios() throws CsvValidationException, IOException, InterruptedException
	{
		lg.LoginDeal();
	}

}
