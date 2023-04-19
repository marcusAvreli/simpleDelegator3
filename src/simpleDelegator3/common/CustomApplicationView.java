package simpleDelegator3.common;

import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;


public class CustomApplicationView extends JPanel{

	private JLabel lblCa;
	
	public CustomApplicationView() {
		initComponents();
	}
	
	public void initComponents() {
		
	
		
	lblCa = new JLabel();
	lblCa.setText("Custom Application view");
		
	

   
	

	
	
	
      // combo.setType(CustomApplication.class);

	
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				
		.addComponent(lblCa, GroupLayout.DEFAULT_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		//.addComponent(field, GroupLayout.DEFAULT_SIZE, 100,  GroupLayout.PREFERRED_SIZE)
		
		);
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		.addGroup(layout.createSequentialGroup()
					
		.addPreferredGap(ComponentPlacement.RELATED)
		.addComponent(lblCa, GroupLayout.DEFAULT_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		//.addComponent(field, GroupLayout.DEFAULT_SIZE, 100, GroupLayout.PREFERRED_SIZE)
		
		));
		 //add(jScrollPane1, java.awt.BorderLayout.CENTER);
	}
	/*
	   public void addView(JComponent view)
	    {
	        if(view != null)
	        {
	            rootPanel.add(view);
	            rootPanel.repaint(view.getBounds());
	        }
	    }

	    
	    public void cleanView() 
	    {
	        rootPanel.removeAll();
	        rootPanel.repaint();
	    }
	    */
}
