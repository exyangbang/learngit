package com.scenetec.upf.operation.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.core.env.Environment;

/**
 * @author luoxianjun@scenetec.com
 * 2018/7/9 下午7:48
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private final Environment env;

    @Autowired public GlobalExceptionHandler(Environment env) {
        this.env = env;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorResponse systemExceptionHandler(Exception e, HttpServletResponse response) {

        MethodArgumentNotValidException c = (MethodArgumentNotValidException) e;
        List<ObjectError> errors =c.getBindingResult().getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        pouplateExceptionResponse(response, errorMsg.toString());
        log.error(e.getMessage(), e);
        return ErrorResponse.of(errorMsg.toString(), ErrorCode.BSMCM001.name(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private void pouplateExceptionResponse(HttpServletResponse response, String errorMessage) {
        try {
            response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorMessage);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

	@ExceptionHandler(SystemRuntimeException.class)
	@ResponseBody
	public ErrorResponse systemExceptionHandler(SystemRuntimeException e, HttpServletResponse response) {

		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        String msg = env.getProperty(e.getCode().name());
        msg = MessageFormatter.arrayFormat(msg, e.getArgs()).getMessage();
        e.setMessage(msg);
        log.error(msg, e);
		return ErrorResponse.of(msg, e.getCode().name(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ErrorResponse systemExceptionHandler2(Exception e, HttpServletResponse response) {

        MethodArgumentNotValidException c = (MethodArgumentNotValidException) e;
        List<ObjectError> errors =c.getBindingResult().getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.forEach(x -> {
            if (errorMsg.length() > 0){
                errorMsg.append(";");
            }
            errorMsg.append(x.getDefaultMessage());
        });
        pouplateExceptionResponse(response, errorMsg.toString());
        log.error(e.getMessage(), e);
        return ErrorResponse.of(errorMsg.toString(), ErrorCode.BSMCM001.name(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
