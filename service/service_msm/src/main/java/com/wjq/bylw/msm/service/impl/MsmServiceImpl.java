package com.wjq.bylw.msm.service.impl;

import com.wjq.bylw.msm.service.MsmService;
import com.wjq.bylw.msm.utils.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wjq
 * @date 2022/02/25 22:33
 **/

@Service
@Slf4j
public class MsmServiceImpl implements MsmService {

    @Override
    public boolean send(String phone, String code) {

        if (StringUtils.isEmpty(phone)) {
            return false;
        }

        String host = "https://dfsns.market.alicloudapi.com";
        String path = "/data/send_sms";
        String method = "POST";
        String appcode = "f79a2099c4364b8cbb5c7ec13014ab5f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("content", "code:" + code);
        bodys.put("phone_number", phone);
        bodys.put("template_id", "TPL_0000");
        try {
            HttpUtil.doPost(host, path, method, headers, querys, bodys);
            return true;
        }
        catch (Exception e) {
            log.info(e.getMessage());
            return false;
        }
    }
}
