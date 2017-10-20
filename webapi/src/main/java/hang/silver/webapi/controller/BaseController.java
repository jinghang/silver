package hang.silver.webapi.controller;

import hang.silver.common.ApiPageResult;
import hang.silver.common.ApiResult;
import hang.silver.common.ApiResultCode;
import hang.silver.common.PageList;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseController {

	/**
	 * 当前的请求
	 */
	@Autowired
	private HttpServletRequest request;

	/**
	 * 日志
	 */
	protected Log log = LogFactory.getLog(this.getClass());

	/**
	 * 类型转换
	 */
	protected ModelMapper modelMapper = new ModelMapper();

	/**
	 * 构造
	 */
	public BaseController(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	/**
	 * 返回JSON格式的API结果
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	protected <T> ApiResult<T> result(ApiResultCode code, String msg, T data) {
		ApiResult<T> result = new ApiResult<>();
		result.setCode(code);
		result.setMessage(msg);
		result.setData(data);
		result.setPath(request.getServletPath());
		return result;
	}

	/**
	 * 返回带有分页数据的JSON格式的API结果
	 * @param code
	 * @param msg
	 * @param data
	 * @param total_item_count
	 * @param total_page_count
	 * @param page_index
	 * @param page_size
	 * @return
	 */
	protected <T> ApiPageResult<T> pageResult(
			ApiResultCode code,
			String msg,
			T data,
			int total_item_count,
			int total_page_count,
			int page_index,
			int page_size) {

		ApiPageResult<T> result = new ApiPageResult<>();
		result.setCode(code);
		result.setMessage(msg);
		result.setData(data);
		result.setPath(request.getServletPath());
		result.setTotal_item_count(total_item_count);
		result.setTotal_page_count(total_page_count);
		result.setPage_index(page_index);
		result.setPage_size(page_size);


		return result;
	}

	/**
	 * 返回带有分页的数据
	 * @param code
	 * @param msg
	 * @param pageList
	 * @return
	 */
	protected <T> ApiPageResult<List<T>> pageResult(
			ApiResultCode code,
			String msg,
			PageList<T> pageList
	) {

		int total_item_count = pageList==null?0:pageList.getTotal_item_count();
		int total_page_count = pageList==null?0:pageList.getTotal_page_count();
		int page_index = pageList == null ? 1 : pageList.getPage_index();
		int page_size = pageList == null ? 10 : pageList.getPage_size();

		ApiPageResult<List<T>> result = new ApiPageResult<>();
		result.setCode(code);
		result.setMessage(msg);
		result.setData(pageList);
		result.setPath(request.getServletPath());
		result.setTotal_item_count(total_item_count);
		result.setTotal_page_count(total_page_count);
		result.setPage_index(page_index);
		result.setPage_size(page_size);

		return result;
	}

	/**
	 * 返回异常结果
	 * @param e 异常对象
	 * @param message 错误信息
	 * @return JSON 格式的 API返回值
	 */
	protected <T extends Exception, T2> ApiResult<T2> exceptionResult(T e, String message){
		ApiResult<T2> r = new ApiResult<>();
		r.setCode(ApiResultCode.Failed);
		r.setMessage(message + " 异常信息:" +e.getMessage());
		r.setPath(request.getServletPath());
		r.setException(e.getClass().getName());

		return r;
	}
}
