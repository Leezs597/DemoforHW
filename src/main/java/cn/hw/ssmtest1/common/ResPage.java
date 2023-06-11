package cn.hw.ssmtest1.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ResPage<T> {

    private Integer code = 0;

    private String msg = "SUCCESS";

    private Long count;

    private List<T> data;
}
