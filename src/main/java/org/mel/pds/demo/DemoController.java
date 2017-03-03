package org.mel.pds.demo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import org.mel.pds.commons.AbstractController;

public class DemoController extends AbstractController {

	private DemoView view;
	private DemoModel model;

	public DemoController(DemoView view, DemoModel model) {
		this.view = view;
		this.model = model;

		fetchDataFromDB();

		refreshView();

		bindListener();
	}

	private void bindListener() {
		view.btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showMessage(model.getStatus());
			}
		});

		view.firstnameField.getDocument().addDocumentListener(new DeferedDocumentListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.getPerson().setFirstname(view.firstnameField.getText());
				view.firstnameField.setFont(view.firstnameField.getFont().deriveFont(model.getPerson().getFirstname().equals(model.getOriginalPerson().getFirstname()) ? Font.PLAIN : Font.ITALIC));
			}
		}));

		view.lastnameField.getDocument().addDocumentListener(new DeferedDocumentListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				model.getPerson().setLastname(view.lastnameField.getText());
				view.lastnameField.setFont(view.lastnameField.getFont().deriveFont(model.getPerson().getLastname().equals(model.getOriginalPerson().getLastname()) ? Font.PLAIN : Font.ITALIC));
			}
		}));
	}

	private void fetchDataFromDB() {
		Person person = new Person("Mel", "Liu");
		person.addAddress(new Address("江苏省", "苏州市", "吴中区", "红树湾14-2802"));
		person.addAddress(new Address("江苏省", "苏州市", "沧浪区", "保兴里1-302"));
		model.setPerson(person);
	}

	private void refreshView() {
		view.firstnameField.setText(model.getPerson().getFirstname());
		view.lastnameField.setText(model.getPerson().getLastname());
		view.table.setModel(new TableModel() {

			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

			}

			@Override
			public void removeTableModelListener(TableModelListener l) {

			}

			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return false;
			}

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				return model.getPerson().getAddresses().get(rowIndex).toArray()[columnIndex];
			}

			@Override
			public int getRowCount() {
				return model.getPerson().getAddresses().size();
			}

			@Override
			public String getColumnName(int columnIndex) {
				return new String[] { "Province", "City", "Dist", "Street" }[columnIndex];
			}

			@Override
			public int getColumnCount() {
				return 4;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}

			@Override
			public void addTableModelListener(TableModelListener l) {

			}
		});
	}

}
