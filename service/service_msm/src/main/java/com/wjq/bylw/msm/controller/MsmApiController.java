package com.wjq.bylw.msm.controller;

import com.wjq.bylw.common.result.Result;
import com.wjq.bylw.msm.service.MsmService;
import com.wjq.bylw.msm.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wjq
 * @date 2022/02/25 22:33
 **/

@Api(tags = "短信登录")
@RestController
@RequestMapping("/api/msm")
public class MsmApiController {
    @Autowired
    private MsmService msmService;

    @Autowired
    private RedisTemplate redisTemplate;

    @ApiOperation(value = "发送短信验证码")
    @GetMapping("send/{phone}")
    public Result sendCode(@PathVariable String phone) {

        //先看看redis
        String code = (String) redisTemplate.opsForValue().get("phone");

        if (!StringUtils.isEmpty(code)) {
            return Result.ok();
        }

        code = RandomUtil.getSixBitRandom();
        //发送
        boolean isSend = msmService.send(phone, code);
        if (isSend) {
            redisTemplate.opsForValue().set(phone, code, 2, TimeUnit.MINUTES);
            return Result.ok();
        }

        return Result.fail().message("发送短信失败");
    }
}
