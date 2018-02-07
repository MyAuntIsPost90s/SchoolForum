package schoolforumroom.services.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.VotesMapper;
import schoolforum.base.models.Votes;
import schoolforumroom.common.RandomNum;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.services.VotesService;

@Service
public class VotesServiceImpl implements VotesService {

	@Resource
	private VotesMapper votesMapper;

	@Override
	public Votes getSingle(String id) {
		return votesMapper.getSingle(id);
	}

	@Override
	public EUIPageList<Votes> getListWithPage(Votes votes, int page, int rows) {
		PageList<Votes> pageList = votesMapper.getListWithPage(votes, new PageBounds(page, rows));
		return new EUIPageList<Votes>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Votes votes) {
		votes.setVoteid(RandomNum.getVID());
		votes.setVotecreatetime(new Date());
		votesMapper.insert(votes);
	}

	@Override
	public void update(Votes votes) {
		votesMapper.update(votes);
	}

	@Override
	public void delete(List<String> ids) {
		votesMapper.batchDelete(ids);
	}

	@Override
	public EUIPageList<Votes> getListByTimeType(Integer timetype, int page, int rows) {
		PageList<Votes> pageList = votesMapper.getListByTime(timetype, new PageBounds(page, rows));
		return new EUIPageList<Votes>(pageList.getPaginator().getTotalCount(), pageList);
	}

}
