import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CapturadorDeTeclas {

	transient private static int position;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton();
		frame.add(button);
		frame.setVisible(true);
		button.addKeyListener(new KeyAdapter(){

			@Override
			public void keyPressed(KeyEvent e) {
				position = position + (e.getKeyCode() == 37
						? -1
						: 1);
			}
		});

		loop();
	}

	private static void loop() {
		while (true) {
			System.out.println("\n\n\n\n");
			System.out.println(line());
			waitABit();
		}
	}

	private static String line() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < position; i++) {
			result.append(" ");
		}
		return result.append("@").toString();
	}

	private static void waitABit() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}