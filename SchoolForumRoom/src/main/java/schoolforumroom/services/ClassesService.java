package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Classes;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.models.EUITree;

public interface ClassesService {
	public Classes getSingle(String id);

	public EUIPageList<Classes> getListWithPage(Classes majors, int page, int rows);
	
	public List<EUITree> getTrees();

	public void add(Classes majors);

	public void update(Classes majors);

	public void delete(List<String> ids);
}
