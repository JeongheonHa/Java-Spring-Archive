package ch07.innerclass;

import java.awt.*;
import java.awt.event.*;

public class AnonymousClass {

	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() { 
				public void actionPerformed(ActionEvent e) {
					System.out.println("ActionEvent occured!");
				}
			}
		);
	}
}
