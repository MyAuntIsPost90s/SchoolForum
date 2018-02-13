package schoolforumroom.services;

public interface VoteUsersService {

	public boolean exist(Long userid,String voteid);

	public void vote(Long userid,String voteid, String votefield);
}
