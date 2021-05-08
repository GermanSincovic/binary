package com.allure.service;

import com.allure.Config;
import com.allure.models.ReportGenerateRequest;
import com.allure.utils.HttpHelper;
import com.allure.utils.RequestInfo;
import com.allure.utils.RequestTypeEnum;
import com.allure.utils.ResponseInfo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AllureAPI {

    private static final String HOST = Config.HOST;

    private static final String RESULTS_PATH = "/api/result";
    private static final String REPORTS_PATH = "/api/report";
    private static final String REPORTS_HISTORY_PATH = "/api/report/history";


//    RESULTS


    public ResponseInfo getAllResults() {
        String URL = String.format("%s%s", HOST, RESULTS_PATH);
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.GET);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo getResultByUUID(String uuid) {
        String URL = String.format("%s%s/%s", HOST, RESULTS_PATH, uuid);
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.GET);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo postResultFile(String fileName) {
        String URL = String.format("%s%s", HOST, RESULTS_PATH);
        File file = new File(fileName);
        System.out.println(file.getAbsolutePath());
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.POST, null, new File(file.getAbsolutePath()));
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo deleteAllResults() {
        String URL = String.format("%s%s", HOST, RESULTS_PATH);
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.DELETE);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo deleteResultByUUID(String uuid) {
        String URL = String.format("%s%s/%s", HOST, RESULTS_PATH, uuid);
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.DELETE);
        return HttpHelper.makeCall(requestInfo);
    }


//    REPORTS


    public ResponseInfo getReports() {
        return getReports(null);
    }

    public ResponseInfo getReports(String path) {
        String URL = String.format("%s%s", HOST, REPORTS_PATH);
        if (path != null)
            URL = URL + "?path=" + path;
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.GET);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo postGenerateReport(ReportGenerateRequest params) {
        String URL = String.format("%s%s", HOST, REPORTS_PATH);
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-type", "application/json");
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.DELETE, headers);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo deleteAllReports() {
        return deleteAllReports(null);
    }

    public ResponseInfo deleteAllReports(Integer seconds) {
        String URL = String.format("%s%s", HOST, REPORTS_PATH);
        if (seconds != null)
            URL = URL + "?seconds=" + seconds;
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.DELETE);
        return HttpHelper.makeCall(requestInfo);
    }

    public ResponseInfo deleteHistoryReports() {
        String URL = String.format("%s%s", HOST, REPORTS_HISTORY_PATH);
        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.DELETE);
        return HttpHelper.makeCall(requestInfo);
    }

}
