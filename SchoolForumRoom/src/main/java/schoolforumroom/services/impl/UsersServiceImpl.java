package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import lingshi.utilities.EncryptHelper;
import lingshi.utilities.ObjectHelper;
import schoolforum.base.common.UserType;
import schoolforum.base.dao.UsersMapper;
import schoolforum.base.models.Users;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Resource
	private UsersMapper usersMapper;

	@Override
	public EUIPageList<Users> getListWithPage(Users users, int page, int rows) {
		PageList<Users> list = usersMapper.getListWithPage(users, new PageBounds(page, rows));

		return new EUIPageList<Users>(list.getPaginator().getTotalCount(), list);
	}

	@Override
	public Users getUserById(long userid) {
		return usersMapper.getSingle(userid);
	}

	@Override
	public int update(Users users) {
		return usersMapper.update(users);
	}

	@Override
	public int batchDelete(List<Long> ids) {
		return usersMapper.batchDelete(ids);
	}

	@Override
	public int add(Users user) {
		return usersMapper.insert(user);
	}

	@Override
	public int cloneUser(String phone) {
		// 判断重复
		Users search = new Users();
		ObjectHelper.setObjectNull(search);
		search.setUsername(phone);

		if (usersMapper.count(search) > 0) {
			return 0;
		}

		Users user = new Users();
		ObjectHelper.setObjectNull(user);
		user.setPassword(EncryptHelper.EncoderByMd5("1").toUpperCase()); // 默认密码1
		user.setUsername(phone);
		user.setPhone(phone);
		user.setUsertype(UserType.ADMIN);

		return usersMapper.insert(user);
	}

}
