package com.wjq.bylw.model.user;

import com.baomidou.mybatisplus.annotation.*;
import com.wjq.bylw.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * UserInfo
 * </p>
 *
 * @author wjq
 * @since 2022-02-28
 */
@Data
@ApiModel(description = "UserInfo")
@TableName("user_info")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微信openid")
    @TableField("openid")
    private String openid;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private Integer age;

    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    private Date birthday;

    @ApiModelProperty(value = "个性签名")
    @TableField("signature")
    private String signature;

    @ApiModelProperty(value = "头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty(value = "邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty(value = "关注")
    @TableField("attention")
    private String attention;

    @ApiModelProperty(value = "粉丝")
    @TableField("fan")
    private String fan;

    @ApiModelProperty(value = "文章")
    @TableField("article")
    private String article;

    @ApiModelProperty(value = "群组")
    @TableField("groups")
    private String groups;

    @ApiModelProperty(value = "权限")
    @TableField("authority")
    private Integer authority;


    @ApiModelProperty(value = "状态（0：锁定 1：正常）")
    @TableField("status")
    private Integer status;
}

