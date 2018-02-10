package schoolforumroom.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Suggestionusers;
import schoolforum.base.models.Users;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.SuggestionUsersService;

@Controller
@RequestMapping("SuggestionUsers")
public class SuggestionUsersController {

	@Resource
	private SuggestionUsersService suggestionUsersService;

	/**
	 * 添加顶贴
	 * 
	 * @param request
	 * @param response
	 * @param suggestionusers
	 */
	@ResponseBody
	@RequestMapping("Add")
	public void add(HttpServletRequest request, HttpServletResponse response, Suggestionusers suggestionusers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			suggestionusers.setUserid(user.getUserid());
			suggestionUsersService.add(suggestionusers);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 修改顶贴
	 * 
	 * @param request
	 * @param response
	 * @param suggestionusers
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void update(HttpServletRequest request, HttpServletResponse response, Suggestionusers suggestionusers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			suggestionUsersService.update(suggestionusers);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取顶贴列表
	 * 
	 * @param request
	 * @param response
	 * @param suggestionusers
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, Suggestionusers suggestionusers,
			int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Suggestionusers> list = suggestionUsersService.getListByPage(suggestionusers, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取列表失败", e);
		}
	}
	
	/**
	 * 判断顶帖是否存在
	 * 
	 * @param request
	 * @param response
	 * @param suggestionusers
	 */
	@ResponseBody
	@RequestMapping("Exist")
	public void exist(HttpServletRequest request, HttpServletResponse response, Suggestionusers suggestionusers) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			suggestionusers.setUserid(user.getUserid());
			boolean bool = suggestionUsersService.exist(suggestionusers);
			requestHolder.success(bool);
		} catch (Exception e) {
			requestHolder.err("获取列表失败", e);
		}
	}

	/**
	 * 移除顶贴
	 * 
	 * @param request
	 * @param response
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("Delete")
	public void delete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			suggestionUsersService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("获取列表失败", e);
		}
	}
}
