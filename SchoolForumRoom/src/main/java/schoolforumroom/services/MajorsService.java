package schoolforumroom.services;

import java.util.List;

import schoolforum.base.models.Majors;
import schoolforumroom.models.EUIPageList;

public interface MajorsService {
	public Majors getSingle(String id);

	public EUIPageList<Majors> getListWithPage(Majors majors, int page, int rows);

	public void add(Majors majors);

	public void update(Majors majors);

	public void delete(List<String> ids);
}
