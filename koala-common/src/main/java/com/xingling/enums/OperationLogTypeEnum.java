package com.xingling.enums;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * <p>Title:	  OperationLogTypeEnum. </p>
 * <p>Description 操作日志类型 </p>
 * <p>Company:    http://www.hnxianyi.com </p>
 *
 * @Author <a href="190332447@qq.com"/>杨文生</a>
 * @CreateDate 2017/4/19 11:30
 */
public enum OperationLogTypeEnum {
    DEFAULT("0", "DEFAULT"), // 默认值
    /** 用户管理-10 */
    /**
     * 创建用户
     */
    USER_CREATE("1002", "创建用户"),
    /**
     * 修改用户
     */
    USER_MODIFY("1003", "修改用户"),
    /**
     * 用户登录
     */
    USER_LOGIN("1004", "用户登录"),
    /**
     * 用户启用或禁用
     */
    USER_ENABLEORDISABLE("1005", "角色启用/禁用"),
    /**
     * 用户绑定角色
     */
    USER_ROLE_BIND("1006", "用户绑定角色"),

    /** 角色管理-20 */
    /**
     * 角色创建
     */
    ROLE_CREATE("2001", "角色创建"),
    /**
     * 角色修改
     */
    ROLE_EDIT("2002", "角色修改"),
    /**
     * 角色删除
     */
    ROLE_DEL("2003", "角色删除"),
    /**
     * 角色启用或禁用
     */
    ROLE_ENABLEORDISABLE("2004", "角色启用/禁用"),
    /**
     * 角色授权
     */
    ROLE_GRANT("2005", "角色授权"),
    /**
     * 角色绑定用户
     */
    ROLE_USER_BIND("2006", "角色绑定用户"),

    /** 菜单管理-30 */
    /**
     * 编辑菜单
     */
    MENU_EDIT("3002", "编辑菜单"),
    /** 菜单管理-30 */
    /**
     * 新增菜单
     */
    MENU_CREATE("3001", "创建菜单"),
    /**
     * 修改菜单状态
     */
    MENU_EDIT_ENABLE("3003", "修改菜单状态"),
    /**
     * 根据id删除菜单
     */
    MENU_DEL("3005", "根据id删除菜单"),
    /** 日志管理-40 */
    /** 组织管理-50 */


    /**
     * 新增组织
     */
    GROUP_CREATE("5001", "新增组织"),
    /**
     * 修改组织
     */
    GROUP_EDIT("5002", "修改组织"),
    /**
     * 逻辑删除组织
     */
    GROUP_DELETE("5003", "逻辑删除组织"),
    /**
     * 修改组织状态
     */
    GROUP_EDIT_STATUS("5004", "修改组织状态"),
    /**
     * 组织绑定用户
     */
    GROUP_BIND_USER("5005", "组织绑定用户"),

    /**
     * 审核通过运营用户的认证申请
     */
    OPERATE_USER_AUTH_PASS("6001", "审核通过运营用户的认证申请"),
    /**
     * 审核驳回运营用户的认证申请
     */
    OPERATE_USER_AUTH_REJECT("6002", "审核驳回运营用户的认证申请"),
    /**
     * 用户提交运营认证申请
     */
    OPERATE_USER_AUTH_ADD("6003", "用户提交运营认证申请"),
    /**
     * 用户再次提交运营认证申请
     */
    OPERATE_USER_AUTH_AGAIN("6003", "用户再次提交运营认证申请");


    String type;
    String name;

    OperationLogTypeEnum(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(String type) {
        for (OperationLogTypeEnum ele : OperationLogTypeEnum.values()) {
            if (ele.getType().equals(type))
                return ele.getName();
        }
        return null;
    }

    public static OperationLogTypeEnum getEnum(String type) {
        for (OperationLogTypeEnum ele : OperationLogTypeEnum.values()) {
            if (ele.getType().equals(type))
                return ele;
        }
        return OperationLogTypeEnum.DEFAULT;
    }

    public static List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (OperationLogTypeEnum ele : OperationLogTypeEnum.values()) {
            Map<String, Object> map = Maps.newHashMap();
            if (StringUtils.isEmpty(ele.getType()) || ele.getType().equals(OperationLogTypeEnum.DEFAULT.getType())) {
                continue;
            }
            map.put("key", String.valueOf(ele.getType()));
            map.put("value", ele.getName());
            list.add(map);
        }
        return list;
    }

}
