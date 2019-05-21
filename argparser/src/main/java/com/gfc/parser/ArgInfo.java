package com.gfc.parser;

/**
 * @ClassName: ArgInfo
 * @Description:
 * @CreatedBy: xiaoguo
 * @CreatedAt: 2019/5/20 19:44
 **/
public class ArgInfo<T> {
    private T value;
    private String type;
    private String Description;

    public ArgInfo(T value, String type, String description) {
        this.value = value;
        this.type = type;
        this.Description = description;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
