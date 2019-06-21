package com.gjsyoung.zuul;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class UserFallbackProvider implements ZuulFallbackProvider{
    @Override
    public String getRoute() {
        return "SpringCloudTest-UserProvider";        //表明为哪个微服务提供回退
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;   //状态码
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return this.getStatusCode().value();    //数字状态码
            }

            @Override
            public String getStatusText() throws IOException {
                return this.getStatusCode().getReasonPhrase();  //状态文本
            }

            @Override
            public void close() {}


            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("用户微服务不可用，请稍后再试".getBytes());   //响应体
            }

            @Override
            public HttpHeaders getHeaders() {       //响应头设置
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mt = new MediaType("application","json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mt);
                return httpHeaders;
            }
        };
    }
}
