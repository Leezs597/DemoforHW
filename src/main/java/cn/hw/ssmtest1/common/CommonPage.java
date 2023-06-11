package cn.hw.ssmtest1.common;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommonPage {
    private int page = 1;

    private int limit = 10;
}
