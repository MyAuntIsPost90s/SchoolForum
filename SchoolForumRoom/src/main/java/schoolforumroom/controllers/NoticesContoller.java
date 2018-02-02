package schoolforumroom.controllers;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.web.model.RequestFile;
import lingshi.web.model.RequestHolder;
import net.coobird.thumbnailator.Thumbnails;
import schoolforum.base.models.Notices;
import schoolforum.base.models.Users;
import schoolforumroom.common.Constant;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.NoticesService;

@Controller
@RequestMapping("Notices")
public class NoticesContoller {
	@Resource
	private NoticesService noticesService;
	
	/**
	 * 单个通知公告
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void single(HttpServletRequest request, HttpServletResponse response, String id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			requestHolder.success(noticesService.getSingle(id));
		} catch (Exception e) {
			requestHolder.err("获取信息失败", e);
		}
	}

	/**
	 * 通知公告集合
	 */
	@ResponseBody
	@RequestMapping("List")
	public void list(HttpServletRequest request, HttpServletResponse response, int page, int rows, Notices notices) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Notices> list = noticesService.getListWithPage(notices, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取集合失败", e);
		}
	}
	
	/**
	 * 通知公告修改
	 * 
	 * @param request
	 * @param response
	 * @param notices
	 */
	@ResponseBody
	@RequestMapping("Update")
	public void update(HttpServletRequest request, HttpServletResponse response, Notices notices) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			//保存图片
			RequestFile requestFile=requestHolder.getRequestFile();
			if(requestFile!=null&&!requestFile.isEmpty()){
				String path=Constant.NOTICEHEAD_URL+notices.getNoticeid()+".png";
				File file=new File(requestHolder.getRealPathPath(path));
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				Thumbnails.of(requestFile.getFile().getInputStream()).size(800, 400).outputQuality(0.7).outputFormat("png").toFile(file);
				notices.setNoticeimgurl(path+"?a="+RandomNum.getLGID());
			}
			
			noticesService.update(notices);
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
	public void add(HttpServletRequest request, HttpServletResponse response, Notices notices) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			notices.setNoticeid(RandomNum.getNID());
			//保存图片
			RequestFile requestFile=requestHolder.getRequestFile();
			if(requestFile!=null&&!requestFile.isEmpty()){
				String path=Constant.NOTICEHEAD_URL+notices.getNoticeid()+".png";
				File file=new File(requestHolder.getRealPathPath(path));
				if(!file.getParentFile().exists()){
					file.getParentFile().mkdirs();
				}
				Thumbnails.of(requestFile.getFile().getInputStream()).size(800, 400).outputQuality(0.7).outputFormat("png").toFile(file);
				notices.setNoticeimgurl(path+"?a="+RandomNum.getLGID());
			}
			
			Users users=(Users)requestHolder.getClientUser();
			notices.setUserid(users.getUserid());
			noticesService.add(notices);
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
			noticesService.delete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
