package com.example.demo.project.util;

import lombok.Data;

@Data
public class ResultBody {
    private String code;

    private String message;

    private Object data;

    public ResultBody() {
    }

    public ResultBody(ErrorInfo errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultInfo();
    }

    public static ResultBody success(){
        return success(null);
    }

    public static ResultBody success(Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.SUCCESS.getResultCode());
        resultBody.setMessage(CommonEnum.SUCCESS.getResultInfo());
        resultBody.setData(data);
        return resultBody;
    }

    /**
     * 这也是失败
     * */
    public static ResultBody success(String code,Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(code);
        resultBody.setMessage(null);
        resultBody.setData(data);
        return resultBody;
    }

    public static ResultBody error(ErrorInfo errorInfo){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(errorInfo.getResultCode());
        resultBody.setMessage(errorInfo.getResultInfo());
        resultBody.setData(null);
        return resultBody;
    }

    public static ResultBody error(String code,Object data){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(code);
        resultBody.setMessage(null);
        resultBody.setData(data);
        return resultBody;
    }

    public static ResultBody error(String code,String message){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(code);
        resultBody.setMessage(message);
        resultBody.setData(null);
        return resultBody;
    }

    public static ResultBody error(String message){
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(CommonEnum.INTERNAL_PROBLEMS.getResultCode());
        resultBody.setMessage(message);
        resultBody.setData(null);
        return resultBody;
    }
}
