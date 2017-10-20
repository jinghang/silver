package hang.silver.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("API返回值")
public class ApiResult<T> {

	/**
	 * 状态码
	 */
	@ApiModelProperty(value="状态码")
	private ApiResultCode code;
	/**
	 * 返回的消息字符串
	 */
	@ApiModelProperty(value="返回的消息字符串")
	private String message;
	/**
	 * 异常
	 */
	@ApiModelProperty(value="异常名称")
	private String exception;
	/**
	 * 访问路径
	 */
	@ApiModelProperty(value="访问路径")
	private String path;

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 返回的数据
	 */
	@ApiModelProperty(value="返回的数据")
	private T data;

	public ApiResultCode getCode() {
		return code;
	}

	public void setCode(ApiResultCode code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
