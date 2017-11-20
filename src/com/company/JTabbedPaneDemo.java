package com.company;

        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import javax.swing.JPasswordField;
        import javax.swing.*;


public class JTabbedPaneDemo extends JFrame implements ActionListener{
    private JTabbedPane t1 = new JTabbedPane();
    JPanel p1, p2, p3;
    private Container  c1;
    JButton logIn ,viewTest,back1,back2,exportFile, addquestion , editquestion ,savequestion;
    JLabel  passWord, welCome ,userName , choosesubject ;
    Choice chooseSubject ;
    JTextField username , questionEdit;
    JRadioButton mcq , truefalse , fillinblank ;
    JPasswordField password;

    JCheckBox ch1, ch2, ch3;
    int count = 0;
    private char getpass[];
    public JTabbedPaneDemo() {
        setup();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public void setup(){
        // TODO Auto-generated constructor stub
        setSize(300,300);
        p1 = new JPanel();


        c1 = getContentPane();

        p1.setLayout(new FlowLayout());

        userName = new JLabel("UserName");
        userName.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        username = new JTextField(10);
        username.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));

        passWord = new JLabel("Password");
        passWord.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));

        password = new JPasswordField(10);
        password.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        logIn = new JButton("Log In") ;
        logIn.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));

        c1.add(p1);

        p1.add(userName);
        p1.add(username);
        p1.add(passWord);
        p1.add(password);
        p1.add(logIn);
        String user = "Mukesh" ;
        String pass = "mukesh";

        t1.addTab("Welcome", p1);
        add(t1);

        setVisible(true);
        logIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                char[] temp_pwd= password.getPassword();
                String pwd = null;
                pwd=String.copyValueOf(temp_pwd);
                if( user.equals(username.getText()) && pass.equals(pwd) ){

                    setSize(700, 600);
                    setResizable(false);
                    t1.remove(p1);
                    addQuestion app1 = new addQuestion();
                    username.setText("");
                    password.setText("");
                }
                else
                {    username.setText("");
                    password.setText("");
                    JOptionPane.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.WARNING_MESSAGE) ;
                }
            }
        });



        // set to initial state.
        // something like recreate the deck,
        // clear hands and table, shuffle, and deal.
    }
    public class addQuestion extends JFrame {
       public addQuestion()
        {
            p2 = new JPanel(null);
            t1.addTab("Add Question", p2);
            addquestion =  new JButton("Add Question");
            editquestion =  new JButton("edit QUESTION");
            savequestion =  new JButton("Save Question");
            questionEdit = new JTextField(50);
            mcq = new JRadioButton("MCQ");
            truefalse = new JRadioButton("True/False");
            fillinblank = new JRadioButton("Fill In the blank");
            ButtonGroup bg = new ButtonGroup();
            bg.add(mcq);
            bg.add(truefalse);
            bg.add(fillinblank);
            choosesubject = new JLabel("Select Subject");

            chooseSubject = new Choice();
            chooseSubject.add("Maths");
            chooseSubject.add("Chemistry");
            chooseSubject.add("Physics");
            viewTest = new JButton("view Test") ;
            back1 = new JButton("Back") ;

            p2.setBounds(0,0,700,550);
            choosesubject.setBounds(20,10 ,130 ,20);
            chooseSubject.setBounds(160,10 ,130,20);
            addquestion.setBounds(20,180 ,80 ,20);
            editquestion.setBounds(20,220 ,80 ,20);
            savequestion.setBounds(20,230 ,80 ,20);
            questionEdit.setBounds(100,180 ,500 ,300);

            mcq.setBounds(250,10 ,100 ,20);
            truefalse.setBounds(350,10 ,100 ,20);
            fillinblank.setBounds(450,10 ,100 ,20);


            back1.setBounds(90,500 ,50 ,20);
            viewTest.setBounds(90,500 ,50 ,20);

            p2.add( addquestion );
            p2.add( editquestion);
            p2.add( savequestion);


            p2.add( questionEdit);
            p2.add( mcq );
            p2.add( truefalse);
            p2.add( fillinblank);



            p2.add(choosesubject);
            p2.add(chooseSubject);

            p2.add(back1);
            p2.add(viewTest);

            viewTest.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if(count == 0) {
                        viewTest app2 = new viewTest();
                        count = 1 ;
                    }
                    else
                    {

                        t1.remove(p3);
                       count = 0 ;
                    }

                }
            });


            back1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setup();
                    t1.remove(p2);
                    t1.remove(p3);

                }
            });


        }
    }
    public class viewTest extends JFrame {
        public viewTest()
        {
            p3 = new JPanel();
            t1.addTab("View Test", p3);

            exportFile = new JButton("export File") ;
            back2 = new JButton("Back") ;

            p3.add(exportFile);
            exportFile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "File Exported", "Done!", JOptionPane.WARNING_MESSAGE) ;
                }
            });

            p3.add(back2);
            back2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                  count = 0;
                    t1.remove(p3);
                }
            });
        }


    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                new JTabbedPaneDemo();

            }
        });
    }
}