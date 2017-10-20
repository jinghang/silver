package hang.silver.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 带有分页功能的API返回值
 * @param <T>
 */
@ApiModel("带有分页功能的API返回值")
public class ApiPageResult<T> extends ApiResult<T> {

	@ApiModelProperty("第几个分页，从1开始计数")
	public int page_index;

	@ApiModelProperty("每个分页有多少条数据")
	public int page_size;

	@ApiModelProperty("总共有多少个分页")
	public int total_page_count;

	@ApiModelProperty("总共有多少条记录")
	public int total_item_count;

	public int getPage_index() {
		return page_index;
	}

	public void setPage_index(int page_index) {
		this.page_index = page_index;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public int getTotal_page_count() {
		return total_page_count;
	}

	public void setTotal_page_count(int total_page_count) {
		this.total_page_count = total_page_count;
	}

	public int getTotal_item_count() {
		return total_item_count;
	}

	public void setTotal_item_count(int total_item_count) {
		this.total_item_count = total_item_count;
	}
}
