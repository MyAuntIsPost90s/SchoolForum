package schoolforumroom.controllers;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lingshi.valid.StringValid;
import lingshi.web.model.RequestFile;
import lingshi.web.model.RequestHolder;
import net.coobird.thumbnailator.Thumbnails;
import schoolforum.base.models.Users;
import schoolforumroom.common.Constant;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.UsersService;

@Controller
@RequestMapping("Users")
public class UsersController {

	@Resource
	private UsersService usersService;

	/**
	 * 当前登陆用户
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("NowUser")
	public void nowUser(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = (Users) requestHolder.getClientUser();
			requestHolder.success(users);
		} catch (Exception e) {
			requestHolder.err("获取当前登陆用户失败", e);
		}
	}
	
	/**
	 * 获取用户
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("Single")
	public void single(HttpServletRequest request, HttpServletResponse response,Long id) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users users = usersService.getUserById(id);
			requestHolder.success(users);
		} catch (Exception e) {
			requestHolder.err("获取当前登陆用户失败", e);
		}
	}

	/**
	 * 用户集合
	 */
	@ResponseBody
	@RequestMapping("UserList")
	public void userList(HttpServletRequest request, HttpServletResponse response, int page, int rows, Users users) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			EUIPageList<Users> list = usersService.getListWithPage(users, page, rows);
			requestHolder.success(list);
		} catch (Exception e) {
			requestHolder.err("获取用户集合失败", e);
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @param users
	 */
	@ResponseBody
	@RequestMapping("Add")
	public void add(HttpServletRequest request, HttpServletResponse response, Users users) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			usersService.add(users);
			requestHolder.success("操作成功");
		} catch (Exception e) {
			requestHolder.err("操作失败", e);
		}
	}

	/**
	 * 用户信息修改
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param rows
	 * @param users
	 */
	@ResponseBody
	@RequestMapping("UserChange")
	public void userChange(HttpServletRequest request, HttpServletResponse response, Users users) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			usersService.update(users);

			// 修改的用户信息是当前用户,刷新数据
			Users nowuser = (Users) requestHolder.getClientUser();
			users=usersService.getUserById(users.getUserid());
			if (nowuser.getUserid() == users.getUserid())
				requestHolder.setClientUser(users);

			requestHolder.success("修改用户信息成功", users);
		} catch (Exception e) {
			requestHolder.err("获修改用户失败", e);
		}
	}

	/**
	 * 修改用户密码
	 * 
	 * @param request
	 * @param response
	 * @param users
	 */
	@ResponseBody
	@RequestMapping("PwdChange")
	public void pwdChange(HttpServletRequest request, HttpServletResponse response, Users users) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users nowuser = (Users) requestHolder.getClientUser();
			nowuser.setPassword(users.getPassword());
			usersService.update(nowuser);

			// 刷新数据
			requestHolder.setClientUser(nowuser);

			requestHolder.success("修改密码成功");
		} catch (Exception e) {
			requestHolder.err("获修改用户失败", e);
		}
	}

	/**
	 * 用户头像上传
	 * 
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("UserHeadImgUpload")
	public void userHeadImgUpload(HttpServletRequest request, HttpServletResponse response) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			Users user = (Users) requestHolder.getClientUser();
			RequestFile requestFile = requestHolder.getRequestFile();
			MultipartFile file = requestFile.getFile();
			String virpath = Constant.USERHEAD_URL + user.getUserid() + ".png";
			String path = requestHolder.getRealPathPath(virpath);
			user.setHeadimgurl(virpath + "?version=" + UUID.randomUUID());

			File tempfile = new File(path);
			if (!tempfile.getParentFile().exists()) {
				tempfile.getParentFile().mkdirs();
			}
			Thumbnails.of(file.getInputStream()).size(300, 300).outputQuality(0.7).outputFormat("png").toFile(path);// 保存压缩文件
			usersService.update(user);

			requestHolder.success("更换头像成功", user);
		} catch (Exception e) {
			requestHolder.err("更换头像失败", e);
		}
	}

	/**
	 * 克隆用户账号
	 * 
	 * @param request
	 * @param response
	 * @param phone
	 */
	@ResponseBody
	@RequestMapping("UserClone")
	public void userClone(HttpServletRequest request, HttpServletResponse response, String phone) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			if (StringValid.isNullOrEmpty(phone)) {
				requestHolder.fail("参数错误");
				return;
			}
			// 判断重复
			int result = usersService.cloneUser(phone);
			if (result < 1) {
				requestHolder.fail("克隆失败");
				return;
			}
			requestHolder.success("克隆成功");
		} catch (Exception e) {
			requestHolder.err("克隆失败", e);
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
	public void batchDelete(HttpServletRequest request, HttpServletResponse response, @RequestBody List<Long> ids) {
		RequestHolder requestHolder = RequestHolder.get(request, response);
		try {
			usersService.batchDelete(ids);
			requestHolder.success("删除成功");
		} catch (Exception e) {
			requestHolder.err("删除失败", e);
		}
	}
}
