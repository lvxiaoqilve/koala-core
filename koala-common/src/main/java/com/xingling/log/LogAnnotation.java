package com.xingling.log;

/**
 * <p>Title:	  LogAnnotation. </p>
 * <p>Description 操作日志 </p>
 * <p>Company:    http://www.hnxianyi.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/4/19 11:30
 */

import com.xingling.enums.LogTypeEnum;
import com.xingling.enums.OperationLogTypeEnum;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
    /** 日志类型 */
    LogTypeEnum logType() default LogTypeEnum.OPERATION_LOG;
    /** 业务类型 */
    OperationLogTypeEnum busType() default OperationLogTypeEnum.DEFAULT;
    /** 是否保存请求的参数 */
    boolean isSaveRequestData() default false;
    /** 是否保存响应的结果 */
    boolean isSaveResponseData() default false;
}
