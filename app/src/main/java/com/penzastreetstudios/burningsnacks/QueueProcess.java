package com.penzastreetstudios.burningsnacks;

import android.os.AsyncTask;
import android.widget.Toast;

import com.penzastreetstudios.burningsnacks.students.Student;

import java.util.concurrent.TimeUnit;

public class QueueProcess extends AsyncTask <Machine, Machine, Void> {

    public long sleepPeriod = 1000;

    @Override
    protected Void doInBackground(Machine[] machines) {
        Machine machine = machines[0];
        while (machine.queue.size() != 0) {
            try {
                acceptingStage(machine);
                publishProgress(machine);
                TimeUnit.MILLISECONDS.sleep(sleepPeriod);
                acceptingStage(machine);
                publishProgress(machine);
                TimeUnit.MILLISECONDS.sleep(sleepPeriod);
                payingStage(machine);
                publishProgress(machine);
                TimeUnit.MILLISECONDS.sleep(sleepPeriod);
                issuingStage(machine);
                publishProgress(machine);
                TimeUnit.MILLISECONDS.sleep(sleepPeriod);
            }
            catch(InterruptedException error) {

            }
            machine.queue.remove(0);
        }
        chillStage(machine);
        publishProgress(machine);
        return null;
    }

    @Override
    protected void onProgressUpdate(Machine... values) {
        super.onProgressUpdate(values);
        Machine machine = values[0];
        machine.updateView();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
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
