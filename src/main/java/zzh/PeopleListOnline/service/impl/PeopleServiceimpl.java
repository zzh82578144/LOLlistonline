package zzh.PeopleListOnline.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import zzh.PeopleListOnline.mapper.LOLMapper;
import zzh.PeopleListOnline.model.LOL;
import zzh.PeopleListOnline.service.PeopleService;

@Service
public class PeopleServiceimpl implements PeopleService {
	
	@Autowired
	private LOLMapper lp; 
	
	
	
	private static final String SUCCESS="SUCCESS";
	private static final String ERROR="ERROR";
	
	
	@Override
	public String doinsertPeople(String iname, String idistrct, String irank) {
		LOL lol =new LOL();
		
		lol.setLolId(UUID.randomUUID().toString());
		lol.setLolName(iname);
		lol.setLolDistrct(idistrct);
		lol.setLolRank(irank);
		
		try {
			return lp.insert(lol)>0?SUCCESS:ERROR;
		} catch (Exception e) {
			return ERROR;
		}
		
		
	}
	


	public LOLMapper getLp() {
		return lp;
	}


	public void setLp(LOLMapper lp) {
		this.lp = lp;
	}


	@Override
	public List<LOL> doshowIndex() {

		return lp.selectAll();
	}



	@Override
	public String doremovePeople(String lolId) {
		LOL lol = new LOL();
		lol.setLolId(lolId);
		
		int i = lp.deleteByPrimaryKey(lolId);
		try {
			return i>0?SUCCESS:ERROR;
			
		} catch (Exception e) {
			return ERROR;
		}
	}



	@Override
	public String getJson(HttpServletRequest req) {
		List<LOL> ll=  doshowIndex();
		Gson g = new Gson();
		String json = g.toJson(ll);
		return json;
	}
	
	
	

}
