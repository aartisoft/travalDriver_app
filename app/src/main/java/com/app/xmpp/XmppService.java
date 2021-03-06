package com.app.xmpp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.cabily.cabilydriver.Utils.SessionManager;

import java.util.HashMap;


/**
 * Created by Prem Kumar and Anitha on 12/15/2016.
 */

public class XmppService extends Service {

    public static MyXMPP xmpp;
    private String ServiceName = "", HostAddress = "";
    private String USERNAME = "";
    private String PASSWORD = "";
    private SessionManager sessionManager;


    @Override
    public IBinder onBind(final Intent intent) {
        return new LocalBinder<XmppService>(this);
    }

    @Override
    public boolean onUnbind(final Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        sessionManager = new SessionManager(XmppService.this);

        // get user data from session
        HashMap<String, String> domain = sessionManager.getXmpp();
        ServiceName = domain.get(SessionManager.KEY_HOST_NAME);
        HostAddress = domain.get(SessionManager.KEY_HOST_URL);

        HashMap<String, String> user = sessionManager.getUserDetails();
        USERNAME = user.get(SessionManager.KEY_DRIVERID);
        PASSWORD = user.get(SessionManager.KEY_SEC_KEY);

        System.out.println("----------ServiceName------------" + ServiceName);
        System.out.println("----------HostAddress------------" + HostAddress);
        System.out.println("----------USERNAME------------" + USERNAME);
        System.out.println("----------PASSWORD------------" + PASSWORD);

        xmpp = MyXMPP.getInstance(XmppService.this, ServiceName, HostAddress, USERNAME, PASSWORD);
        xmpp.connect("onCreate");
        System.out.println("--------------Xmpp Service Created-----------");
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags,
                              final int startId) {
        System.out.println("--------------Xmpp Service Started-----------");
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

       /* MyXMPP.instance=null;
        MyXMPP.instanceCreated=false;

        xmpp.connection.disconnect();
*/
        System.out.println("--------------Xmpp Service Stopped-----------");
    }

}
