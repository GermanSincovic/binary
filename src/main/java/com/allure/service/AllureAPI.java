package com.allure.service;

import com.allure.Config;
import com.allure.models.DTO.ReportGenerateRequestParams;
import com.allure.utils.HttpHelper;
import com.allure.utils.RequestInfo;
import com.allure.utils.RequestTypeEnum;
import com.allure.utils.ResponseInfo;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import java.io.File;
import java.io.IOException;
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

    public ResponseInfo postResultFile(String textFileName) throws IOException {
        String URL = String.format("%s%s", HOST, RESULTS_PATH);
        FileBody fileBody = new FileBody(new File(textFileName), ContentType.DEFAULT_BINARY);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        builder.addPart("allureResults", fileBody);
        HttpEntity entity = builder.build();

        RequestInfo requestInfo = new RequestInfo(URL, RequestTypeEnum.POST, null, entity);
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

    public ResponseInfo postGenerateReport(ReportGenerateRequestParams params) {
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
