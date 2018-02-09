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
import schoolforum.base.models.Articlefeedbacks;
import schoolforum.base.models.Users;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ArticleFeedbacksService;

@Controller
@RequestMapping("ArticleFeedbacks")
public class ArticleFeedbacksController {

	@Resource
	private ArticleFeedbacksService articleFeedbacksService;

	/**
	 * 添加回复
	 * 
	 * @param request
	 * @param response
	 * @param articlefeedbacks
	 */
	@ResponseBody
	@RequestMapping("Add")
	public void add(HttpServletRequest request, HttpServletResponse response, Articlefeedbacks articlefeedbacks) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			articlefeedbacks.setFromuserid(user.getUserid());
			articleFeedbacksService.add(articlefeedbacks);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 获取反馈列表
	 * 
	 * @param request
	 * @param response
	 * @param articlefeedbacks
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, Articlefeedbacks articlefeedbacks,
			int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Articlefeedbacks> list = articleFeedbacksService.getListByPage(articlefeedbacks, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取列表失败", e);
		}
	}

	/**
	 * 获取回复周排行
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 */
	@ResponseBody
	@RequestMapping("WeekTopList")
	public void weekTopList(HttpServletRequest request, HttpServletResponse response, int page, int rows) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Articlefeedbacks> list = articleFeedbacksService.getWeekTop(page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取列表失败", e);
		}
	}

	/**
	 * 删除回复
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
			articleFeedbacksService.delete(ids);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
}
