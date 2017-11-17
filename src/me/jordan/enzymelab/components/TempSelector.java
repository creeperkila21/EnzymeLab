package me.jordan.enzymelab.components;

import java.awt.Graphics;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

/**
 * Jordan Cole
 * Nov 16, 2017
 * Period 2
 */

@SuppressWarnings("rawtypes")
public class TempSelector extends JComboBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked") //15 29 37 46 58
	public TempSelector(int x, int y, boolean isLess){
		super(new String[] {"15C", "29C", "37C", "46C", "58C"});
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
