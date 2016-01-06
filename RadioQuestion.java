import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.CardLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class RadioQuestion extends JPanel implements ActionListener{
	int correctAns;
	Quiz quiz;	
 
 	boolean count = false;
	boolean wcount = false;
	int selected;
	boolean used = false;
 	JPanel qPanel=new JPanel();
 	JPanel aPanel=new JPanel();
	JRadioButton[] responses;
	ButtonGroup group=new ButtonGroup();
 	JPanel botPanel=new JPanel();
	JButton next=new JButton("Next");
	JButton finish=new JButton("Finish");
 
	
	public RadioQuestion(String q, String[] options, int ans, Quiz quiz){
		this.quiz=quiz;
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		correctAns=ans;
 		qPanel.add(new JLabel(q));
		add(qPanel);
 		responses=new JRadioButton[options.length];
		for(int i=0;i<options.length;i++){
			responses[i]=new JRadioButton(options[i]);
			responses[i].addActionListener(this);
			group.add(responses[i]);
			aPanel.add(responses[i]);
		}
		add(aPanel);
 		next.addActionListener(this);
		finish.addActionListener(this);
		botPanel.add(next);
		botPanel.add(finish);
		add(botPanel);
	}
	
	public void actionPerformed(ActionEvent e){
		Object src=e.getSource();
 		if(src.equals(next) ){
			showResult(); 
 			quiz.next();
		}
 		if(src.equals(finish)){
			quiz.showSummary();
		}
 		for(int i=0;i<responses.length;i++){
			if(src==responses[i]){
				selected=i;
			}
		}
	}
	
	public void showResult(){
		String text=responses[selected].getText();
		quiz.total++;
		if(selected==correctAns && count == false){
			quiz.corrects++;

			count = true;
  		}
  		else if(selected != correctAns && wcount == false)
  		{
			quiz.wrongs++;
			wcount = true;
		}
	}
}