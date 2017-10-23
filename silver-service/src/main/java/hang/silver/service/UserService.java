package hang.silver.service;

import hang.silver.repo.domain.UserInfo;
import hang.silver.repo.domain.UserInfoExample;
import hang.silver.repo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户信息
 */
@Service
public class UserService extends BaseService{

	@Autowired
	private UserInfoMapper userInfoMapper;

	public List<UserInfo> get(){
		UserInfoExample userInfoExample = new UserInfoExample();
		userInfoExample.createCriteria();
		return userInfoMapper.selectByExample(userInfoExample);
	}
}
