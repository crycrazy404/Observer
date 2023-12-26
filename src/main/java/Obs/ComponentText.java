package Obs;

import javafx.scene.control.TextField;

public class ComponentText extends Observer {
    String txt;

    public TextField dindon;
    Boolean state;

    public ComponentText(Subject subject, TextField dindon) {
        this.txt = "Прошло _ с";
        this.state = false;
        this.dindon = dindon;
        this.subject = subject;
        this.subject.attach(this);
    }

    public void onComp() {
        this.state = true;
    }

    public void offComp() {
        this.state = false;
    }

    public void delComo(Subject st) {
        st.detach(this);
        dindon.setText("Прошло _ с");
    }

    @Override
    public void update(Subject st) {
        if (state) {
            txt = "Прошло " + st.getState() + " с";
            dindon.setText(txt);
        }
    }

}

