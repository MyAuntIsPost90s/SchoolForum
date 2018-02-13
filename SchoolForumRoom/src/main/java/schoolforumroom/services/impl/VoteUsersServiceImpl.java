package schoolforumroom.services.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lingshi.convert.Convert;
import schoolforum.base.dao.VoteusersMapper;
import schoolforum.base.models.Votes;
import schoolforum.base.models.Voteusers;
import schoolforumroom.services.VoteUsersService;
import schoolforumroom.services.VotesService;

@Service
public class VoteUsersServiceImpl implements VoteUsersService {

	@Resource
	private VoteusersMapper voteusersMapper;
	@Resource
	private VotesService votesService;

	@Override
	public boolean exist(Long userid, String voteid) {
		Voteusers voteusers = new Voteusers();
		voteusers.setUserid(userid);
		voteusers.setVoteid(voteid);
		if (voteusersMapper.count(voteusers) < 1) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void vote(Long userid, String voteid, String votefield) {
		Votes vote = votesService.getSingle(voteid);
		String[] fields = vote.getVotefield().split(",");
		List<Integer> values = Convert.toInts(vote.getVotevalue(), ",");
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].equals(votefield)) {
				values.remove(i);
				values.add(i, values.get(i) + 1);
				break;
			}
		}
		String votevalues = "";
		for (Integer value : values) {
			votevalues += value + ",";
		}
		if (votevalues.endsWith(",")) {
			votevalues = votevalues.substring(0, votevalues.length() - 1);
		}
		vote.setVotevalue(votevalues);
		votesService.update(vote);

		Voteusers voteusers = new Voteusers();
		voteusers.setUserid(userid);
		voteusers.setVotefield(votefield);
		voteusers.setVoteid(voteid);
		voteusersMapper.insert(voteusers);
	}

}
