package com.larkea.openapi.exception;

import com.larkea.boot.core.result.ResultCode;

public enum LarkeaResultCode implements ResultCode {
    UPLOAD_FILE_ERROR(LarkeaResultCode.UPLOAD_FILE_ERROR_CODE, "上传文件失败"),
    UPLOAD_FILE_SIZE_TOO_LARGE(LarkeaResultCode.UPLOAD_FILE_SIZE_TOO_LARGE_CODE, "上传文件过大"),
    UPLOAD_FILE_NAME_FORBIDDEN(LarkeaResultCode.UPLOAD_FILE_NAME_FORBIDDEN_CODE, "上传文件名称非法"),
    UPLOAD_FILE_TYPE_FORBIDDEN(LarkeaResultCode.UPLOAD_FILE_TYPE_FORBIDDEN_CODE, "上传文件类型不允许"),
    UPLOAD_FILE_EMPTY(LarkeaResultCode.UPLOAD_FILE_EMPTY_CODE, "上传大小不能为空"),

    ACCESS_KEY_LOGIN_FAILED(LarkeaResultCode.ACCESS_KEY_LOGIN_FAILED_CODE, "密钥错误"),

    PRODUCT_GW_NET_TYPE_MISSED(LarkeaResultCode.PRODUCT_GW_NET_TYPE_MISSED_CODE, "缺少连接网关方式"),
    PRODUCT_NET_TYPE_MISSED(LarkeaResultCode.PRODUCT_NET_TYPE_MISSED_CODE, "缺少连网方式"),
    PRODUCT_NOT_FOUND(LarkeaResultCode.PRODUCT_NOT_FOUND_CODE, "产品不存在"),

    THING_MODEL_BOOL_KEY_ERROR(LarkeaResultCode.THING_MODEL_BOOL_KEY_ERROR_CODE, "布尔类型值错误，只能为0或1"),
    THING_MODEL_PROPERTIES_ILLEGAL(LarkeaResultCode.THING_MODEL_PROPERTIES_ILLEGAL_CODE, "属性值非法"),

    DEVICE_KEY_EXISTED(LarkeaResultCode.DEVICE_KEY_EXISTED_CODE, "DeviceKey 已经存在"),
    DEVICE_NOT_FOUND(LarkeaResultCode.DEVICE_NOT_FOUND_CODE, "设备不存在"),

    TOPIC_NAME_ILLEGAL(LarkeaResultCode.TOPIC_NAME_ILLEGAL_CODE, "主题非法"),

    USER_REGISTER_FAILED(LarkeaResultCode.USER_REGISTER_FAILED_CODE, "注册失败"),
    USER_REGISTER_RATELIMIT(LarkeaResultCode.USER_REGISTER_RATELIMIT_CODE, "尝试注册次数达到上限"),
    USER_NOT_FOUND(LarkeaResultCode.USER_NOT_FOUND_CODE, "用户不存在"),
    USER_DISABLED(LarkeaResultCode.USER_DISABLED_CODE, "账号已停用"),
    USER_LOGIN_FAILED(LarkeaResultCode.USER_LOGIN_FAILED_CODE, "用户名或者密码错误"),
    USER_LOGIN_RATELIMIT(LarkeaResultCode.USER_LOGIN_RATELIMIT_CODE, "尝试登录次数达到上限"),
    USER_USERNAME_EXISTED(LarkeaResultCode.USER_USERNAME_EXISTED_CODE, "用户名已存在"),
    USER_EMAIL_EXISTED(LarkeaResultCode.USER_EMAIL_EXISTED_CODE, "邮箱已存在"),
    USER_MOBILE_EXISTED(LarkeaResultCode.USER_MOBILE_EXISTED_CODE, "手机号已存在"),
    ;

    /**
     * 上传文件错误码
     */
    public static final int UPLOAD_FILE_ERROR_CODE = 100200;

    public static final int UPLOAD_FILE_SIZE_TOO_LARGE_CODE = 100201;

    public static final int UPLOAD_FILE_NAME_FORBIDDEN_CODE = 100202;

    public static final int UPLOAD_FILE_TYPE_FORBIDDEN_CODE = 100203;

    public static final int UPLOAD_FILE_EMPTY_CODE = 100204;

    /**
     * 密钥错误码
     */
    public static final int ACCESS_KEY_LOGIN_FAILED_CODE = 100300;

    /**
     * 产品
     */
    public static final int PRODUCT_GW_NET_TYPE_MISSED_CODE = 100400;

    public static final int PRODUCT_NET_TYPE_MISSED_CODE = 100401;

    public static final int PRODUCT_NOT_FOUND_CODE = 100402;

    /**
     * 物模型
     */
    public static final int THING_MODEL_BOOL_KEY_ERROR_CODE = 100500;

    public static final int THING_MODEL_PROPERTIES_ILLEGAL_CODE = 100501;

    /**
     * 设备
     */
    public static final int DEVICE_KEY_EXISTED_CODE = 100600;

    public static final int DEVICE_NOT_FOUND_CODE = 100601;

    /**
     * 主题
     */
    public static final int TOPIC_NAME_ILLEGAL_CODE = 100700;

    /**
     * 用户相关错误码
     */
    public static final int USER_REGISTER_FAILED_CODE = 100900;

    public static final int USER_REGISTER_RATELIMIT_CODE = 100901;

    public static final int USER_LOGIN_FAILED_CODE = 100902;

    public static final int USER_LOGIN_RATELIMIT_CODE = 100903;

    public static final int USER_NOT_FOUND_CODE = 100904;

    public static final int USER_DISABLED_CODE = 100905;

    public static final int USER_USERNAME_EXISTED_CODE = 100907;

    public static final int USER_EMAIL_EXISTED_CODE = 100908;

    public static final int USER_MOBILE_EXISTED_CODE = 100909;

    final int code;

    final String message;

    LarkeaResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
