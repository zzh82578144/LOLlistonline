package zzh.PeopleListOnline.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import zzh.PeopleListOnline.model.LOL;

public interface PeopleService {
	String doinsertPeople(String iname,String idistrct, String irank);
	
	List<LOL> doshowIndex();
	
	String doremovePeople(String lolId);
	
	String getJson(HttpServletRequest req);
}
