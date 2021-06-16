package pers.ocean.mapstructdemo.mapping;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Stream;

/**
 * mapStruct 基类，s:源，t:目标
 *
 * @author ocean_wll
 * @date 2021/6/15
 */
@MapperConfig
public interface BaseMapping<S, T> {

    /**
     * source -> target
     * 映射同名属性
     *
     * @param source 源对象
     * @return 目标对象
     */
    @Mapping(target = "createTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    T source2Target(S source);

    /**
     * target -> source
     * 反向，映射同名属性
     *
     * @param target 目标对象
     * @return 源对象
     */
    @InheritInverseConfiguration(name = "sourceToTarget")
    S target2Source(T target);

    /**
     * 映射同名属性，集合形式
     *
     * @param sourceList 源集合
     * @return 目标数据
     */
    @InheritConfiguration(name = "sourceToTarget")
    List<T> sourceToTarget(List<S> sourceList);

    /**
     * 反向，映射同名属性，集合形式
     *
     * @param targetList 目标集合
     * @return 源集合
     */
    @InheritConfiguration(name = "targetToSource")
    List<S> targetToSource(List<T> targetList);

    /**
     * 映射同名属性，集合流形式
     *
     * @param stream 源数据流
     * @return 目标数据
     */
    List<T> sourceToTarget(Stream<S> stream);

    /**
     * 反向，映射同名属性，集合流形式
     *
     * @param stream 目标数据流
     * @return 源数据
     */
    List<S> targetToSource(Stream<T> stream);
}
