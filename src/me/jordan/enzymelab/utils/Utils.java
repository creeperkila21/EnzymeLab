package me.jordan.enzymelab.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextArea;

import me.jordan.enzymelab.EnzymeLab;

public class Utils {

	public static BufferedImage getImage(String name) {

		BufferedImage img = null;

		try {
			img = ImageIO.read(EnzymeLab.class
					.getResourceAsStream("/resources/" + name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return img;
	}

	public static void loadInfo(JTextArea text) throws IOException {

		String sb = "Purpose\r\n" + "In this investigation you will\r\n"
				+ "determine the effects of substrate\r\n"
				+ "concentration and pH on the initial\r\n"
				+ "rate of an enzyme-catalyzed\r\n" + "reaction.\r\n\n"
				+ "Objections:\r\n" + " 1. Determine the effect of\r\n"
				+ "    substrate concentration on\r\n"
				+ "    the initial rate of an enzyme-\r\n"
				+ "    catalyzed reaction.\r\n" + "	   \r\n"
				+ " 2. Determine the effect of pH on\r\n"
				+ "    the initial rate of an enzyme-\r\n"
				+ "    catalyzed reaction.\r\n" + "	   \r\n\n" + "Procedure\r\n"
				+ "Click the TV/VCR. Then click the\r\n"
				+ "Play button on the video controller.\r\n"
				+ "Watch an animation about enzyme\r\n" + "action.\r\n"
				+ "Click More Information to read\r\n"
				+ "about enzymes and substrates\r\n\n"
				+ "To conduct the experiment, adjust\r\n"
				+ "the pH level of the test tubes by\r\n"
				+ "clicking the up and down arrows, \r\n"
				+ "then add substrate to each of the\r\n"
				+ "test tubes that already contain an\r\n"
				+ "enzyme solution. Click and drag a\r\n"
				+ "piece of weighing paper with the\r\n"
				+ "powdered substrate to a test tube.\r\n"
				+ "Note: Assume that the enzyme\r\n"
				+ "concentration in each test tube is\r\n" + "constant.\r\n\n"
				+ "Click the copmuter monitor to see\r\n"
				+ "the digital counter table that\r\n"
				+ "displays the number of product\r\n"
				+ "molecules formed during the first\r\n"
				+ "minute in each of the five test\r\n"
				+ "tubes. This is the initial reaction rate.\r\n"
				+ "of this enzyme-catalyzed reaction.\r\n"
				+ "Click the Table button to record the\r\n data in the Table.\r\n\n"
				+ "Click the Reset button. Repeat the\r\n"
				+ "experiment using different amounts\r\n"
				+ "of substrate at a constant pH value.\r\n"
				+ "Or, use one substrate at five\r\n"
				+ "different pH levels. Record your\r\n"
				+ "results in the Table. When all the\r\n"
				+ "data has been collected an\r\n"
				+ "recorded, click the Graph button to\r\n"
				+ "see a graph of the results.\r\n\n"
				+ "After you have performed the\r\n"
				+ "experiment, click the Journal button\r\n"
				+ "and answer the Analysis questions. \r\n";
		text.setText(sb);
	}

}
