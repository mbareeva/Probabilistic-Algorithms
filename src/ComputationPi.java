import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.awt.Point;

public class ComputationPi extends JComponent{
		public static int SIZE = 500;
		private static int radius = 100;
		private static int width = 2*radius;
		JFrame frame;
		JPanel panel;

		@SuppressWarnings("serial")
		public void display() {
			frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel = new JPanel() {
				@Override
				public void paint(Graphics g) {
					super.paint(g);
					draw(g, getSize());
					g.drawOval(10, 10, width, width);
					g.drawRect(10, 10, width, width);
				}
			};
			panel.addComponentListener(new ComponentAdapter() {
				@Override
				public void componentResized(ComponentEvent e) {
					panel.repaint();
				}
			});
			frame.setLayout(new BorderLayout());
			frame.add(panel, BorderLayout.CENTER);
			frame.pack();
			frame.setSize(SIZE, 300);
			frame.setVisible(true);
		}

		public static void main(String[] args) {
			ComputationPi figure = new ComputationPi();
			figure.display();
			// For observing changes of pi values
			computePi(100);
			computePi(1000);
			computePi(10000);
		}

		public void draw(Graphics g, Dimension size) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setBackground(Color.white);
			g2.clearRect(0, 0, size.width, size.height);	
		}
		
		/*
		 * Count the pi for circle inscribed in the square.
		 * @param randomNums How many x,y points to be created in the circle.
		 */
		public static void computePi(int randomNums) {
		
		
			int pointsInCircle = 0;
			for(int i = 0; i < randomNums; i++) {
			int x = (int) (10 + Math.random() * width);
			int y = (int) (10 + Math.random() * width);
			Point p = new Point(x, y);
			
			if(pointsInCircle(p)) {
				pointsInCircle ++;
	}
}	//count the ratio of circle's points and square's points
			double pi = (double) pointsInCircle / randomNums;
			System.out.println(pi*4.0);
}
		
		/*
		 * Check whether the point is in the circle.
		 * @param p The point that is on circle's circumference.
		 * return True if the point is in the circle area.
		 */
		public static boolean pointsInCircle(Point p) {
			double distance = (int) Math.sqrt((Math.pow((p.x - (double) width/2), 2) + Math.pow((p.y - (double) width/2), 2)));
			return (distance <= radius);	
		}
}


