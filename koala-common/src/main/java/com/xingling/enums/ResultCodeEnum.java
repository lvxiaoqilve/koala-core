package com.xingling.enums;
/**
 * 
 * <p>Title:	  ResultCodeEnum </p>
 * <p>Description 异常编码枚举 </p>
 * <p>Company:    http://www.hnxianyi.com  </p>
 * @Author        <a href="liu_zhaoming@sina.cn"/>刘兆明</a>
 * @CreateDate    2016年10月5日 上午11:23:53 <br/>
 * @version       
 * @since         JDK 1.7
 */
public enum ResultCodeEnum {
    GL000000("未知异常"),
    ;
    private String msg;

    ResultCodeEnum(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String msg() {
        return msg;
    }
    public String code() {
        return this.name();
    }
}
