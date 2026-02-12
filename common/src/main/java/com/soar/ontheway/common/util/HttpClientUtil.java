package com.soar.ontheway.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodySubscribers;
import java.nio.charset.StandardCharsets;

public class HttpClientUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static final HttpClient client = HttpClient.newHttpClient();

    public static <T>HttpResponse<T> sendAndParse(HttpRequest request, Class<T> responseType) {
        try {
            return client.send(request, responseInfo -> {
                return BodySubscribers.mapping(
                        BodySubscribers.ofString(StandardCharsets.UTF_8),
                        body -> {
                            try {
                                return objectMapper.readValue(body, responseType);
                            } catch (Exception e) {
                                throw new RuntimeException("解析响应失败: " + responseType.getSimpleName(), e);
                            }
                        }
                );
            });
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("请求失败: " + e.getMessage());
        }
    }
}