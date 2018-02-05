package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Suggestions;
import schoolforumroom.models.EUIPageList;

public interface SuggestionsService {
	
	public Suggestions getSingle(String id);

	public EUIPageList<Suggestions> getListWithPage(Suggestions suggestions, int page, int rows);

	public void add(Suggestions suggestions);

	public void update(Suggestions suggestions);

	public void delete(List<String> ids);
}
