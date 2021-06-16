package pers.ocean.mapstructdemo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ocean_wll
 * @date 2021/6/15
 */
@Data
@Accessors(chain = true)
public class UserVO {
    private Long id;
    private String userName;
    private String password;
    private Integer gender;
    private LocalDate birthday;
    private String createTime;
    private List<UserConfig> config;
    private String test;

    @Data
    public static class UserConfig {
        private String field1;
        private Integer field2;
    }
}
