package com.xingling.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * <p>Title:	  BaseMapper. </p>
 * <p>Description 继承自己的MyMapper </p>
 * <p>Company:    http://www.hnxianyi.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/4/20 13:20
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //特别注意，该接口不能被扫描到，否则会出错
}
