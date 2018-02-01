package schoolforum.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import schoolforum.base.dao.MajorsMapper;
import schoolforum.base.models.Majors;

@Service
public class MajorsService {
	@Resource
	private MajorsMapper majorsMapper;
	
	public List<Majors> getList(Majors majors){
		return majorsMapper.getList(majors);
	}
	
	public Long count(Majors majors){
		return majorsMapper.count(majors);
	}
}
