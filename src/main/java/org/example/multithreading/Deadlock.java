package org.example.multithreading;

class Pen {
    public synchronized void witeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen " + this + " and trying to acquire paper " + paper);
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using pen " + this);
    }
}

class Paper {
    public synchronized void writeWithPaperAndPen(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper " + this + " and trying to acquire paper " + pen);
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " finished using paper " + this);
    }
}

class Task1 implements Runnable {
    private Paper paper;
    private Pen pen;

    public Task1(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {

        pen.witeWithPenAndPaper(paper);
    }
}

class Task2 implements Runnable {
    private Paper paper;
    private Pen pen;

    public Task2(Paper paper, Pen pen) {
        this.paper = paper;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen) {
            paper.writeWithPaperAndPen(pen);
        }
    }
}

public class Deadlock {
    public static void main(String[] args) {
        Paper paper = new Paper();
        Pen pen = new Pen();

        Thread t1 = new Thread(new Task1(paper, pen), "t1");
        Thread t2 = new Thread(new Task2(paper, pen), "t2");

        t1.start();
        t2.start();
    }
}
