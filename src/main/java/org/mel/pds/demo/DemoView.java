package org.mel.pds.demo;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.mel.pds.commons.AbstractView;
import org.mel.pds.component.CharacterTextField;

import net.miginfocom.swing.MigLayout;

public class DemoView extends AbstractView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CharacterTextField firstnameField = new CharacterTextField(10);
	protected CharacterTextField lastnameField = new CharacterTextField(10);
	
	protected JTable table = new JTable();
	
	protected JButton btn = new JButton("Status");
	
	
	
	public DemoView() {
		setLayout(new MigLayout("", "[]10[]", "[]10[]"));
		setBackground(Color.WHITE);

		add(new JLabel("Firstname"));
		add(firstnameField, "growx, wrap");
		add(new JLabel("Lastname"));
		add(lastnameField, "growx, wrap");

		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, "span, growx");
		
		add(btn);
		
		firstnameField.validateError();
		lastnameField.validateWarning();
	}

	@Override
	public String getTitle() {
		return "Demo";
	}

}
