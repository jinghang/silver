package hang.silver.service;

import hang.silver.repo.UserInfo;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 */
@Service
public class UserService extends BaseService{

	public UserInfo get(){
		UserInfo userInfo = new UserInfo();
		userInfo.setName("Hello");
		return userInfo;
	}
}
