package cn.hw.ssmtest1.dto;

import cn.hw.ssmtest1.common.CommonPage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminPageDto extends CommonPage {

    private String keyword;

}
