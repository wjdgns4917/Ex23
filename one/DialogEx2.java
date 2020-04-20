package com.one;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class MyModalDialog extends JDialog{
	private JTextField tf=new JTextField(10);
	private JButton okButton=new JButton("OK");
	
	public MyModalDialog(JFrame frame, String title) {
		super(frame, title ,true); //true�� ��� Ÿ���� ���鵵�� ����
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200,100);
		
		okButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //���̾�α׸� ����. ���� 44���� ����
			}
		});
	}
//�ؽ�Ʈ�ʵ� â�� ����ڰ� �Է��� ���ڿ��� ����
//�Էµ� ������ ������ null�� ����
public String getInput() {
	if(tf.getText().length()==0) return null;
	else return tf.getText();
	}
}
public class DialogEx2 extends JFrame {
	private MyModalDialog dialog; //���̾�α��� ���۷���
	
	public DialogEx2() {
		setTitle("��޴��̾�α�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn=new JButton("Show Modal Dialog");
		
		//��� ���̾�α� ����
		dialog=new MyModalDialog(this, "Tes Modal Dialog");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true); //��� ���̾�α� �۵� ����
				
				//���̾�α׺��� ����ڰ� �Է��� ���ڿ��� �޾ƿ´�.
				String text=dialog.getInput();
				
				if(text==null)return;//�Է��� ���ڿ��� ���� ���
				JButton btn=(JButton)e.getSource();
				btn.setText(text);//�Է��� ���ڿ��� �� ��ư�� ���ڿ��� ����
			}
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new DialogEx2();
	}
}
