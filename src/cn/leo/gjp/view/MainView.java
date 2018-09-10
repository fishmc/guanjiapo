package cn.leo.gjp.view;

import java.util.List;
import java.util.Scanner;

import cn.leo.gjp.controler.ZhangWuControler;
import cn.leo.gjp.domain.ZhangWu;

public class MainView {
	
	
	private ZhangWuControler zhangwucontrol = new ZhangWuControler();
	
	public void run(){
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("---------------管家婆家庭记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			int num = sc.nextInt();
			
			switch (num) {
			case 1:
				addZhangWu();
				break;
			case 2:
				editZhangWu();
				break;
			case 3:
				delZhangWu();
				break;
			case 4: 
				    queryZhangwWu();
				    break;
			case 5:
					
				System.out.println("软件已退出");
				System.exit(0);
			}
			
			System.out.println();
		}
		
	}
	
	public void delZhangWu() {
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要删除的ID:");
		int zwid = Integer.valueOf(sc.nextLine());
		
		zhangwucontrol.del(zwid);
	}
	
	public void editZhangWu() {
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入要修改的ID:");
		int zwid = Integer.valueOf(sc.nextLine());
		System.out.println("请输入新类别:");
		String flname = sc.nextLine();
		System.out.println("请输入新账户:");
		String zhanghu = sc.nextLine();
		System.out.println("请输入新金额:");
		double money = Double.valueOf(sc.nextLine());
		System.out.println("请输入新创建时间:");
		String createtime = sc.nextLine();
		System.out.println("请输入新说明:");
		String description = sc.nextLine();
		
		ZhangWu zhangwu = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		zhangwucontrol.edit(zhangwu);
		System.out.println("修改成功");
	}

	
	public void addZhangWu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入类别:");
		String flname = sc.nextLine();
		System.out.println("请输入账户:");
		String zhanghu = sc.nextLine();
		System.out.println("请输入金额:");
		double money = Double.valueOf(sc.nextLine());
		System.out.println("请输入创建时间:");
		String createtime = sc.nextLine();
		System.out.println("请输入说明:");
		String description = sc.nextLine();
		
		ZhangWu zhangwu = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		zhangwucontrol.add(zhangwu);
		System.out.println("添加成功");
	}
	
	
	public void queryZhangwWu(){
		System.out.println("1.查询所有　2.按条件查询");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		switch(number){
		case 1:
				selectAll();
				break;
		case 2:
				select();
				break;
		}
	}
	
	
	//按照时间查询部分数据
		public void select() {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("查询日期格式为xxxx-xx-xx");
			System.out.println("请输入查询开始日期:");
			String beginDate = sc.nextLine();
			System.out.println("请输入查询结束日期:");
			String endDate = sc.nextLine();
			List<ZhangWu> list = zhangwucontrol.select(beginDate,endDate);
			System.out.println("ID"+"\t"+"类别"+"\t"+"金额"+"\t"+"账户"+"\t"+"时间"+"\t\t"+"说明");
			if(list.size()!=0){
				for(ZhangWu zw : list){
					System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getMoney()+"\t"+zw.getZhangwu()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
				}
			}else{
				System.out.println("没有查询到数据");
			}
		}
		
		
		//查询全部账务
		public void selectAll(){
			List<ZhangWu> list = zhangwucontrol.selectAll();
			System.out.println("ID"+"\t"+"类别"+"\t"+"金额"+"\t"+"账户"+"\t"+"时间"+"\t\t"+"说明");
			for(ZhangWu zw : list){
				System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getMoney()+"\t"+zw.getZhangwu()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
			}
		}

}
