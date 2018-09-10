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
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
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
					
				System.out.println("������˳�");
				System.exit(0);
			}
			
			System.out.println();
		}
		
	}
	
	public void delZhangWu() {
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫɾ����ID:");
		int zwid = Integer.valueOf(sc.nextLine());
		
		zhangwucontrol.del(zwid);
	}
	
	public void editZhangWu() {
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫ�޸ĵ�ID:");
		int zwid = Integer.valueOf(sc.nextLine());
		System.out.println("�����������:");
		String flname = sc.nextLine();
		System.out.println("���������˻�:");
		String zhanghu = sc.nextLine();
		System.out.println("�������½��:");
		double money = Double.valueOf(sc.nextLine());
		System.out.println("�������´���ʱ��:");
		String createtime = sc.nextLine();
		System.out.println("��������˵��:");
		String description = sc.nextLine();
		
		ZhangWu zhangwu = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		zhangwucontrol.edit(zhangwu);
		System.out.println("�޸ĳɹ�");
	}

	
	public void addZhangWu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("���������:");
		String flname = sc.nextLine();
		System.out.println("�������˻�:");
		String zhanghu = sc.nextLine();
		System.out.println("��������:");
		double money = Double.valueOf(sc.nextLine());
		System.out.println("�����봴��ʱ��:");
		String createtime = sc.nextLine();
		System.out.println("������˵��:");
		String description = sc.nextLine();
		
		ZhangWu zhangwu = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		zhangwucontrol.add(zhangwu);
		System.out.println("��ӳɹ�");
	}
	
	
	public void queryZhangwWu(){
		System.out.println("1.��ѯ���С�2.��������ѯ");
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
	
	
	//����ʱ���ѯ��������
		public void select() {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("��ѯ���ڸ�ʽΪxxxx-xx-xx");
			System.out.println("�������ѯ��ʼ����:");
			String beginDate = sc.nextLine();
			System.out.println("�������ѯ��������:");
			String endDate = sc.nextLine();
			List<ZhangWu> list = zhangwucontrol.select(beginDate,endDate);
			System.out.println("ID"+"\t"+"���"+"\t"+"���"+"\t"+"�˻�"+"\t"+"ʱ��"+"\t\t"+"˵��");
			if(list.size()!=0){
				for(ZhangWu zw : list){
					System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getMoney()+"\t"+zw.getZhangwu()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
				}
			}else{
				System.out.println("û�в�ѯ������");
			}
		}
		
		
		//��ѯȫ������
		public void selectAll(){
			List<ZhangWu> list = zhangwucontrol.selectAll();
			System.out.println("ID"+"\t"+"���"+"\t"+"���"+"\t"+"�˻�"+"\t"+"ʱ��"+"\t\t"+"˵��");
			for(ZhangWu zw : list){
				System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t"+zw.getMoney()+"\t"+zw.getZhangwu()+"\t"+zw.getCreatetime()+"\t"+zw.getDescription());
			}
		}

}
