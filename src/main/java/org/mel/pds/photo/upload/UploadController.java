package org.mel.pds.photo.upload;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.mel.pds.commons.AbstractController;

public class UploadController extends AbstractController {

	public UploadController(UploadView view, UploadModel model) {
		System.out.println("~~~~~CU~~~~~~~");

		view.setBtnListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				view.showMessage("You clicked Button!");
			}
		});
	}

}
