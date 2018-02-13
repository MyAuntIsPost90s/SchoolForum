package schoolforumroom.controllers;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Users;
import schoolforumroom.services.VoteUsersService;

@Controller
@RequestMapping("VoteUsers")
public class VoteUsersController {
	@Resource
	private VoteUsersService voteUsersService;

	/**
	 * 是否投过票了
	 * 
	 * @param request
	 * @param response
	 * @param voteid
	 */
	@ResponseBody
	@RequestMapping("Exist")
	public void exist(HttpServletRequest request, HttpServletResponse response, String voteid) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			boolean result = voteUsersService.exist(users.getUserid(), voteid);
			requestHolder.success(result);
		} catch (Exception e) {
			requestHolder.err(e);
		}
	}

	/**
	 * 投票
	 * 
	 * @param request
	 * @param response
	 * @param voteid
	 * @param votefield
	 */
	@ResponseBody
	@RequestMapping("Vote")
	public void vote(HttpServletRequest request, HttpServletResponse response, String voteid, String votefield) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			voteUsersService.vote(users.getUserid(), voteid, votefield);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
