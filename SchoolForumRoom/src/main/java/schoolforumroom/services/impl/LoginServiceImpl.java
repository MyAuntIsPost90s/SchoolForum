package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lingshi.utilities.ObjectHelper;
import schoolforum.base.common.UserType;
import schoolforum.base.dao.UsersMapper;
import schoolforum.base.models.Users;
import schoolforumroom.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private UsersMapper usersMapper;

	@Override
	public Users loginer(Users users, StringBuffer outmsg) {
		Users temp=new Users();
		ObjectHelper.setObjectNull(temp);
		
		temp.setUsername(users.getUsername());
		
		List<Users> list = usersMapper.getList(temp);
		if(list==null||list.size()!=1){
			outmsg.append("该账号不存在");
			return null;
		}
		temp = list.get(0);
		if(temp.getUsertype()!=UserType.DEFUALT&&temp.getUsertype()!=UserType.ADMIN){
			outmsg.append("该账号不存在");
			return null;
		}
		
		if(!temp.getPassword().equals(users.getPassword())){
			outmsg.append("账号或密码错误");
			return null;
		}

		outmsg.append("登陆成功");
		return temp;
	}

	@Override
	public Users clientLogin(Users users, StringBuffer outmsg) {
		Users temp=new Users();
		ObjectHelper.setObjectNull(temp);
		
		temp.setUsername(users.getUsername());
		
		List<Users> list = usersMapper.getList(temp);
		if(list==null||list.size()!=1){
			outmsg.append("该账号不存在");
			return null;
		}
		temp = list.get(0);
		
		if(!temp.getPassword().equals(users.getPassword())){
			outmsg.append("账号或密码错误");
			return null;
		}

		outmsg.append("登陆成功");
		return temp;
	}
}
