/**
 * �̳�jfram��ʵ��ActionListener�ӿ�
 * ��ɳ������������ʾ�Լ������ݿ��¼��䯡�����ɾ���ġ���
 */
package per.student;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

abstract class StudentInfo extends JFrame implements ActionListener {
	private String dbURL;//���ݿ��ʶ��
	private String user;//���ݿ��û�
	private String password;//���ݿ��û�����
	private int flag;//���ɾ�Ĳ鹦�ܱ�־
	private int age;
	//��ť
	JButton btnDisp,btnAdd,btnDel,btnUpdate,btnSearch;
	JTextArea ta;//��Ϣ��ʾ����
	JScrollPane jsp;//�������������
	
	StudentInfo(){
		//ֱ�ӵ���Access���ݿ�����������������Դ
		this.dbURL="jdbc:odbc:Driver= {MicroSoft Access Driver(*.mdb)};DBQ="
		+("sample.mdb");
		this.user="ZHB";
		this.password="1234";
		setTitle("ľ��ɼѧ����Ϣ����ϵͳ");
		
		btnDisp=new JButton("���");
		btnAdd=new JButton("����");
		btnDel=new JButton("ɾ��");
		btnUpdate=new JButton("�޸�");
		btnSearch=new JButton("��ѯ");
		ta=new JTextArea(6,20);//�ı���Ϣ��ʾ����
		jsp=new JScrollPane(ta);//���ı���ܹ�����
		Container c=getContentPane();//��ȡ��ǰ������ʾ���
		c.setLayout(new FlowLayout());//���ò���Ϊ˳�򲼾�
		//���밴ť����Ϣ��ʾ���������
		c.add(btnDisp);
		c.add(btnAdd);
		c.add(btnDel);
		c.add(btnUpdate);
		c.add(btnSearch);
		c.add(jsp);
		setSize(330, 200);
		setVisible(true);
		//ע��ʱ�����
		btnDisp.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSearch.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {//��ť�¼�����
		if(e.getSource()==btnDisp) {
			flag=1;//�����¼����
		}
		else if(e.getSource()==btnAdd) {
			flag=2;//���Ӽ�¼����
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
