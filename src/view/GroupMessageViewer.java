package view;

import java.awt.BorderLayout;
import java.awt.event.*;


import javax.swing.JButton;

import javax.swing.JOptionPane;


import controller.MessageController;


@SuppressWarnings("serial")
public class GroupMessageViewer extends MessageViewer{

	public GroupMessageViewer(MessageController control) {
		super(control);
		JButton friendList = new JButton("...");
		friendList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Edit friends go here");
			}

		});
		header.add(friendList, BorderLayout.EAST);

	}
}
