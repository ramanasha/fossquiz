import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Quiz extends JFrame{
	JPanel p=new JPanel();
	CardLayout cards=new CardLayout();
	int num = 1;
	boolean v = false;

	int wrongs = 0;
	int corrects=0;
	int total=9;
	
	String[][] answers={
		{"True","False"},
		{"PHP","Python","C++","Java"},
		{"Adobe Flash Player","Blender","Linux","Android"},
		{"Lazarus","Premake","make","None of the above"},
		{"The Open Source Institute","The Open Source Committee","The Open Source Initiative","The Open Source Board"},
		{"True","False"},
		{"True","False"},
		{"Microsoft","HP","Netscape","Apple"},
		{"Windows 10","Mac OS X","Linux","None of the above"},
	};
	
	RadioQuestion questions[]={
		
		new RadioQuestion(
			"Open source software is Freely Licensed Software.",
			answers[0],
			0,this
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
			"This popular open source build tool ensures that source files that have been updated are compiled into a new version of a program.?",
			answers[3],
			2,this
		),
		new RadioQuestion(
			"Which organization defines Open Source rules?",
			answers[4],
			1,this
		),
		new RadioQuestion(
			"MySql, Samba and Perl are Open Source software.",
			answers[5],
			0,this
		),
		new RadioQuestion(
			"True or False, Open Source software is expensive for its users.",
			answers[6],
			1,this
		),
		new RadioQuestion(
			"Which was the first commercial company to put its software in Open Source?",
			answers[7],
			2,this
		),
		new RadioQuestion(
			"Which of these is an example of FOSS?",
			answers[8],
			1,this
		)
	};

	public static void main(String args[]){
		new Quiz();
	}
	
	public Quiz(){

		super("FOSS Quiz");
		setResizable(true);
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		p.setLayout(cards);
		num= questions.length;
		for(int i=0;i<num;i++){
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
			int i=0;
 			i=r.nextInt(num);
 			cards.show(p,"q"+i);
		}
	}
	
	public void showSummary(){
		JOptionPane.showMessageDialog(null,"Here are your results"+
 			"\nScore: \t"+corrects+
 
 			"\nTotal: 9"
		);
		System.exit(0);
	}
}