import java.awt.*;
import java.awt.event.*;

class OnlineTest extends Frame implements ActionListener {
    Label l;
    CheckboxGroup cbg;
    Checkbox[] cb = new Checkbox[4];
    Button b1, b2;
    int count = 0, current = 0;
    int[] m = new int[10];

    OnlineTest(String s) {
        super(s);
        l = new Label();
        add(l);

        cbg = new CheckboxGroup();
        for (int i = 0; i < 4; i++) {
            cb[i] = new Checkbox();
            add(cb[i]);
            cb[i].setCheckboxGroup(cbg);
        }

        b1 = new Button("Next");
        b2 = new Button("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);

        setQuestions();
        l.setBounds(30, 40, 450, 20);

        for (int i = 0, y = 0; i < 4; i++, y += 30) {
            cb[i].setBounds(50, 80 + y, 100, 20);
        }

        b1.setBounds(100, 200, 100, 30);
        b2.setBounds(270, 200, 100, 30);

        setLayout(null);
        setSize(450, 300);
        setLocation(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (checkAnswer())
                count++;
            current++;
            setQuestions();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setLabel("Result");
            }
        }

        if (e.getActionCommand().equals("Bookmark")) {
            Button bk = new Button("Bookmark" + (current + 1));
            bk.setBounds(350, 20 + (current * 30), 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[current] = current;
            current++;
            setQuestions();
            if (current == 9)
                b2.setLabel("Result");
            setVisible(false);
            setVisible(true);
        }

        for (int i = 0, y = 1; i < current; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (checkAnswer())
                    count++;
                current = m[y - 1];
                setQuestions();
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (checkAnswer())
                count++;
            JOptionPane.showMessageDialog(this, "Correct answers: " + count);
            System.exit(0);
        }
    }

    void setQuestions() {
        cb[3].setState(true);
        if (current == 0) {
            l.setText("Que1: Scanner is available in which package?");
            cb[0].setLabel("A. programming language");
            cb[1].setLabel("B. A coffee brand");
            cb[2].setLabel("C. util");
            cb[3].setLabel("D. applet");
        }

        if (current == 1) {
            l.setText("Que2: What is the entry point of the program?");
            cb[0].setLabel("A. main()");
            cb[1].setLabel("B. start()");
            cb[2].setLabel("C. init()");
            cb[3].setLabel("D. Begin()");
        }

        if (current == 2) {
            l.setText("Que3: Which package is directly available to our class without importing it?");
            cb[0].setLabel("A. swing");
            cb[1].setLabel("B. applet");
            cb[2].setLabel("C. net");
            cb[3].setLabel("D. lang");
        }

        if (current == 3) {
            l.setText("Que4: String class is defined in which package?");
            cb[0].setLabel("A. lang");
            cb[1].setLabel("B. Swing");
            cb[2].setLabel("C. Applet");
            cb[3].setLabel("D. awt");
        }

        if (current == 4) {
            l.setText("Que5: How do you get input in Java?");
            cb[0].setLabel("A. input()");
            cb[1].setLabel("B. System.in");
            cb[2].setLabel("C. cin");
            cb[3].setLabel("D. scanf()");
        }

        if (current == 5) {
            l.setText("Que6: Which one among these is not a keyword?");
            cb[0].setLabel("A. class");
            cb[1].setLabel("B. int");
            cb[2].setLabel("C. get");
            cb[3].setLabel("D. if");
        }

        if (current == 6) {
            l.setText("Que7: Which of the following is the loop in Java?");
            cb[0].setLabel("A. if");
            cb[1].setLabel("B. for");
            cb[2].setLabel("C. else");
            cb[3].setLabel("D. switch");
        }

        if (current == 7) {
            l.setText("Que8: Which keyword is used for inheritance?");
            cb[0].setLabel("A. if");
            cb[1].setLabel("B. extends");
            cb[2].setLabel("C. equals");
            cb[3].setLabel("D. while");
        }

        if (current == 8) {
            l.setText("Que9: Which of these is not a valid access specifier in Java?");
            cb[0].setLabel("A. private");
            cb[1].setLabel("B. public");
            cb[2].setLabel("C. protected");
            cb[3].setLabel("D. friend");
        }
        if (current == 9) {
            l.setText("Que10: What is the use of the interface keyword in Java?");
            cb[0].setLabel("A. To define a new class");
            cb[1].setLabel("B. To create an abstract class");
            cb[2].setLabel("C. To declare an interface");
            cb[3].setLabel("D. To implement inheritance");
        }

        l.setBounds(30, 40, 450, 20);
    }

    boolean checkAnswer() {
        if (current == 0)
            return cb[2].getState();
        if (current == 1)
            return cb[0].getState();
        if (current == 2)
            return cb[3].getState();
        if (current == 3)
            return cb[0].getState();
        if (current == 4)
            return cb[1].getState();
        if (current == 5)
            return cb[2].getState();
        if (current == 6)
            return cb[1].getState();
        if (current == 7)
            return cb[1].getState();
        if (current == 8)
            return cb[3].getState();
        if (current == 9)
            return cb[2].getState();
        return false;
    }

    public static void main(String s[]) {
        new OnlineTest("Online Test Of Java");
    }
}
