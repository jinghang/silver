package hang.silver.webapi.controller;

import hang.silver.common.ApiResult;
import hang.silver.common.ApiResultCode;
import hang.silver.repo.UserInfo;
import hang.silver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Api(value = "100 首页", tags = {"首页"})
@RequestMapping("api/home")
@RestController
public class HomeController extends BaseController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	@ApiOperation(value = "获取用户信息", notes = "这里是说明")
	public ApiResult<UserInfo> get(){

		UserInfo userInfo = userService.get();

		return result(ApiResultCode.OK,"成功", userInfo);
	}
}
