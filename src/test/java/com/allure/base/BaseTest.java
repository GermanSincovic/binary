package com.allure.base;

import com.allure.models.*;
import com.allure.service.AllureService;
import com.allure.utils.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;

public class BaseTest {

    protected final AllureService ALLURE_SERVICE = new AllureService();
    protected final SoftAssert SOFT_ASSERTER = new SoftAssert();

    protected String TEST_FILENAME = "src/test/resources/allureResults.zip";

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

    protected ReportGenerateRequest makeReportGenerateRequestData(String uuid){
        String path = String.format("auto_%s", System.currentTimeMillis());
        ArrayList<String> resultsUUID = new ArrayList<>();
        resultsUUID.add(uuid);
        ArrayList<String> paths = new ArrayList<>();
        paths.add(path);
        ExecutorInfo executorInfo = new ExecutorInfo()
                .setBuildName(path);
        ReportSpec reportSpec = new ReportSpec().setPath(paths)
                .setExecutorInfo(executorInfo);
        return new ReportGenerateRequest()
                .setResults(resultsUUID)
                .setReportSpec(reportSpec)
                .setDeleteResults(false);
    }

}
