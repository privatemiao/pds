package org.mel.pds.component;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextField;

public class CharacterTextField extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TextFieldStatus status = TextFieldStatus.NORMAL;

	public CharacterTextField(int columns) {
		super(columns);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (status == TextFieldStatus.NORMAL || status == TextFieldStatus.CORRECT) {
			return;
		}

		Graphics2D g2 = (Graphics2D) g;
		BufferedImage image = null;
		try {
			int count = this.getWidth() / 4;
			if (this.getWidth() % 4 > 0) {
				count += 1;
			}

			image = status == TextFieldStatus.ERROR ? ImageIO.read(getClass().getResourceAsStream("/wavy-error.gif")) : ImageIO.read(getClass().getResourceAsStream("/wavy-warning.gif"));

			for (int i = 0; i < count; i++) {
				g2.drawImage(image, (i * 4), this.getHeight() - 3, null);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			g2.dispose();
		}
	}

	public TextFieldStatus getStatus() {
		return status;
	}

	public void validateCorrect() {
		status = TextFieldStatus.CORRECT;
	}

	public void validateWarning() {
		status = TextFieldStatus.WARNING;
	}

	public void validateError() {
		status = TextFieldStatus.ERROR;
	}
}
