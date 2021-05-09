package com.allure;

import com.allure.base.BaseTest;
import com.allure.models.ReportResponse;
import com.allure.models.ResultResponse;
import com.allure.models.UploadResponse;
import com.allure.utils.Reporter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EndToEndTest extends BaseTest {

    @Test
    public void validFlowWithDeletionAllReports() {

        Reporter.info("Uploading new .zip file with results...");
        UploadResponse uploadResponse = ALLURE_SERVICE.uploadResultFile(TEST_FILENAME);
        Assert.assertNotNull(uploadResponse, "Response not received!");
        Reporter.path(String.format("File uploaded with UUID '%s'", uploadResponse.getUuid()));

        Reporter.info("Checking upload complete...");
        ResultResponse[] newResultResponses = ALLURE_SERVICE.getAllResults();
        Assert.assertEquals(Arrays.stream(newResultResponses).filter(r -> r.getUuid().equals(uploadResponse.getUuid())).count(), 1, "New results not found!");
        Assert.assertEquals(newResultResponses.length, INITIAL_RESULTS.length + 1, "Results total count failed!");
        Reporter.path(String.format("Results contains one new item - %s", uploadResponse.getUuid()));

        Reporter.info("Generating report...");
        ReportResponse reportResponse = ALLURE_SERVICE.generateReport(makeReportGenerateRequestData(uploadResponse.getUuid()));
        Assert.assertNotNull(reportResponse, "Response not received!");
        Reporter.path(reportResponse.toString());

        Reporter.info("Checking report generation complete...");
        ReportResponse[] newReportResponses = ALLURE_SERVICE.getReports();
        Assert.assertEquals(Arrays.stream(newReportResponses).filter(r -> r.getUuid().equals(reportResponse.getUuid())).count(), 1, "New report not found!");
        Assert.assertEquals(newReportResponses.length, INITIAL_REPORTS.length + 1, "Reports total count failed!");
        Reporter.path(String.format("Reports contains one new item - %s", reportResponse.getUuid()));

        Reporter.info("Deleting all reports...");
        ReportResponse[] deletionReportResponses = ALLURE_SERVICE.deleteAllReports();
        ReportResponse[] reportResponsesAfterDeletion = ALLURE_SERVICE.getReports();
        Assert.assertEquals(reportResponsesAfterDeletion.length, 0, "Reports total count failed!");
        Reporter.path(String.format("There is no reports with UUID '%s'", reportResponse.getUuid()));

        Reporter.info("Deleting result...");
        ResultResponse deletedResultResponse = ALLURE_SERVICE.deleteResultByUUID(uploadResponse.getUuid());
        Assert.assertEquals(deletedResultResponse.getUuid(), uploadResponse.getUuid(), "Response contains incorrect UUID!");
        Assert.assertNull(ALLURE_SERVICE.getResultByUUID(uploadResponse.getUuid()).getUuid(), "Result is not deleted!");
        Assert.assertEquals(ALLURE_SERVICE.getAllResults().length, INITIAL_RESULTS.length, "Results total count failed!");
        Reporter.path(String.format("There is no results with UUID '%s'", uploadResponse.getUuid()));
    }

}
