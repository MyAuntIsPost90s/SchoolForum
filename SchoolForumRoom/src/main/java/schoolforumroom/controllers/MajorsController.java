package schoolforumroom.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Majors;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.models.EUITree;
import schoolforumroom.services.MajorsService;

@Controller
@RequestMapping("Majors")
public class MajorsController {

	@Resource
	private MajorsService majorsService;

	/**
	 * 单个系院
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void nowUser(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(majorsService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 系院集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void userList(HttpServletRequest request, HttpServletResponse response, int page, int rows, Majors majors) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Majors> list = majorsService.getListWithPage(majors, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}

	/**
	 * 系院集合
	 */
	@ResponseBody
	@RequestMapping("Tree")
	public void tree(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Majors> list = majorsService.getListWithPage(null, 1, 9999);
			EUITree root = new EUITree();
			root.setId("-1");
			root.setText("系院");
			root.setChildren(new ArrayList<EUITree>());

			list.getRows().forEach(o -> {
				EUITree tree = new EUITree();
				tree.setId(o.getMajorid());
				tree.setText(o.getMajorname());

				root.getChildren().add(tree);
			});
			
			List<EUITree> trees=new ArrayList<EUITree>();
			trees.add(root);
			requestHolder.success(trees);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}

	/**
	 * 系院信息修改
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param users
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void userChange(HttpServletRequest request, HttpServletResponse response, Majors majors) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			majorsService.update(majors);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Majors majors) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			majors.setMajorid(RandomNum.getMID());
			majorsService.add(majors);
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
			majorsService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
