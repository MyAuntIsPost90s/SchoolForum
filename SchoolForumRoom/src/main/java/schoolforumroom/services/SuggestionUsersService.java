package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Suggestionusers;
import schoolforumroom.models.EUIPageList;

public interface SuggestionUsersService {

	public void add(Suggestionusers suggestionusers) throws Exception;

	public void update(Suggestionusers suggestionusers);
	
	public Boolean exist(Suggestionusers suggestionusers);

	public EUIPageList<Suggestionusers> getListByPage(Suggestionusers suggestionusers, int page, int rows);

	public void delete(List<String> ids);

}
