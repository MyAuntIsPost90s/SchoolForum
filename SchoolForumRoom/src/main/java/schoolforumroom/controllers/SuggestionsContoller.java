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
import schoolforum.base.models.Suggestions;
import schoolforum.base.models.Users;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.SuggestionsService;

@Controller
@RequestMapping("Suggestions")
public class SuggestionsContoller {
	
	@Resource
	private SuggestionsService suggestionsService;
	
	/**
	 * 单个建议
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void single(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(suggestionsService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 建议集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows, Suggestions suggestions) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Suggestions> list = suggestionsService.getListWithPage(suggestions, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}
	
	/**
	 * 建议修改
	 * 
	 * @param request
	 * @param response
	 * @param notices
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void update(HttpServletRequest request, HttpServletResponse response, Suggestions suggestions) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			suggestionsService.update(suggestions);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}
	
	/**
	 * 登记处理
	 * @param request
	 * @param response
	 * @param suggestions
	 */
	@ResponseBody
	@RequestMapping("DealWith")
	public void dealWith(HttpServletRequest request ,HttpServletResponse response,Suggestions suggestions){
		RequestHolder requestHolder=RequestHolder.get(request, response);
		try{
			Users user =(Users)requestHolder.getClientUser();
			suggestions.setSuggestionfbuid(user.getUserid());
			suggestions.setSuggestionfbtime(new Date());
			
			suggestionsService.update(suggestions);
			requestHolder.success("操作成功");
		}catch (Exception e) {
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
	public void add(HttpServletRequest request, HttpServletResponse response, Suggestions suggestions) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users=(Users)requestHolder.getClientUser();
			suggestions.setUserid(users.getUserid());
			suggestions.setSuggestionid(RandomNum.getSID());
			suggestions.setSuggestiontime(new Date());
			suggestionsService.add(suggestions);
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
			suggestionsService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
