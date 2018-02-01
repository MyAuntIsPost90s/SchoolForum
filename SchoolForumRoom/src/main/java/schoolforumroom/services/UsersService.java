package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Users;
import schoolforumroom.models.EUIPageList;

public interface UsersService {
	public int add(Users user);

	public int cloneUser(String phone);

	public EUIPageList<Users> getListWithPage(Users users, int page, int rows);

	public Users getUserById(long userid);

	public int update(Users users);

	public int batchDelete(List<Long> ids);
}
