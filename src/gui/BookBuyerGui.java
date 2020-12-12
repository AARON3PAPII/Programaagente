/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Aaron Ramos
 */
import agents.BookBuyerAgent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import agents.BookBuyerAgent ;
import java.awt.Color;
import  javax.swing.JTextArea ;

public class BookBuyerGui extends JFrame {
    private BookBuyerAgent myAgent;
    
    private JTextField nombreLibro;
    private JLabel tituloo;
    
    public BookBuyerGui(BookBuyerAgent a){
            super(a.getLocalName());
            
            myAgent = a;
            
            JPanel p = new JPanel();
            BorderLayout b= new BorderLayout(2,3);
                tituloo=new JLabel("Nombre del libro:");
                p.add(tituloo);
		nombreLibro = new JTextField(15);
		p.add(nombreLibro);
                
                
                JButton addButton = new JButton("COMPRAR");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					String title = nombreLibro.getText().trim();
				        JOptionPane . showMessageDialog ( BookBuyerGui . this , title);
                                        myAgent.setTitle(title);
                                        myAgent.setGuiContinue();					
					nombreLibro.setText("");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(BookBuyerGui.this, "Invalid values","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
                addButton.setBackground(Color.green);
		p.add(addButton);
		getContentPane().add(p, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
		    myAgent.doDelete();
		  }
		});
		
		setResizable(false);
    }
	
	public void showGui() {
	  pack();
          this.setSize(new Dimension(250,150));
          this.getContentPane().setBackground(Color.GRAY);
	  super.setVisible(true);
	}
}
    
    

