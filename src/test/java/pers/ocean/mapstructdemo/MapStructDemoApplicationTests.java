package pers.ocean.mapstructdemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.ocean.mapstructdemo.mapping.UserMapping;
import pers.ocean.mapstructdemo.model.User;
import pers.ocean.mapstructdemo.vo.UserVO;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MapStructDemoApplication.class)
class MapStructDemoApplicationTests {

    @Resource
    private UserMapping userMapping;

    @Test
    public void tetDomain2DTO() {
        User user = new User()
                .setId(1L)
                .setUserName("ocean")
                .setSex(1)
                .setPassword("abc123")
                .setCreateTime(LocalDateTime.now())
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig("[{\"field1\":\"Test Field1\",\"field2\":500}]");
        UserVO userVo = userMapping.source2Target(user);
        System.out.println("User: " + user);
        System.out.println("UserVo: " + userVo);
    }

    @Test
    public void testDTO2Domain() {
        UserVO.UserConfig userConfig = new UserVO.UserConfig();
        userConfig.setField1("Test Field1");
        userConfig.setField2(500);

        UserVO userVo = new UserVO()
                .setId(1L)
                .setUserName("ocean")
                .setGender(2)
                .setCreateTime("2020-01-18 15:32:54")
                .setBirthday(LocalDate.of(1999, 9, 27))
                .setConfig(Collections.singletonList(userConfig));
        User user = userMapping.target2Source(userVo);
        System.out.println("UserVo: " + userVo);
        System.out.println("User: " + user);
    }

}
