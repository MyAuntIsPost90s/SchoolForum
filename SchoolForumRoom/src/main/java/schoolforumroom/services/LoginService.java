package schoolforumroom.services;

import schoolforum.base.models.Users;

public interface LoginService {
	/**
	 * 登陆
	 * @param users
	 * @param outmsg
	 * @return
	 */
	public Users loginer(Users users,StringBuffer outmsg);
}
