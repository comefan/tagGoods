package com.comefan.taggoodsweb.controller.vo;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    /**
     * 获取成功响应
     * @param clazz 响应类
     * @param <U> 响应类类型
     * @return 成功响应
     */
    public static <U extends BaseResponse> U getSuccessResponse(Class<U> clazz){
        try {
            U u = clazz.newInstance();
            u.setCode(0);
            u.setMessage("success,请求成功！");
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取失败响应
     * @param clazz 响应类
     * @param message 失败信息
     * @param <U> 响应类类型
     * @return 失败响应
     */
    public static <U extends BaseResponse> U getFailResponse(Class<U> clazz, String message){
        try {
            U u = clazz.newInstance();
            u.setCode(1);
            u.setMessage(message);
            return u;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
