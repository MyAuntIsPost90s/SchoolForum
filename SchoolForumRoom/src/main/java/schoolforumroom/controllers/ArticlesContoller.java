package schoolforumroom.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Articles;
import schoolforum.base.models.Users;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ArticlesService;

@Controller
@RequestMapping("Articles")
public class ArticlesContoller {
	@Resource
	private ArticlesService articlesService;
	
	/**
	 * 单个话题
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void single(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(articlesService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 话题集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows, Articles articles) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Articles> list = articlesService.getListWithPage(articles, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}
	
	/**
	 * 话题修改
	 * 
	 * @param request
	 * @param response
	 * @param notices
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void update(HttpServletRequest request, HttpServletResponse response, Articles articles) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			articlesService.update(articles);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Articles articles) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users=(Users)requestHolder.getClientUser();
			articles.setArticleid(RandomNum.getAID());
			articles.setUserid(users.getUserid());
			articles.setArticletime(new Date());
			articlesService.add(articles);
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
			articlesService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
