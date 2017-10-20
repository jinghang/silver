package hang.silver.webapi.controller;

import hang.silver.common.ApiResult;
import hang.silver.common.ApiResultCode;
import hang.silver.repo.UserInfo;
import hang.silver.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController extends BaseController {

	@GetMapping("/")
	public ApiResult<UserInfo> get(){
		UserService service = new UserService();
		UserInfo userInfo = service.get();

		return result(ApiResultCode.OK,"成功", userInfo);
	}
}
