package CalViewButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.StateMachine;
import object.Event;
import views.WindowPanel;

public class DayButton extends JButton implements ActionListener {
	private String date;
	private StateMachine SM;
	private WindowPanel wp;
	public DayButton(String text, String date, int isdatenumber,StateMachine SM, WindowPanel wp) {// 1=date number 2= normal event 3= full day event
		super(text);
		this.wp=wp;
		this.SM=SM;
		this.date=date;
		setPreferredSize(new Dimension(10, 20));
		addActionListener(this);
		
		if(date.equals(SM.getFormattedDate())&&isdatenumber==1){
			setForeground(Color.RED);
		}
		if(isdatenumber>=2){
			setToolTipText("Mer event finns!");
			if (isdatenumber==2) {
				setPreferredSize(new Dimension(50, 50));
			}
			
		}
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(date);
		SM.setUnformattedDate(date);
		SM.setActiveview(1);
		wp.getViewViewer();
		wp.getViewChoice();
		wp.getOverview();
	}

}