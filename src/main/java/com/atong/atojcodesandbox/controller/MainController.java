package com.atong.atojcodesandbox.controller;

import com.atong.atojcodesandbox.model.ExecuteCodeRequest;
import com.atong.atojcodesandbox.model.ExecuteCodeResponse;
import com.atong.atojcodesandbox.service.impl.JavaDockerTemplateImpl;
import com.atong.atojcodesandbox.service.impl.JavaNativeTemplateImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController("/")
public class MainController {

    // 定义鉴权请求头和密钥
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";

    @Resource
    private JavaNativeTemplateImpl javaNativeTemplate;

    @Resource
    private JavaDockerTemplateImpl javaDockerTemplate;

    @GetMapping("/health")
    public String healthCheck(){
        return "ok";
    }


    @PostMapping("/executeCode")
    ExecuteCodeResponse executeCode(@RequestBody ExecuteCodeRequest executeCodeRequest, HttpServletRequest request, HttpServletResponse response){
        String authHeader = request.getHeader(AUTH_REQUEST_HEADER);
        if (!AUTH_REQUEST_SECRET.equals(authHeader)){
            response.setStatus(403);
            return null;
        }
        if (executeCodeRequest == null){
            throw new RuntimeException("请求参数为空");
        }
        return javaNativeTemplate.executeCode(executeCodeRequest);
    }
}
