package com.dt.platform.constants.enums.ops;


import com.github.foxnic.api.constant.CodeTextEnum;

public enum OpsCmdbAttributeValueFillColumnEnum implements CodeTextEnum {
    s1("s1", "字符串(50)1"),
    s2("s1", "字符串(50)2"),
    s3("s1", "字符串(50)3"),
    s4("s1", "字符串(50)4"),
    s5("s1", "字符串(50)5"),
    s6("s1", "字符串(50)6"),
    s7("s1", "字符串(50)7"),
    s8("s1", "字符串(50)8"),
    m1("m1", "字符串(200)1"),
    m2("m2", "字符串(200)2"),
    m3("m3", "字符串(200)3"),
    m4("m4", "字符串(200)4"),
    m5("m5", "字符串(200)5"),
    m6("m6", "字符串(200)6"),
    m7("m7", "字符串(200)7"),
    m8("m8", "字符串(200)8"),
    m9("m9", "字符串(200)9"),
    m10("m10", "字符串(200)10"),
    i1("i1", "数整1"),
    i2("i2", "数整2"),
    i3("i3", "数整3"),
    i4("i4", "数整4"),
    i5("i5", "数整5"),
    i6("i6", "数整6"),
    i7("i7", "数整7"),
    i8("i8", "数整8"),
    i9("i9", "数整9"),
    i10("i10", "数整10"),
    d1("d1", "浮点1"),
    d2("d2", "浮点2"),
    d3("d3", "浮点3"),
    d4("d4", "浮点4"),
    d5("d5", "浮点5"),
    d6("d6", "浮点6"),
    d7("d7", "浮点7"),
    d8("d8", "浮点8");
    private String code;
    private String text;
    private OpsCmdbAttributeValueFillColumnEnum(String code, String text)  {
        this.code=code;
        this.text=text;
    }

    public String code() {
        return code;
    }

    public String text() {
        return text;
    }


}
