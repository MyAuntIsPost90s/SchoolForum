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
import schoolforum.base.models.Users;
import schoolforum.base.models.Votes;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.VotesService;

@Controller
@RequestMapping("Votes")
public class VotesController {

	@Resource
	private VotesService votesService;

	/**
	 * 单个投票
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void single(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(votesService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 投票集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows,
			Integer timetype) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Votes> list = votesService.getListByTimeType(timetype, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param notices
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void update(HttpServletRequest request, HttpServletResponse response, Votes votes) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			votesService.update(votes);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 添加
	 * 
	 * @param request
	 * @param response
	 * @param majors
	 */
	@ResponseBody
	@RequestMapping("Add")
	public void add(HttpServletRequest request, HttpServletResponse response, Votes votes) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			votes.setUserid(users.getUserid());
			votesService.add(votes);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param request
	 * @param response
	 * @param ids
	 */
	@ResponseBody
	@RequestMapping("BatchDelete")
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<String> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			votesService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
