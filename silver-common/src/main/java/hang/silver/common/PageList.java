package hang.silver.common;

import io.swagger.annotations.ApiModelProperty;

import java.util.LinkedList;

public class PageList<T> extends LinkedList<T> {

	private static final long serialVersionUID = -7247752803045225627L;

	/**
	 * 第几个分页，从1开始计数
	 */
	@ApiModelProperty("第几个分页，从1开始计数")
	private int page_index;

	/**
	 * 每个分页有多少条数据
	 */
	@ApiModelProperty("每个分页有多少条数据")
	private int page_size;

	/**
	 * 总共有多少个分页
	 */
	@ApiModelProperty("总共有多少个分页")
	private int total_page_count;

	/**
	 * 总共有多少条记录
	 */
	@ApiModelProperty("总共有多少条记录")
	private int total_item_count;

	public PageList(){
		//
	}

	/**
	 * 构造
	 * @param page_index 第几个分页
	 * @param page_size 每个分页条数
	 * @param total_count 中记录数
	 */
	public PageList(int page_index, int page_size, int total_count){
		this.page_index = page_index;
		this.page_size = page_size;
		this.total_item_count = total_count;
		this.total_page_count = (int)(total_count/page_size)+(total_count%page_size==0?0:1);
	}


	/**
	 * @return the page_index
	 */
	public int getPage_index() {
		return page_index;
	}

	/**
	 * @param page_index the page_index to set
	 */
	public void setPage_index(int page_index) {
		this.page_index = page_index;
	}

	/**
	 * @return the page_size
	 */
	public int getPage_size() {
		return page_size;
	}

	/**
	 * @param page_size the page_size to set
	 */
	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	/**
	 * @return the total_page_count
	 */
	public int getTotal_page_count() {
		return total_page_count;
	}

	/**
	 * @param total_page_count the total_page_count to set
	 */
	public void setTotal_page_count(int total_page_count) {
		this.total_page_count = total_page_count;
	}

	/**
	 * @return the total_item_count
	 */
	public int getTotal_item_count() {
		return total_item_count;
	}

	/**
	 * @param total_item_count the total_item_count to set
	 */
	public void setTotal_item_count(int total_item_count) {
		this.total_item_count = total_item_count;
	}
}
