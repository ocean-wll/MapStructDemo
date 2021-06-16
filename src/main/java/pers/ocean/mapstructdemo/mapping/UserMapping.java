package pers.ocean.mapstructdemo.mapping;

import com.alibaba.fastjson.JSON;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pers.ocean.mapstructdemo.model.User;
import pers.ocean.mapstructdemo.vo.UserVO;

import java.util.List;

/**
 * @author ocean_wll
 * @date 2021/6/15
 */
@Mapper(componentModel = "spring")
public interface UserMapping extends BaseMapping<User, UserVO> {

    @Mapping(target = "gender", source = "sex")
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    UserVO source2Target(User var1);

    @Mapping(target = "sex", source = "gender")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Override
    User target2Source(UserVO var1);

    default List<UserVO.UserConfig> strConfigToListUserConfig(String config) {
        return JSON.parseArray(config, UserVO.UserConfig.class);
    }

    default String listUserConfigToStrConfig(List<UserVO.UserConfig> list) {
        return JSON.toJSONString(list);
    }
}
