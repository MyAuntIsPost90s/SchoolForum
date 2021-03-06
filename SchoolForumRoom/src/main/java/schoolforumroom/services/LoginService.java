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
	
	/**
	 * 客户端登陆
	 * @param users
	 * @param outmsg
	 * @return
	 */
	public Users clientLogin(Users users,StringBuffer outmsg);
}
