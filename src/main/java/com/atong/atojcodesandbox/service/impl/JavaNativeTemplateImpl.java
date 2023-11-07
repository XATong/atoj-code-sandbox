package com.atong.atojcodesandbox.service.impl;

import com.atong.atojcodesandbox.model.ExecuteCodeRequest;
import com.atong.atojcodesandbox.model.ExecuteCodeResponse;
import com.atong.atojcodesandbox.service.JavaCodeSandboxTemplate;
import org.springframework.stereotype.Component;

/**
 * Java 原生代码沙箱实现(直接复用模板方法)
 */
@Component
public class JavaNativeTemplateImpl extends JavaCodeSandboxTemplate {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }

}
