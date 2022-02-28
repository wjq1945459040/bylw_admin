package com.wjq.bylw.oss.controller;

import com.wjq.bylw.common.result.Result;
import com.wjq.bylw.oss.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wjq
 * @date 2022/02/26 23:11
 **/

@Api(tags = "阿里云oss操作")
@RestController
@RequestMapping("/api/oss/file")
public class FileApiController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传")
    @PostMapping("fileUpload")
    public Result fileUpload(MultipartFile file) {
        String url = fileService.fileUpload(file);
        return Result.ok(url);
    }

}
