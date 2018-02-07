package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Votes;
import schoolforumroom.models.EUIPageList;

public interface VotesService {
	public Votes getSingle(String id);

	public EUIPageList<Votes> getListWithPage(Votes votes, int page, int rows);
	
	public EUIPageList<Votes> getListByTimeType(Integer timetype, int page, int rows);

	public void add(Votes votes);

	public void update(Votes votes);

	public void delete(List<String> ids);
}
