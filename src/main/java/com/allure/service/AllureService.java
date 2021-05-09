package com.allure.service;

import com.allure.models.ReportGenerateRequest;
import com.allure.models.ReportResponse;
import com.allure.models.ResultResponse;
import com.allure.models.UploadResponse;
import com.allure.utils.JsonUtils;

public class AllureService {

    //    RESULTS

    private final AllureAPI allureAPI = new AllureAPI();

    public ResultResponse[] getAllResults() {
        return JsonUtils.toObject(allureAPI.getAllResults().getRawBody(), ResultResponse[].class);
    }

    public ResultResponse getResultByUUID(String uuid) {
        return JsonUtils.toObject(allureAPI.getResultByUUID(uuid).getRawBody(), ResultResponse.class);
    }

    public UploadResponse uploadResultFile(String filename) {
        return JsonUtils.toObject(allureAPI.postResultFile(filename).getRawBody(), UploadResponse.class);
    }

    public ResultResponse[] deleteAllResults() {
        return JsonUtils.toObject(allureAPI.deleteAllResults().getRawBody(), ResultResponse[].class);
    }

    public ResultResponse deleteResultByUUID(String uuid) {
        return JsonUtils.toObject(allureAPI.deleteResultByUUID(uuid).getRawBody(), ResultResponse.class);
    }

    //    REPORTS

    public ReportResponse[] getReports() {
        return JsonUtils.toObject(allureAPI.getReports().getRawBody(), ReportResponse[].class);
    }

    public ReportResponse getReport(String path) {
        return JsonUtils.toObject(allureAPI.getReport(path).getRawBody(), ReportResponse.class);
    }

    public ReportResponse generateReport(ReportGenerateRequest requestData) {
        return JsonUtils.toObject(allureAPI.postGenerateReport(requestData).getRawBody(), ReportResponse.class);
    }

    public ReportResponse[] deleteAllReports() {
        return JsonUtils.toObject(allureAPI.deleteAllReports().getRawBody(), ReportResponse[].class);
    }

    public ReportResponse[] deleteAllReports(int seconds) {
        return JsonUtils.toObject(allureAPI.deleteAllReports(seconds).getRawBody(), ReportResponse[].class);
    }

    public ReportResponse[] deleteHistoryReports() {
        return JsonUtils.toObject(allureAPI.deleteHistoryReports().getRawBody(), ReportResponse[].class);
    }

}
