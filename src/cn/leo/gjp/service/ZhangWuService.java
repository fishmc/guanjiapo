package cn.leo.gjp.service;

import java.util.List;

import cn.leo.gjp.dao.ZhangWuDao;
import cn.leo.gjp.domain.ZhangWu;

public class ZhangWuService {
	
	private ZhangWuDao ZhangWuDao = new ZhangWuDao();
	
	public List<ZhangWu> selectAll(){
		return ZhangWuDao.selectAll();
	}
	
	public List<ZhangWu> select(String beginDate, String endDate){
		return ZhangWuDao.select(beginDate,endDate);
	}

	public void add(ZhangWu zhangwu) {
		ZhangWuDao.add(zhangwu);
		
	}

	public void edit(ZhangWu zhangwu) {
		
		ZhangWuDao.edit(zhangwu);
	}

	public void del(int zwid) {
		// TODO Auto-generated method stub
		ZhangWuDao.del(zwid);
	}

}
