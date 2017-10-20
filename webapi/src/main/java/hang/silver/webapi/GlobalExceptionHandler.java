package hang.silver.webapi;

import hang.silver.common.ApiResult;
import hang.silver.common.ApiResultCode;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 */
@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	@ExceptionHandler(value = {Throwable.class})
	@ResponseBody
	public ApiResult<Object> jsonErrorHandler(HttpServletRequest req, HttpServletResponse res, Exception e){
		ApiResult<Object> r = new ApiResult<>();
		r.setCode(ApiResultCode.Failed);
		r.setMessage("全局异常:"+e.getMessage());
		r.setPath(req.getServletPath());
		r.setException(e.getClass().getName());
		res.setHeader("Access-Control-Allow-Origin", "*");
		return r;
	}

	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	@ResponseBody
	public ApiResult<Object> ValidExceptionHandler(HttpServletRequest req,  HttpServletResponse res, MethodArgumentNotValidException e){
		FieldError error = e.getBindingResult().getFieldError();


		ApiResult<Object> r = new ApiResult<>();
		r.setCode(ApiResultCode.Failed);
		r.setMessage("参数异常:"+error.getDefaultMessage());
		r.setPath(req.getServletPath());
		r.setException(e.getClass().getName());
		res.setHeader("Access-Control-Allow-Origin", "*");
		return r;
	}

	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	@ResponseBody
	public ApiResult<Object> DataIntegrityViolationExceptionHandler(HttpServletRequest req,  HttpServletResponse res, DataIntegrityViolationException e){

		String mString = "输入参数有误";

		Throwable throwable = e.getCause();
		if(throwable != null){
			mString+="，"+throwable.getMessage().replace(" at row 1", "");
		}

		ApiResult<Object> r = new ApiResult<>();
		r.setCode(ApiResultCode.Failed);
		r.setMessage(mString);
		r.setPath(req.getServletPath());
		r.setException(e.getClass().getName());
		res.setHeader("Access-Control-Allow-Origin", "*");
		return r;
	}
}
