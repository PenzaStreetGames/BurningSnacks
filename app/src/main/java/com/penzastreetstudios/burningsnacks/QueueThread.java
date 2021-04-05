package com.penzastreetstudios.burningsnacks;

import android.os.Handler;

import com.penzastreetstudios.burningsnacks.students.Student;

import java.util.concurrent.TimeUnit;

public class QueueThread implements Runnable {

    public Machine machine;
    public long sleepPeriod = 1000;
    public Handler handler;

    public QueueThread(Machine machine, Handler handler) {
        this.machine = machine;
        this.handler = handler;
    }

    @Override
    public void run() {
        while (machine.queue.size() != 0) {
            try {
                acceptingStage(machine);
                handler.sendEmptyMessage(1);
                Thread.sleep(sleepPeriod);
                //TimeUnit.MILLISECONDS.sleep(sleepPeriod);
                acceptingStage(machine);
                handler.sendEmptyMessage(1);
                Thread.sleep(sleepPeriod);
                payingStage(machine);
                handler.sendEmptyMessage(1);
                Thread.sleep(sleepPeriod);
                issuingStage(machine);
                handler.sendEmptyMessage(1);
                Thread.sleep(sleepPeriod);
            }
            catch(InterruptedException error) {

            }
            machine.queue.remove(0);
        }
        chillStage(machine);
        handler.sendEmptyMessage(1);
        //publishProgress(machine);
    }

    protected void acceptingStage(Machine machine) {
        Student student = machine.queue.get(0);
        machine.status = "Приём заказа";
        machine.student = student;
        machine.getSnack();
    }

    protected void payingStage(Machine machine) {
        machine.status = "Оплата заказа";
    }

    protected void issuingStage(Machine machine) {
        machine.status = "Выдача заказа";
        machine.clearSum();
    }

    protected void chillStage(Machine machine) {
        machine.status = "Простаивает";
        machine.student = null;
    }
}
