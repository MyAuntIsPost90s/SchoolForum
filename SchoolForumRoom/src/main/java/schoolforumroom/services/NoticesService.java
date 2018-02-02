package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Notices;
import schoolforumroom.models.EUIPageList;

public interface NoticesService {
	public Notices getSingle(String id);

	public EUIPageList<Notices> getListWithPage(Notices notices, int page, int rows);

	public void add(Notices notices);

	public void update(Notices notices);

	public void delete(List<String> ids);
}
