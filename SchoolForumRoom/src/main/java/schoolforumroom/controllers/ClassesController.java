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
import schoolforum.base.models.Classes;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.ClassesService;

@Controller
@RequestMapping("Classes")
public class ClassesController {

	@Resource
	private ClassesService classesService;

	/**
	 * 单个班级
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void nowUser(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(classesService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 班级集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void userList(HttpServletRequest request, HttpServletResponse response, int page, int rows, Classes classes) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Classes> list = classesService.getListWithPage(classes, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}

	/**
	 * 班级信息修改
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param users
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void userChange(HttpServletRequest request, HttpServletResponse response, Classes classes) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			classesService.update(classes);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Classes classes) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			classes.setClassid(RandomNum.getCID());
			classesService.add(classes);
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
			classesService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
