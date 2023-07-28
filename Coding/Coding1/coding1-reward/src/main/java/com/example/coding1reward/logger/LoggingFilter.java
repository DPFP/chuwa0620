package com.example.coding1reward.logger;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

// https://gainjavaknowledge.medium.com/logging-request-and-response-body-in-spring-boot-b108de01ce7e
// For Logging Request and Response Body

@Component
public class LoggingFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        filterChain.doFilter(requestWrapper, responseWrapper);

        String requestBody = getStringValue(requestWrapper.getContentAsByteArray(), request.getCharacterEncoding());
        String responseBody = getStringValue(responseWrapper.getContentAsByteArray(), response.getCharacterEncoding());
        logger.info(
                "Finishing processing: Method = {}; Request URI = {}; Request Payload = {}; Response Code = {}; Response = {};",
                request.getMethod(), request.getRequestURI(), requestBody, response.getStatus(), responseBody
        );
        responseWrapper.copyBodyToResponse();
    }

    private String getStringValue(byte[] contentAsByteArray, String characterCoding) throws UnsupportedEncodingException {
        return new String(contentAsByteArray, 0, contentAsByteArray.length, characterCoding);
    }
}
