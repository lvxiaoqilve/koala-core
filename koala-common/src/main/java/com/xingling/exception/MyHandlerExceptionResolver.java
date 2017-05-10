package com.xingling.exception;


import com.xingling.enums.ResultCodeEnum;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title:	  MyHandlerExceptionResolver. </p>
 * <p>Description 统一异常处理 </p>
 * <p>Company:    http://www.hnxianyi.com </p>
 *
 * @Author         <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate     2017/4/19 11:17
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    private Logger logger = LoggerFactory.getLogger(MyHandlerExceptionResolver.class);

    /**
     * 返回地址
     */
    private String defaultErrorView = "/error/error-500";

    public String getDefaultErrorView() {
        return defaultErrorView;
    }

    public void setDefaultErrorView(String defaultErrorView) {
        this.defaultErrorView = defaultErrorView;
    }

    /**
     * 最顶层的异常捕获
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {

        // 返回消息
        Map<String, String> model = new HashMap<>();

        String code = "";
        String errMsg = "";

        // 如果是自定义异常
        if (exception instanceof BusinessException) {
            BusinessException e = (BusinessException) exception;
            if (e.getCode() == null) {
                e = new BusinessException(ResultCodeEnum.GL000000.code(), exception.getMessage());
            }
            model.put("code", e.getCode());
            model.put("message", e.getMessage());
            errMsg = e.getMessage();
            logger.error(model.get("code") + ":" + e.getMessage(), exception);

            // 如果是其它异常
        } else {
            model.put("code", ResultCodeEnum.GL000000.code());
            model.put("message", ResultCodeEnum.GL000000.msg());
            model.put("cause", exception.toString());

            code = ResultCodeEnum.GL000000.code();
            errMsg = ResultCodeEnum.GL000000.msg();

            logger.error(model.get("code"), exception);
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        ResponseBody responseBody = AnnotationUtils.findAnnotation(method, ResponseBody.class);

        if (responseBody != null) {
            JSONObject json = new JSONObject();
            json.put("code", code);
            json.put("message", errMsg);
            try {
                response.setContentType("text/json; charset=UTF-8");
                response.setHeader("Cache-Control", "no-cache");
                PrintWriter out = response.getWriter();
                out.println(json.toString());
                out.flush();
            } catch (Exception e) {
                logger.error("", e);
            }
            return new ModelAndView();

        } else {
            return new ModelAndView(defaultErrorView, model);
        }
    }
}
