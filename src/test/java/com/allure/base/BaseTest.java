package com.allure.base;

import com.allure.models.ReportResponse;
import com.allure.models.ResultResponse;
import com.allure.service.AllureService;
import com.allure.utils.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected final AllureService ALLURE_SERVICE = new AllureService();
    protected final SoftAssert SOFT_ASSERTER = new SoftAssert();

    protected final ResultResponse[] INITIAL_RESULTS = ALLURE_SERVICE.getAllResults();

    protected final ReportResponse[] INITIAL_REPORTS = ALLURE_SERVICE.getReports();


    @BeforeClass
    public void getInitialData() {
        Reporter.info(String.format("Initial results count - %s ", INITIAL_RESULTS.length));
        Reporter.info(String.format("Initial reports count - %s", INITIAL_REPORTS.length));
    }

    @AfterMethod
    public void finishTest() {
        SOFT_ASSERTER.assertAll();
    }

}
