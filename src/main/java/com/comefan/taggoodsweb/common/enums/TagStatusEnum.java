package com.comefan.taggoodsweb.common.enums;

public enum TagStatusEnum {
    USE(1, "使用中"),
    DELETE(2, "已删除"),
    EXPIRE(3, "已过期");
    private Integer code;
    private String name;
    TagStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    public Integer getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public static TagStatusEnum getEnum(Integer code) {
        for (TagStatusEnum e : TagStatusEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
