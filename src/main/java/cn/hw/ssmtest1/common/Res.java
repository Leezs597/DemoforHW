package cn.hw.ssmtest1.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Res<T>{
    private int code = 0;
    private String message = "SUCCESS";
    private T data;
}
