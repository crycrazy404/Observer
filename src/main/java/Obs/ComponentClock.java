package Obs;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ComponentClock extends Observer {
    GraphicsContext gr;

    int x1, x2, y1, y2, y3, count, start;
    Paint p;
    Boolean state;
    Clock clock;

    public ComponentClock(Subject subject,GraphicsContext gr){
        this.clock = new Clock();
        this.state = false;
        this.gr = gr;
        this.x1 = 105;
        this.x2 = 275;
        this.y1 = 45;
        this.y2 = 45;
        this.y3 = 155;
        this.count = 0;
        this.start = subject.getState();
        this.p = Color.KHAKI;
        this.subject = subject; this.subject.attach(this);

    }

    public void onComp(int count){
        this.count = count;
        this.start = subject.getState(); this.state = true;
    }

    public void offComp(){
        p = Color.KHAKI; this.state = false;
    }

    public void delComo(Subject st){
        p = Color.KHAKI;
        this.x1 = 105;
        this.x2 = 275;
        this.y1 = 45;
        this.y2 = 45;
        this.y3 = 155;
        gr.clearRect(0, 0, 380, 248);
        clock.draw(gr,p,x1,x2,y1,y2,y3);
        st.detach(this);
    }

    @Override
    public void update(Subject st) {
        if (state) {
            gr.clearRect(0, 0, 380, 248);
            if (st.getState() == start + count) {
                p = Color.CORAL;
                start += count;
            }
            if (st.getState() == start + 1) {
                p = Color.KHAKI;
            }
            clock.draw(gr, p, x1, x2, y1, y2, y3);
            if (y3 != 105) {
                x1 += 10;
                x2 -= 10;
                y1 += 5;
                y2 += 5;
                y3 -= 5;
            } else {
                x1 = 105;
                x2 = 275;
                y1 = 45;
                y2 = 45;
                y3 = 155;
            }
        }
    }
}
