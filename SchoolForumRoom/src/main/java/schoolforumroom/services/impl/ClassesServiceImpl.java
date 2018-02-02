package schoolforumroom.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import schoolforum.base.dao.ClassesMapper;
import schoolforum.base.models.Classes;
import schoolforum.base.models.Majors;
import schoolforumroom.models.EUIPageList;
import schoolforumroom.models.EUITree;
import schoolforumroom.services.ClassesService;
import schoolforumroom.services.MajorsService;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Resource
	private ClassesMapper classesMapper;
	@Resource
	private MajorsService majorsService;

	@Override
	public EUIPageList<Classes> getListWithPage(Classes classes, int page, int rows) {
		PageList<Classes> pageList = classesMapper.getListWithPage(classes, new PageBounds(page, rows));
		return new EUIPageList<>(pageList.getPaginator().getTotalCount(), pageList);
	}

	@Override
	public void add(Classes classes) {
		classesMapper.insert(classes);

	}

	@Override
	public void update(Classes classes) {
		classesMapper.update(classes);

	}

	@Override
	public void delete(List<String> ids) {
		classesMapper.batchDelete(ids);
	}

	@Override
	public Classes getSingle(String id) {
		return classesMapper.getSingle(id);
	}

	@Override
	public List<EUITree> getTrees() {
		EUIPageList<Majors> list = majorsService.getListWithPage(null, 1, 9999);
		EUITree root = new EUITree();
		root.setId("-1");
		root.setText("系院");
		root.setChildren(new ArrayList<EUITree>());

		list.getRows().forEach(o -> {
			EUITree tree = new EUITree();
			tree.setId(o.getMajorid());
			tree.setText(o.getMajorname());
			tree.setChildren(new ArrayList<EUITree>());
			root.getChildren().add(tree);
			
			//查找子节点
			Classes condition=new Classes();
			condition.setMajorid(o.getMajorid());
			List<Classes> classes =classesMapper.getList(condition);
			classes.forEach(c->{
				EUITree classTree = new EUITree();
				classTree.setId(c.getClassid());
				classTree.setText(c.getClassname());	
				tree.getChildren().add(classTree);
			});
		});
		
		List<EUITree> trees=new ArrayList<EUITree>();
		trees.add(root);
		return trees;
	}

}
