package hang.silver.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.UUID;

/**
 * 服务层基类
 * @author hang
 *
 */
public abstract class BaseService {

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
	public BaseService(){
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}

	protected String newId() {
		return UUID.randomUUID().toString().replace("-","");
	}

}
