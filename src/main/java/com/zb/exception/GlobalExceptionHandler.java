package com.zb.exception;

import com.zb.common.ExceptionCode;
import com.zb.common.JsonMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bzheng on 2019/1/30.
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

        private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

        @ResponseBody
        @ExceptionHandler({MissingServletRequestParameterException.class, TypeMismatchException.class})
        public JsonMessage<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException e1, TypeMismatchException e2) {
            return new JsonMessage<>(ExceptionCode.PARAM_ERROR_CODE, ExceptionCode.PARAM_ERROR_MSG);
        }

        @ResponseBody
        @ExceptionHandler({MethodArgumentNotValidException.class})
        public JsonMessage<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
            logger.info(e.getMessage());
            return new JsonMessage<>(ExceptionCode.PARAM_ERROR_CODE, ExceptionCode.PARAM_ERROR_MSG);
        }

        @ResponseBody
        @ExceptionHandler({IllegalArgumentException.class})
        public JsonMessage<Object> handleIllegalArgumentException(IllegalArgumentException e) {
            logger.info(e.getMessage());
            return new JsonMessage<>(ExceptionCode.PARAM_ERROR_CODE, e.getMessage());
        }


        @ResponseBody
        @ResponseStatus(HttpStatus.UNAUTHORIZED)
        @ExceptionHandler(UnauthenticatedException.class)
        public JsonMessage<Object> handleUnauthenticatedException(UnauthenticatedException e) {
            logger.info("*************未登录或会话过期*********");
            return new JsonMessage<>(ExceptionCode.NOT_LOGIN_CODE, e.getMessage());
        }

        /**
         * 处理其他异常
         *
         * @return
         */
        @ResponseBody
        @ExceptionHandler(Exception.class)
        public JsonMessage<Object> handleException(Exception e) {
            logger.error(e.getMessage(), e);
            return new JsonMessage<>(ExceptionCode.SYS_ERROR_CODE, ExceptionCode.SYS_ERROR_MSG);
        }
}
