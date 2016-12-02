package views.calendar;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.StateMachine;
import object.Calendar;
import views.WindowPanel;

public class CalChooseList extends JPanel implements ListSelectionListener {

	private JList calChoiceList;
	private JLabel calChoiceTitle,calChoiceInfo, calChoiceTip;
	private DefaultListModel listModel;
	private StateMachine SM;
	private WindowPanel wp;
	private int[] list;
	private GridBagConstraints gbc;
	
	public CalChooseList(Calendar[] calarray, StateMachine SM, WindowPanel wp){
		this.SM=SM;
		this.wp=wp;
		gbc = new GridBagConstraints();
		setLayout(new GridBagLayout());
		calChoiceTitle=new JLabel("Synliga kalendrar:");
		calChoiceTitle.setFont(new Font("Serif", Font.PLAIN, 25));
		calChoiceTip=new JLabel("Tips:");
		calChoiceTip.setFont(new Font("Serif", Font.PLAIN, 20));
		calChoiceInfo=new JLabel("H�ll CTRL f�r flerval");
		calChoiceInfo.setFont(new Font("Serif", Font.PLAIN, 20));
		list=SM.getActiveCalendars();
		if(list==null || list.length>calarray.length){
			list = new int[calarray.length];
			for(int j = 0; j < calarray.length; j++) {
				list[j]=j;
			}	
		}
		listModel = new DefaultListModel();

		for (int i = 0; i < calarray.length; i++) {
			listModel.addElement(calarray[i].getName());
		}
        //Create the list and put it in a scroll pane.
        calChoiceList = new JList(listModel);
        calChoiceList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        calChoiceList.setSelectedIndices(list);
        calChoiceList.addListSelectionListener(this);
        calChoiceList.setVisibleRowCount(10);
        JScrollPane listScrollPane = new JScrollPane(calChoiceList);
        setOpaque(false);
        
        gbc.gridx = 0;
		gbc.gridy = 0;
        add(calChoiceTitle,gbc);
        gbc.gridx = 0;
		gbc.gridy = 1;
		add(listScrollPane,gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(calChoiceTip,gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(calChoiceInfo,gbc);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int[] indecies = calChoiceList.getSelectedIndices();
		SM.setActiveCalendars(indecies);
		System.out.println(indecies.length);
		System.out.println("-");
	}

}
