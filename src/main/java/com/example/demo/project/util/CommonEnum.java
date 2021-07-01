package com.example.demo.project.util;


public enum CommonEnum implements ErrorInfo{
    SUCCESS("0","成功"),
    INTERNAL_PROBLEMS("5000","内部问题"),
    CHECK_NOT_PASS("5001","检验未通过");

    private String resultCode;
    private String resultMessage;

    CommonEnum(String resultCode, String stringesultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = stringesultMessage;
    }




    @Override
    public String getResultCode() {
        return this.resultCode;
    }

    @Override
    public String getResultInfo() {
        return this.resultMessage;
    }
}
