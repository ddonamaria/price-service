package com.company.priceservice.infrastructure.adapters.api;

import com.company.priceservice.infrastructure.exceptions.InvalidParameterException;
import org.springframework.web.context.request.NativeWebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class ApiUtil {
    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void validateAtLeastOneNotNull(Object... params) {
        if (params == null || params.length == 0 || Arrays.stream(params).allMatch(Objects::isNull)) {
            throw new InvalidParameterException("At least one parameter must not be null");
        }
    }
}
