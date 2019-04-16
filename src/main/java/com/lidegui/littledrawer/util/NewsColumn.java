package com.lidegui.littledrawer.util;

public enum NewsColumn {

    SOCIAL(0, "社会"),
    SCIENCE(1, "科技"),
    LIFE(2, "生活"),
    ENTERTAINMENT(3, "娱乐"),
    AGRICULTURAL(4, "农业"),
    INTERNATIONAL(5, "国际"),
    SPORTS(6, "体育");

    public int columnIndex;
    public String columnName;

    NewsColumn(int columnIndex, String columnName) {
        this.columnIndex = columnIndex;
        this.columnName = columnName;
    }
}
