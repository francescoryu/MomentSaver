package ch.francescoryu.momentsaver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MainService extends Service {

    private final IBinder binder = new LocalBinder();

    public MainService() {

    }

    public class LocalBinder extends Binder {
        MainService getService() {
            return MainService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}