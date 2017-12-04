/**
 * 继承jfram并实现ActionListener接口
 * 完成程序主界面的显示以及对数据库记录的浏、增、删、改、查
 */
package per.student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

abstract class StudentInfo extends JFrame implements ActionListener {
	private String dbURL;//数据库标识名
	private String user;//数据库用户
	private String password;//数据库用户密码
	private int flag;//浏增删改查功能标志
	private int age;
	//按钮
	JButton btnDisp,btnAdd,btnDel,btnUpdate,btnSearch;
	JTextArea ta;//信息显示区域
	JScrollPane jsp;//带滚动条的面板
	
	StudentInfo(){
		//直接调用Access数据库驱动程序，设置数据源
		this.dbURL="jdbc:odbc:Driver= {MicroSoft Access Driver(*.mdb)};DBQ="
		+("sample.mdb");
		this.user="ZHB";
		this.password="1234";
		setTitle("木林杉学生信息管理系统");
		
		btnDisp=new JButton("浏览");
		btnAdd=new JButton("增加");
		btnDel=new JButton("删除");
		btnUpdate=new JButton("修改");
		btnSearch=new JButton("查询");
		ta=new JTextArea(6,20);//文本信息显示区域
		jsp=new JScrollPane(ta);//给文本框架滚动条
		Container c=getContentPane();//获取当前窗口显示面板
		c.setLayout(new FlowLayout());//设置布局为顺序布局
		//加入按钮和信息显示组件到窗口
		c.add(btnDisp);
		c.add(btnAdd);
		c.add(btnDel);
		c.add(btnUpdate);
		c.add(btnSearch);
		c.add(jsp);
		setSize(330, 200);
		setVisible(true);
		//注册时间监听
		btnDisp.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSearch.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {//按钮事件处理
		if(e.getSource()==btnDisp) {
			flag=1;//浏览记录处理
		}
		else if(e.getSource()==btnAdd) {
			flag=2;//增加记录处理
		}
		else if(e.getSource()==btnDel) {
			flag=3;
		}
		else if(e.getSource()==btnUpdate) {
			flag=4;
		}
		else if(e.getSource()==btnSearch) {
			flag=5;
		}
	}

}
