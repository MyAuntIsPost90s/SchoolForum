package schoolforum.controllers;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lingshi.utilities.ObjectHelper;
import lingshi.web.model.RequestHolder;
import schoolforum.base.models.Majors;
import schoolforum.services.MajorsService;

@Controller
public class TestController {
	@Resource
	private MajorsService majorsService;
	
	@ResponseBody
	@RequestMapping("Test")
	public void test(HttpServletRequest request,HttpServletResponse response){
		RequestHolder requestHolder=RequestHolder.get(request, response);
		try{		
			List<Majors> list = majorsService.getList(ObjectHelper.setObjectNull(new Majors()));
			requestHolder.success(list);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	@ResponseBody
	@RequestMapping("Test2")
	public void test2(HttpServletRequest request,HttpServletResponse response){
		RequestHolder requestHolder=RequestHolder.get(request, response);
		try{		
			long count = majorsService.count(ObjectHelper.setObjectNull(new Majors()));
			requestHolder.success(count);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
