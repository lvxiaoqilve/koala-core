package com.xingling.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * <p>Title:	  ExceptionInterceptorLog. </p>
 * <p>Description 异常的处理 拦截 </p>
 * <p>Company:    http://www.hnxianyi.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/4/19 11:16
 */
public class ExceptionInterceptorLog implements ThrowsAdvice {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionInterceptorLog.class);

    /**
     * 对未知异常的处理. <br>
     * Method method 执行的方法 Object[] args <br>
     * 方法参数 Object target <br>
     * 代理的目标对象 Throwable BizException 产生的异常 <br>
     */
    public void afterThrowing(Method method, Object[] args, Object target, BusinessException ex) {

        logger.error("==>ExceptionInterceptorLog.BusinessException");
        logger.error("==>errCode:" + ex.getCode() + " errMsg:" + ex.getMessage());
        logger.error("==>" + ex.fillInStackTrace());
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {

        logger.error("==>ExceptionInterceptorLog.Exception");

        logger.error("==>Error class: " + target.getClass().getName());
        logger.error("==>Error method: " + method.getName());

        for (int i = 0; i < args.length; i++) {
            logger.error("==>args[" + i + "]: " + args[i]);
        }

        logger.error("==>Exception class: " + ex.getClass().getName());
        logger.error("==>" + ex.fillInStackTrace());
        logger.error("==> 堆栈信息{}", ex.toString(), ex);
    }

}
