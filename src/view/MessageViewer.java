package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

import controller.MessageController;

@SuppressWarnings("serial")
public abstract class MessageViewer extends JFrame{
	protected MessageController control;

	//List of reusable components
	protected JPanel header;
	protected JScrollPane body;
	protected JPanel bodyContent;
	protected JPanel footer;
	private JButton back;
	private Container pane;

	
	//List of statics
	protected static Color MESSAGE_BODY_BG = Color.WHITE;

	public MessageViewer(MessageController control) {
		this.control = control;

		pane = getContentPane();
		pane.setLayout(new BorderLayout());

		header = new JPanel();
		header.setLayout(new BorderLayout());
		JLabel name = new JLabel(control.getHeader());
		name.setBorder(new EmptyBorder(5,20,5,0)); //top left bottom right (number order)
		back = new JButton("<");
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Back to menu screen
				JOptionPane.showMessageDialog(null, "Menu goes here.");
			}
		});
		header.add(name);
		header.add(back, BorderLayout.WEST);

		body = new JScrollPane(fillMessage());

		footer = new JPanel();
		footer.setLayout(new BorderLayout());
		JTextField textMessage = new JTextField();
		JButton sendMessage = new JButton("Send");
		sendMessage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!textMessage.getText().isBlank())
					control.sendMessage(textMessage.getText());
				textMessage.setText("");
				reloadMessageLog();
			}
		});
		footer.add(sendMessage, BorderLayout.EAST);
		footer.add(textMessage);

		pane.add(header, BorderLayout.NORTH);
		pane.add(body);
		pane.add(footer, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("WS Messenger");
		setSize(400, 600); //to be made uniform with other formats.
		setLocationRelativeTo(null);
		setVisible(true);
	}

	protected JPanel fillMessage() {
		bodyContent = new JPanel();
		bodyContent.setLayout(new GridBagLayout());

		JPanel base = new JPanel(new BorderLayout());
		base.setBackground(MESSAGE_BODY_BG);
		base.add(bodyContent, BorderLayout.SOUTH);

		GridBagConstraints messageConstraint = new GridBagConstraints();
		messageConstraint.gridx = 0;
		messageConstraint.gridy = GridBagConstraints.RELATIVE;
		messageConstraint.fill = GridBagConstraints.HORIZONTAL;
		messageConstraint.weightx = 1;

		for(int i = 0; i < control.getMessageCount(); i++) {
			JPanel message = new JPanel(new BorderLayout());
			message.setBorder(new EmptyBorder(2, 10, 2, 10));
			JLabel text;
			if(control.getMessageSender(i).equals(control.getUserSelf())) {
				text = new JLabel(control.getMessageText(i)); //prints user sent message
				text.setHorizontalAlignment(SwingConstants.RIGHT);
				message.setBackground(MESSAGE_BODY_BG);
			} else {
				text = new JLabel(control.getMessageSenderName(i) + ": " + control.getMessageText(i)); //prints friend name and message
				text.setHorizontalAlignment(SwingConstants.LEFT);
			}
			message.add(text);
			bodyContent.add(message, messageConstraint);
		}
		return base;
	}

	protected void reloadMessageLog() {
		body = new JScrollPane(fillMessage());
		pane.add(body);
		pane.revalidate();
	}

}
