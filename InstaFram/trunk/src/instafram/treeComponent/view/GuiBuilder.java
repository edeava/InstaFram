package instafram.treeComponent.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import instafram.treeComponent.model.Parametar;
import instafram.treeComponent.model.PredefinedParameter;

public class GuiBuilder {

	private Parametar parametar;
	public GuiBuilder(Parametar parametar) {
		this.parametar = parametar;
	}

	public static Component build(PredefinedParameter gui, Parametar parametar) {
		Box box = Box.createVerticalBox();
		if(gui == PredefinedParameter.NAME || gui == PredefinedParameter.AUTHOR) {
			JTextField tf = new JTextField(7);
			box.add(new JLabel(gui.toString()));
			box.add(tf);
		}
		else if(gui == PredefinedParameter.LOGO) {
			browse(box, true, "Odaberite logo");
		}
		else if(gui == PredefinedParameter.TERMS_AND_CONDITIONS) {
			JTextArea ta = new JTextArea("Suspendisse felis nunc, lobortis sed auctor sit amet, vulputate non dui. Mauris eleifend condimentum turpis, quis scelerisque quam imperdiet et. Quisque consequat enim ut egestas sagittis. Pellentesque scelerisque finibus urna sed condimentum. Donec faucibus interdum vulputate. Morbi laoreet augue in ornare eleifend. Morbi porta vitae risus eu feugiat. Vestibulum quis leo ac lacus volutpat malesuada. Integer sem ante, volutpat sit amet elit in, viverra venenatis urna.\r\n" + 
										 "\r\n" + 
										 "Sed ut mauris rhoncus, eleifend dui sit amet, congue nulla. " + 
										 "Donec consequat et odio vulputate iaculis. Nulla tincidunt elit vitae arcu placerat tincidunt. " +
										 "Integer quis tempus tellus. Quisque diam purus, luctus quis est at, elementum rhoncus odio. " +
										 "Nam varius purus congue accumsan rhoncus. Mauris ultrices quam eu nulla porttitor suscipit. " +
										 "Aliquam erat volutpat. Ut ex ligula, hendrerit et mollis sed, tristique ut lectus. Aliquam erat volutpat. " +
										 "Morbi mattis est nibh, non rutrum nisi posuere in. Nunc dapibus molestie laoreet. " +
										 "Phasellus vel leo at libero porttitor pulvinar id eget libero.", 5, 50);
			ta.setEditable(false);
			JScrollPane sp = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			
			box.add(sp);
		}
		else if(gui == PredefinedParameter.LOOK_AND_FEEL) {
			ButtonGroup bg = new ButtonGroup();
			JCheckBox cb1 = new JCheckBox("Windows");
			box.add(cb1);
			bg.add(cb1);
			JCheckBox cb2 = new JCheckBox("MacOS");
			box.add(cb2);
			bg.add(cb2);
			JCheckBox cb3 = new JCheckBox("Linux");
			box.add(cb3);
			bg.add(cb3);
		}
		else if(gui == PredefinedParameter.DESKTOP_SHORTCUT) {
			JCheckBox cb = new JCheckBox("Da li zelite desktop precicu?");
			box.add(cb);
		}
		else if(gui == PredefinedParameter.RUN_AFTER_FINISH) {
			JCheckBox cb = new JCheckBox("Da li zelite da pokrenete aplikaciju nakon zavrsetka instalacije?");
			box.add(cb);
		}
		else {
			Box b1 = Box.createHorizontalBox();
			
			JLabel lb = new JLabel(parametar.getVrednost());
			b1.add(lb);
			box.add(b1);
			
			if(gui == PredefinedParameter.TEXT) {
				JTextField tf1 = new JTextField(15);
				box.add(tf1);
			}
			else if(gui == PredefinedParameter.CHECK_BOX) {
				JCheckBox cb = new JCheckBox();
				box.add(cb);
			}
			else if(gui == PredefinedParameter.DROP_DOWN) {
				JComboBox<String> cb = new JComboBox<>();
				box.add(cb);
				JTextField tfC = new JTextField(10);
				JButton btn = new JButton("Dodaj");
				Box b2 = Box.createHorizontalBox();
				b2.add(tfC);
				b2.add(btn);
				box.add(b2);
				
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						cb.addItem(tfC.getText());
						
					}
				});
			}
			else if(gui == PredefinedParameter.CHOOSER) {
				browse(box, false, "");
			}
		}
		return box;
	}
	
	public static Box browse(Box box, boolean isPic, String label) {
		Box b = Box.createHorizontalBox();
		JTextField tf = new JTextField(15);
		JButton browse = new JButton("Browse");
		browse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				int approved = chooser.showOpenDialog(null);
				if(approved == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					tf.setText(file.toString());
					if(isPic) {
						box.remove(2);
						box.add(new JLabel(new ImageIcon(file.getPath())));
					}
				}
				
			}
		});
		
		box.add(new JLabel(label));
		b.add(tf);
		b.add(browse);
		box.add(b);
		box.add(new JLabel(""));
		
		return box;
	}
}
