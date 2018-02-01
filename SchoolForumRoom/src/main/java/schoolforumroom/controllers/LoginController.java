package schoolforumroom.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Users;
import schoolforumroom.services.LoginService;

@Controller
public class LoginController {
	@Resource
	LoginService loginService;

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping("LoginOut")
	public void outLogin(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);

		try {
			requestHolder.removeClientUser();
			response.sendRedirect("/SchoolForumRoom/login.html");
		} catch (Exception e) {
			requestHolder.fail(e.getMessage());
		}
	}

	/**
	 * 登陆接口
	 * 
	 * @param request
	 * @param response
	 * @param user
	 */
	@ResponseBody
	@RequestMapping("DoLogin")
	public void doLogin(HttpServletRequest request, HttpServletResponse response, Users user) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			StringBuffer outmsg = new StringBuffer();
			user = loginService.loginer(user, outmsg);
			if (user == null) {
				requestHolder.fail(outmsg.toString());
				return;
			}
			requestHolder.setClientUser(user);
			requestHolder.success(outmsg.toString(), user);
		} catch (Exception e) {
			requestHolder.err("登陆错误，请联系XXX", e);
		}
	}
}
