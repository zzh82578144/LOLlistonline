package zzh.PeopleListOnline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zzh.PeopleListOnline.model.LOL;
import zzh.PeopleListOnline.service.PeopleService;

@Controller
public class IndexController {
	
	@Autowired
	PeopleService ps;
	
	
	
	/**
	 * 新增召唤师
	 * @param iname传过来的名字
	 * @param idistrct区服
	 * @param irank段位
	 * @return SUCCESS or  ERROR
	 */
	@RequestMapping("/insertPeople.do")
	public String insertPeople(String iname,String idistrct, String irank,HttpServletRequest req) {

		req.setAttribute("result",ps.doinsertPeople(iname, idistrct, irank) );
		
		return "/index.jsp";
	}
	
	
	/**
	 * 查询数据库显示列表
	 * @param req
	 * @return
	 */
	
	@RequestMapping(value="/showIndex.do",produces="text/html; charset=UTF-8")
	public @ResponseBody String showIndex(HttpServletRequest req) {
		String json = ps.getJson(req);
		return json;
	}
	
	
	
	/**
	 * 执行删除操作
	 */
	@RequestMapping("/remove.do")
	public String removePeople(String lolId,HttpServletRequest req) {
		req.setAttribute("result", ps.doremovePeople(lolId));
		return "/index.jsp";
	}

}
