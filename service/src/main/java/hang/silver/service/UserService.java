package hang.silver.service;

import hang.silver.repo.UserInfo;

public class UserService {

	public UserInfo get(){
		UserInfo userInfo = new UserInfo();
		userInfo.setName("Hello");
		return userInfo;
	}
}
