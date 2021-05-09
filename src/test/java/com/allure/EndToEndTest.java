package com.allure;

import com.allure.base.BaseTest;
import com.allure.models.*;
import com.allure.utils.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EndToEndTest extends BaseTest {

    @Test
    public void test() {

        long testStartTimestamp = System.currentTimeMillis();

        String testFilename = "src/test/resources/allureResults.zip";

        Reporter.info("Uploading new .zip file with results...");
        UploadResponse uploadResponse = ALLURE_SERVICE.uploadResultFile(testFilename);
        Assert.assertNotNull(uploadResponse, "Response not received!");
        Reporter.path(String.format("File uploaded with UUID '%s'", uploadResponse.getUuid()));

        Reporter.info("Checking upload complete...");
        ResultResponse[] newResultResponses = ALLURE_SERVICE.getAllResults();
        Assert.assertEquals(Arrays.stream(newResultResponses).filter(r -> r.getUuid().equals(uploadResponse.getUuid())).count(), 1, "New results not found!");
        Assert.assertEquals(newResultResponses.length, INITIAL_RESULTS.length + 1, "Results total count failed!");
        Reporter.path(String.format("Results contains one new item - %s", uploadResponse.getUuid()));

        Reporter.info("Generating report...");
        String path = String.format("auto_%s", System.currentTimeMillis());
        ArrayList<String> resultsUUID = new ArrayList<>();
            resultsUUID.add(uploadResponse.getUuid());
        ArrayList<String> paths = new ArrayList<>();
            paths.add(path);
        ExecutorInfo executorInfo = new ExecutorInfo()
                .setBuildName(path);
        ReportSpec reportSpec = new ReportSpec().setPath(paths)
                .setExecutorInfo(executorInfo);
        ReportGenerateRequest request = new ReportGenerateRequest()
                .setResults(resultsUUID)
                .setReportSpec(reportSpec)
                .setDeleteResults(false);
        ReportResponse reportResponse = ALLURE_SERVICE.generateReport(request);
        Assert.assertNotNull(reportResponse, "Response not received!");
        Reporter.path(reportResponse.toString());

        Reporter.info("Checking report generation complete...");
        ReportResponse[] newReportResponses = ALLURE_SERVICE.getReports();
        Assert.assertEquals(Arrays.stream(newReportResponses).filter(r -> r.getUuid().equals(reportResponse.getUuid())).count(), 1, "New report not found!");
        Assert.assertEquals(newReportResponses.length, INITIAL_REPORTS.length + 1, "Reports total count failed!");
        Reporter.path(String.format("Reports contains one new item - %s", reportResponse.getUuid()));

        Reporter.info("Deleting last report by time...");
        long currentTimestamp = System.currentTimeMillis();
        int lastSeconds = (int)(currentTimestamp - testStartTimestamp)/1000*5;
        ReportResponse[] deletionReportResponses = ALLURE_SERVICE.deleteAllReports(lastSeconds);
        ReportResponse[] reportResponsesAfterDeletion = ALLURE_SERVICE.getReports();
        Assert.assertEquals(reportResponsesAfterDeletion.length, INITIAL_REPORTS.length, "Reports total count failed!");
        Reporter.path(String.format("There is no reports with UUID '%s'", reportResponse.getUuid()));

        Reporter.info("Deleting result...");
        ResultResponse deletedResultResponse = ALLURE_SERVICE.deleteResultByUUID(uploadResponse.getUuid());
        Assert.assertEquals(deletedResultResponse.getUuid(), uploadResponse.getUuid(), "Response contains incorrect UUID!");
        Assert.assertNull(ALLURE_SERVICE.getResultByUUID(uploadResponse.getUuid()).getUuid(), "Result is not deleted!");
        Assert.assertEquals(ALLURE_SERVICE.getAllResults().length, INITIAL_RESULTS.length, "Results total count failed!");
        Reporter.path(String.format("There is no results with UUID '%s'", uploadResponse.getUuid()));
    }


}
