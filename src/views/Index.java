package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class Index extends JPanel {

	private JPanel mainPanel, leftPanel, rightPanel, upperLeftPanel, upperRightPanel;
	private GridBagConstraints gbc;

	private Window window;

	public Index(Window window) {
		this.window = window;

		MenuList menu = new MenuList();
        window.setJMenuBar(menu.createMenuBar());
		
		// Main panel
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(1400, 800));
		mainPanel.setLayout(new GridBagLayout());
		mainPanel.setVisible(true);
		mainPanel.setBackground(new Color(255, 0, 255));
		this.add(mainPanel);

		gbc = new GridBagConstraints();

		// Upper left panel
		upperLeftPanel = new JPanel();
		upperLeftPanel.setPreferredSize(new Dimension(200, 100));
		upperLeftPanel.setLayout(new GridLayout(2, 2));
		upperLeftPanel.setVisible(true);
		upperLeftPanel.setBackground(new Color(255, 0, 0));

		gbc.gridx = 0;
		gbc.gridy = 0;

		mainPanel.add(upperLeftPanel, gbc);

		// Upper right panel
		upperRightPanel = new JPanel();
		upperRightPanel.setPreferredSize(new Dimension(1200, 100));
		upperRightPanel.setLayout(new GridLayout(2, 2));
		upperRightPanel.setVisible(true);
		upperRightPanel.setBackground(new Color(0, 255, 0));

		gbc.gridx = 1;
		gbc.gridy = 0;

		mainPanel.add(upperRightPanel, gbc);

		// Left panel
		leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(200, 700));
		leftPanel.setLayout(new GridLayout(2, 2));
		leftPanel.setVisible(true);
		leftPanel.setBackground(new Color(0, 0, 255));

		gbc.gridx = 0;
		gbc.gridy = 1;

		mainPanel.add(leftPanel, gbc);

		// Right panel
		rightPanel = new JPanel();
		rightPanel.setPreferredSize(new Dimension(1200, 700));
		rightPanel.setLayout(new GridLayout(2, 2));
		rightPanel.setVisible(true);
		rightPanel.setBackground(new Color(100, 100, 100));

		gbc.gridx = 1;
		gbc.gridy = 1;

		mainPanel.add(rightPanel, gbc);

	}

}
