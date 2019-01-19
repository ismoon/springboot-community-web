package com.ismoon.community.domain.enums;

/**
 * @author ismoon on 2019-01-19
 */
public enum BoardType {
    notice("공지사항"),
    free("자유게시판");

    private String value;

    BoardType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
