import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;

public class Quiz extends JFrame{
	JPanel p=new JPanel();
	CardLayout cards=new CardLayout();
	int numQs = 1;
	int wrongs = 0;
	int corrects=0;
	int total=9;
	
	String[][] answers={
		{"Freely Licensed Software","Proprietary software"},
		{"PHP","Python","C++","Java"},
		{"Adobe Flash Player","Blender","Linux","Android"},
		{"Lazarus","Premake","make","None of the above"},
		{"The Open Source Institute","The Open Source Committee","The Open Source Initiative","The Open Source Board"},
		{"True","False"},
		{"True","False"},
		{"Microsoft","HP","Netscape","Apple"},
		{"The Lion King","Hamlet","Death of The Salesmen","Phantom of the Opera"},
	};
	
	RadioQuestion questions[]={
		
		new RadioQuestion(
			"FOSS is computer software that can be classified as?",
			answers[0],
			3,this
		),
		new RadioQuestion(
			"Which language is used to write the most open source packages?",
			answers[1],
			3,this
		),
		new RadioQuestion(
			"Which of these is NOT an example of FOSS?",
			answers[2],
			0,this
		),

		new RadioQuestion(
			"This popular open source build tool ensures that source files that have been updated are compiled into a new version (or build) of a program.?",
			answers[3],
			2,this
		),
		new RadioQuestion(
			"What organization defines Open Source rules?",
			answers[4],
			1,this
		),
		new RadioQuestion(
			"MySql, Samba and Perl are Open Source software.",
			answers[5],
			0,this
		),
		new RadioQuestion(
			"True or False, Open Source software is more expensive for its users.",
			answers[6],
			1,this
		),
		new RadioQuestion(
			"Which was the first commercial company to put its software in Open Source?",
			answers[7],
			2,this
		),
		new RadioQuestion(
			"Which of these plays is made by shakespeare?",
			answers[8],
			1,this
		)
	};

	public static void main(String args[]){
		new Quiz();
	}
	
	public Quiz(){
		super("Quiz Game");
		setResizable(true);
		setSize(500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(cards);
		numQs= questions.length;
		for(int i=0;i<numQs;i++){
			p.add(questions[i],"q"+i);
		}
		
		add(p);
		setVisible(true);
	}
	
	public void next(){
		if((corrects+wrongs)==total){
			showSummary();
		}else{
			Random r=new Random();
			boolean found=false;
			int i=0;
			while(!found){
				i=r.nextInt(numQs);
				if(!questions[i].used){
					found=true;
				}
			}
			cards.show(p,"q"+i);
		}
	}
	
	public void showSummary(){
		JOptionPane.showMessageDialog(null,"Here are your results"+
 			"\nNumber of Correct Answers: \t"+corrects+
 			"\nNumber of Wrong Answers: \t"+wrongs+

 			"\nTotal: 9"
		);
		System.exit(0);
	}
}