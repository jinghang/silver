package hang.silver.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("状态码")
public enum ApiResultCode {

	/**
	 * 成功
	 */
	@ApiModelProperty(value="成功")
	OK (0),
	/**
	 * 失败
	 */
	@ApiModelProperty(value="失败")
	Failed (1),
	/**
	 * 未找到资源
	 */
	@ApiModelProperty(value="未找到资源")
	NotFound(2),
	/**
	 * 未授权
	 */
	@ApiModelProperty(value="未授权")
	NotAuth(3),

	/**
	 * 下载
	 */
	@ApiModelProperty(value="下载")
	Download(4);

	private int value = 0;

	private ApiResultCode(int value){
		this.value = value;
	}

	public int value(){
		return this.value;
	}
}
