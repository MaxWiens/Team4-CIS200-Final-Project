import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window.Type;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class PuzzleCubeSolverApp extends JFrame {
	private JPanel cubeVisual;
	private JPanel contentPane;
	private JLabel lblTotal;
	private JTextField textField;
	private Cube cube;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleCubeSolverApp frame = new PuzzleCubeSolverApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public PuzzleCubeSolverApp() {
		cube = new Cube();
		
		setResizable(false);
		setTitle("Puzzle Cube Solver");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 224, 434, 43);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateGUI(cube.getPreviousStep());
			}
		});
		panel_1.add(btnPrevious);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGUI(cube.getNextStep());
			}
		});
		panel_1.add(btnNext);
		
		JButton btnScramble = new JButton("Scramble");
		btnScramble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cube.scramble();
				updateGUI(cube.getStep(0));
			}
		});
		panel_1.add(btnScramble);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setBorder(null);
		
		JLabel lblStep = new JLabel("Step:");
		panel_2.add(lblStep);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setText("0");
		textField.setColumns(3);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateGUI(cube.getStep(Integer.parseInt(textField.getText())));
				}
				catch(NumberFormatException ex) {}
				catch(IndexOutOfBoundsException ex) {}
			}
		});
		
		lblTotal = new JLabel("of ___");
		panel_2.add(lblTotal);
		
		cubeVisual = new JPanel();
		cubeVisual.setBounds(126, 5, 192, 144);
		contentPane.add(cubeVisual);
		cubeVisual.setLayout(null);
		
		JPanel topFace = new JPanel();
		topFace.setBounds(48, 0, 48, 48);
		cubeVisual.add(topFace);
		topFace.setLayout(null);
		
		JPanel top0_0 = new JPanel();
		top0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top0_0.setBackground(Color.WHITE);
		top0_0.setBounds(0, 0, 16, 16);
		topFace.add(top0_0);
		
		JPanel top0_1 = new JPanel();
		top0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top0_1.setBackground(Color.WHITE);
		top0_1.setBounds(16, 0, 16, 16);
		topFace.add(top0_1);
		
		JPanel top0_2 = new JPanel();
		top0_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		top0_2.setBackground(Color.WHITE);
		top0_2.setBounds(32, 0, 16, 16);
		topFace.add(top0_2);
		
		JPanel top1_0 = new JPanel();
		top1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top1_0.setBackground(Color.WHITE);
		top1_0.setBounds(0, 16, 16, 16);
		topFace.add(top1_0);
		
		JPanel top1_1 = new JPanel();
		top1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top1_1.setBackground(Color.WHITE);
		top1_1.setBounds(16, 16, 16, 16);
		topFace.add(top1_1);
		
		JPanel top1_2 = new JPanel();
		top1_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		top1_2.setBackground(Color.WHITE);
		top1_2.setBounds(32, 16, 16, 16);
		topFace.add(top1_2);
		
		JPanel top2_0 = new JPanel();
		top2_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top2_0.setBackground(Color.WHITE);
		top2_0.setBounds(0, 32, 16, 16);
		topFace.add(top2_0);
		
		JPanel top2_1 = new JPanel();
		top2_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		top2_1.setBackground(Color.WHITE);
		top2_1.setBounds(16, 32, 16, 16);
		topFace.add(top2_1);
		
		JPanel top2_2 = new JPanel();
		top2_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		top2_2.setBackground(Color.WHITE);
		top2_2.setBounds(32, 32, 16, 16);
		topFace.add(top2_2);
		
		JPanel centerFace = new JPanel();
		centerFace.setBounds(48, 48, 48, 48);
		cubeVisual.add(centerFace);
		centerFace.setLayout(null);
		
		JPanel center0_0 = new JPanel();
		center0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center0_0.setBackground(Color.RED);
		center0_0.setBounds(0, 0, 16, 16);
		centerFace.add(center0_0);
		
		JPanel center0_1 = new JPanel();
		center0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center0_1.setBackground(Color.RED);
		center0_1.setBounds(16, 0, 16, 16);
		centerFace.add(center0_1);
		
		JPanel center0_2 = new JPanel();
		center0_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center0_2.setBackground(Color.RED);
		center0_2.setBounds(32, 0, 16, 16);
		centerFace.add(center0_2);
		
		JPanel center1_0 = new JPanel();
		center1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center1_0.setBackground(Color.RED);
		center1_0.setBounds(0, 16, 16, 16);
		centerFace.add(center1_0);
		
		JPanel center1_1 = new JPanel();
		center1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center1_1.setBackground(Color.RED);
		center1_1.setBounds(16, 16, 16, 16);
		centerFace.add(center1_1);
		
		JPanel center1_2 = new JPanel();
		center1_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center1_2.setBackground(Color.RED);
		center1_2.setBounds(32, 16, 16, 16);
		centerFace.add(center1_2);
		
		JPanel center2_0 = new JPanel();
		center2_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center2_0.setBackground(Color.RED);
		center2_0.setBounds(0, 32, 16, 16);
		centerFace.add(center2_0);
		
		JPanel center2_1 = new JPanel();
		center2_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center2_1.setBackground(Color.RED);
		center2_1.setBounds(16, 32, 16, 16);
		centerFace.add(center2_1);
		
		JPanel center2_2 = new JPanel();
		center2_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		center2_2.setBackground(Color.RED);
		center2_2.setBounds(32, 32, 16, 16);
		centerFace.add(center2_2);
		
		JPanel leftFace = new JPanel();
		leftFace.setBounds(0, 48, 48, 48);
		cubeVisual.add(leftFace);
		leftFace.setLayout(null);
		
		JPanel left0_0 = new JPanel();
		left0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left0_0.setBackground(Color.GREEN);
		left0_0.setBounds(0, 0, 16, 16);
		leftFace.add(left0_0);
		
		JPanel left0_1 = new JPanel();
		left0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left0_1.setBackground(Color.GREEN);
		left0_1.setBounds(16, 0, 16, 16);
		leftFace.add(left0_1);
		
		JPanel left0_2 = new JPanel();
		left0_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left0_2.setBackground(Color.GREEN);
		left0_2.setBounds(32, 0, 16, 16);
		leftFace.add(left0_2);
		
		JPanel left1_0 = new JPanel();
		left1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left1_0.setBackground(Color.GREEN);
		left1_0.setBounds(0, 16, 16, 16);
		leftFace.add(left1_0);
		
		JPanel left1_1 = new JPanel();
		left1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left1_1.setBackground(Color.GREEN);
		left1_1.setBounds(16, 16, 16, 16);
		leftFace.add(left1_1);
		
		JPanel left1_2 = new JPanel();
		left1_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		left1_2.setBackground(Color.GREEN);
		left1_2.setBounds(32, 16, 16, 16);
		leftFace.add(left1_2);
		
		JPanel left2_0 = new JPanel();
		left2_0.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		left2_0.setBackground(Color.GREEN);
		left2_0.setBounds(0, 32, 16, 16);
		leftFace.add(left2_0);
		
		JPanel left2_1 = new JPanel();
		left2_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		left2_1.setBackground(Color.GREEN);
		left2_1.setBounds(16, 32, 16, 16);
		leftFace.add(left2_1);
		
		JPanel left2_2 = new JPanel();
		left2_2.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		left2_2.setBackground(Color.GREEN);
		left2_2.setBounds(32, 32, 16, 16);
		leftFace.add(left2_2);
		
		JPanel rightFace = new JPanel();
		rightFace.setBounds(96, 48, 48, 48);
		cubeVisual.add(rightFace);
		rightFace.setLayout(null);
		
		JPanel right0_0 = new JPanel();
		right0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right0_0.setBackground(Color.BLUE);
		right0_0.setBounds(0, 0, 16, 16);
		rightFace.add(right0_0);
		
		JPanel right0_1 = new JPanel();
		right0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right0_1.setBackground(Color.BLUE);
		right0_1.setBounds(16, 0, 16, 16);
		rightFace.add(right0_1);
		
		JPanel right0_2 = new JPanel();
		right0_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right0_2.setBackground(Color.BLUE);
		right0_2.setBounds(32, 0, 16, 16);
		rightFace.add(right0_2);
		
		JPanel right1_0 = new JPanel();
		right1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right1_0.setBackground(Color.BLUE);
		right1_0.setBounds(0, 16, 16, 16);
		rightFace.add(right1_0);
		
		JPanel right1_1 = new JPanel();
		right1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right1_1.setBackground(Color.BLUE);
		right1_1.setBounds(16, 16, 16, 16);
		rightFace.add(right1_1);
		
		JPanel right1_2 = new JPanel();
		right1_2.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		right1_2.setBackground(Color.BLUE);
		right1_2.setBounds(32, 16, 16, 16);
		rightFace.add(right1_2);
		
		JPanel right2_0 = new JPanel();
		right2_0.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		right2_0.setBackground(Color.BLUE);
		right2_0.setBounds(0, 32, 16, 16);
		rightFace.add(right2_0);
		
		JPanel right2_1 = new JPanel();
		right2_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		right2_1.setBackground(Color.BLUE);
		right2_1.setBounds(16, 32, 16, 16);
		rightFace.add(right2_1);
		
		JPanel right2_2 = new JPanel();
		right2_2.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		right2_2.setBackground(Color.BLUE);
		right2_2.setBounds(32, 32, 16, 16);
		rightFace.add(right2_2);
		
		JPanel backFace = new JPanel();
		backFace.setBounds(144, 48, 48, 48);
		cubeVisual.add(backFace);
		backFace.setLayout(null);
		
		JPanel back0_0 = new JPanel();
		back0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		back0_0.setBackground(Color.ORANGE);
		back0_0.setBounds(0, 0, 16, 16);
		backFace.add(back0_0);
		
		JPanel back0_1 = new JPanel();
		back0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		back0_1.setBackground(Color.ORANGE);
		back0_1.setBounds(16, 0, 16, 16);
		backFace.add(back0_1);
		
		JPanel back0_2 = new JPanel();
		back0_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		back0_2.setBackground(Color.ORANGE);
		back0_2.setBounds(32, 0, 16, 16);
		backFace.add(back0_2);
		
		JPanel back1_0 = new JPanel();
		back1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		back1_0.setBackground(Color.ORANGE);
		back1_0.setBounds(0, 16, 16, 16);
		backFace.add(back1_0);
		
		JPanel back1_1 = new JPanel();
		back1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		back1_1.setBackground(Color.ORANGE);
		back1_1.setBounds(16, 16, 16, 16);
		backFace.add(back1_1);
		
		JPanel back1_2 = new JPanel();
		back1_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		back1_2.setBackground(Color.ORANGE);
		back1_2.setBounds(32, 16, 16, 16);
		backFace.add(back1_2);
		
		JPanel back2_0 = new JPanel();
		back2_0.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		back2_0.setBackground(Color.ORANGE);
		back2_0.setBounds(0, 32, 16, 16);
		backFace.add(back2_0);
		
		JPanel back2_1 = new JPanel();
		back2_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		back2_1.setBackground(Color.ORANGE);
		back2_1.setBounds(16, 32, 16, 16);
		backFace.add(back2_1);
		
		JPanel back2_2 = new JPanel();
		back2_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		back2_2.setBackground(Color.ORANGE);
		back2_2.setBounds(32, 32, 16, 16);
		backFace.add(back2_2);
		
		JPanel bottomFace = new JPanel();
		bottomFace.setLayout(null);
		bottomFace.setBounds(48, 96, 48, 48);
		cubeVisual.add(bottomFace);
		
		JPanel bottom0_0 = new JPanel();
		bottom0_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		bottom0_0.setBackground(Color.YELLOW);
		bottom0_0.setBounds(0, 0, 16, 16);
		bottomFace.add(bottom0_0);
		
		JPanel bottom0_1 = new JPanel();
		bottom0_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		bottom0_1.setBackground(Color.YELLOW);
		bottom0_1.setBounds(16, 0, 16, 16);
		bottomFace.add(bottom0_1);
		
		JPanel bottom0_2 = new JPanel();
		bottom0_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		bottom0_2.setBackground(Color.YELLOW);
		bottom0_2.setBounds(32, 0, 16, 16);
		bottomFace.add(bottom0_2);
		
		JPanel bottom1_0 = new JPanel();
		bottom1_0.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		bottom1_0.setBackground(Color.YELLOW);
		bottom1_0.setBounds(0, 16, 16, 16);
		bottomFace.add(bottom1_0);
		
		JPanel bottom1_1 = new JPanel();
		bottom1_1.setBorder(new MatteBorder(1, 1, 0, 0, (Color) new Color(0, 0, 0)));
		bottom1_1.setBackground(Color.YELLOW);
		bottom1_1.setBounds(16, 16, 16, 16);
		bottomFace.add(bottom1_1);
		
		JPanel bottom1_2 = new JPanel();
		bottom1_2.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		bottom1_2.setBackground(Color.YELLOW);
		bottom1_2.setBounds(32, 16, 16, 16);
		bottomFace.add(bottom1_2);
		
		JPanel bottom2_0 = new JPanel();
		bottom2_0.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		bottom2_0.setBackground(Color.YELLOW);
		bottom2_0.setBounds(0, 32, 16, 16);
		bottomFace.add(bottom2_0);
		
		JPanel bottom2_1 = new JPanel();
		bottom2_1.setBorder(new MatteBorder(1, 1, 1, 0, (Color) new Color(0, 0, 0)));
		bottom2_1.setBackground(Color.YELLOW);
		bottom2_1.setBounds(16, 32, 16, 16);
		bottomFace.add(bottom2_1);
		
		JPanel bottom2_2 = new JPanel();
		bottom2_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		bottom2_2.setBackground(Color.YELLOW);
		bottom2_2.setBounds(32, 32, 16, 16);
		bottomFace.add(bottom2_2);
		
		JLabel lblInstruction = new JLabel("Instruction");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		lblInstruction.setBounds(5, 199, 434, 14);
		contentPane.add(lblInstruction);
		
		updateGUI(cube.getStep(0));
	}
	
	public void updateGUI(SolveInstruction solveInstruction) {
		//updates count
		lblTotal.setText("of "+ cube.getTotalSteps());
		
		//updates instructions
		JLabel lblInstruction = (JLabel) contentPane.getComponent(2);
		lblInstruction.setText(solveInstruction.getInstruction());
		//updates cube visual
		char[][][] sides = solveInstruction.getCube();
		for(int f=0; f<6;f++) {
			JPanel face = (JPanel) cubeVisual.getComponent(f);
			for(int r=0; r<sides[0].length; r++) {
				for(int c=0; c<sides[0][r].length; c++) {
					JPanel square  = (JPanel) face.getComponent((r*3)+c);
					switch(sides[0][r][c]) {
						case 'R':
							square.setBackground(Color.RED);
							break;
						case 'B':
							square.setBackground(Color.BLUE);
							break;
						case 'W':
							square.setBackground(Color.WHITE);
							break;
						case 'G':
							square.setBackground(Color.GREEN);
							break;
						case 'O':
							square.setBackground(Color.ORANGE);
							break;
						case 'Y':
							square.setBackground(Color.YELLOW);
							break;
						default:
							square.setBackground(Color.GRAY);
					}
				}
			}
		}
	}
}
