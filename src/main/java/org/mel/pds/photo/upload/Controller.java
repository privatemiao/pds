package org.mel.pds.photo.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	public Controller(View view, Model model) {
		System.out.println("~~~~~CU~~~~~~~");

		view.setBtnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showMessage("You clicked Button!");
			}
		});
	}


}
