package com.projects.exam_management.Error;

import jakarta.persistence.Tuple;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;
import java.util.Map;
@Component
public class ExceptionHanding extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {

        Map<String,Object> errorAttributes = super.getErrorAttributes(webRequest,options);
        errorAttributes.put("customMessage","Something went wrong");
        errorAttributes.put("status",errorAttributes.get("error"));
        errorAttributes.put("success",false);
        errorAttributes.put("exception",errorAttributes.get("message"));
        errorAttributes.put("details", Arrays.asList(errorAttributes.get("massage")));
        errorAttributes.remove("path");
        errorAttributes.remove("timestamp");
        errorAttributes.remove("error");
        errorAttributes.remove("trace");
        return errorAttributes;
    }
}
