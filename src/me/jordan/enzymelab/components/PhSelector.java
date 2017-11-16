package me.jordan.enzymelab.components;

import java.awt.Graphics;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

@SuppressWarnings("rawtypes")
public class PhSelector extends JComboBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public PhSelector(int x, int y, boolean isLess){
		super(new Integer[] {3, 5, 7, 9, 11});
		this.setLocation(x, y);
		this.setBorder(null);
		
		if(isLess){
			this.setSize(32, 15);
		}else{
			this.setSize(33, 15);
		}

		DefaultListCellRenderer dlcr = new DefaultListCellRenderer(); 
		dlcr.setHorizontalAlignment(DefaultListCellRenderer.CENTER); 
		this.setRenderer(dlcr);
		
		setUI(new BasicComboBoxUI() {
		    protected JButton createArrowButton() {
		        return new JButton() {
		            /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public int getWidth() {
		                return 0;
		            }
		        };
		    }
		});
	}
	
	@Override
	public void paint(Graphics g){
		this.setBorder(null);
		super.paint(g);
	}
	
}
