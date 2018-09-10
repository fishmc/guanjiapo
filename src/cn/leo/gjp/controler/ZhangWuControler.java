package cn.leo.gjp.controler;

import java.util.List;

import cn.leo.gjp.domain.ZhangWu;
import cn.leo.gjp.service.ZhangWuService;

public class ZhangWuControler {

	private ZhangWuService zhangwuservice = new ZhangWuService();
	
	public List<ZhangWu> selectAll(){
		return zhangwuservice.selectAll();
	}

	public List<ZhangWu> select(String beginDate, String endDate) {
		
		return zhangwuservice.select(beginDate,endDate);
	}

	public void add(ZhangWu zhangwu) {
		zhangwuservice.add(zhangwu);
		
	}

	public void edit(ZhangWu zhangwu) {
		
		zhangwuservice.edit(zhangwu);
	}

	public void del(int zwid) {
		zhangwuservice.del(zwid);
		
	}
}
