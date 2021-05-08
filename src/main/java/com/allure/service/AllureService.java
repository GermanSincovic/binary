package com.allure.service;

import com.allure.models.ReportGenerateRequest;
import com.allure.models.ReportResponse;
import com.allure.models.ResultResponse;
import com.allure.models.UploadResponse;
import com.allure.utils.JsonUtils;
import com.allure.utils.ResponseInfo;

public class AllureService {

    //    TODO: need to implement

    private final AllureAPI allureAPI = new AllureAPI();

    public ResultResponse[] getAllResults(){
        ResponseInfo response = allureAPI.getAllResults();
        return JsonUtils.toObject(response.getRawBody(), ResultResponse[].class);
    }

    public ResultResponse getResultByUUID(String uuid){
        return null;
    }

    public UploadResponse postResultFile(String filename){
        ResponseInfo response = allureAPI.postResultFile(filename);
        return JsonUtils.toObject(response.getRawBody(), UploadResponse.class);
    }

    public ResultResponse[] deleteAllResults(){
        return null;
    }

    public ResultResponse deleteResultByUUID(String uuid){
        return null;
    }

    //    TODO: need to implement

    public ReportResponse[] getReports(){
        return null;
    }

    public ReportResponse getReport(String path){
        return null;
    }

    public ReportResponse generateReport(ReportGenerateRequest requestData){
        return null;
    }

    public ReportResponse[] deleteAllReports(){
        return null;
    }

    public ReportResponse[] deleteAllReports(String seconds){
        return null;
    }

    public ReportResponse[] deleteHistoryReports(){
        return null;
    }

}
