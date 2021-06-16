package pers.ocean.mapstructdemo.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author ocean_wll
 * @date 2021/6/15
 */
@Data
@Accessors(chain = true)
public class User {
    private Long id;
    private String userName;
    private String password;
    private Integer sex;
    private LocalDate birthday;
    private LocalDateTime createTime;
    private String config;
    private String test;
}
