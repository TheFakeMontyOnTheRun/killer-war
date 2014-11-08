package br.com.killerwar;

import java.net.URISyntaxException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.drive.Drive;

public class MainActivity extends Activity implements ConnectionCallbacks, OnConnectionFailedListener {

	String url;
	
	GoogleApiClient googleApiClient;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Socket socket;
		try {
			socket = IO.socket("https://10.20.12.170:3001/");
		
			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {
    			  socket.emit("adduser", "teste");
        		  socket.disconnect();
    		  }

    		}).on("board", new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {
    		  }

    		}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {}

    		});
    		socket.connect();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
        connectGooglePlayService();
    }

	private void connectGooglePlayService() {
		googleApiClient = new GoogleApiClient.Builder(this)
        	.addApi(Drive.API)
        	.addScope(Drive.SCOPE_FILE)
        	.addConnectionCallbacks(this)
        	.addOnConnectionFailedListener(this)
        	.build();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        if (id == R.id.action_settings) {
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onConnectionFailed(ConnectionResult arg0) {

	}


	@Override
	public void onConnected(Bundle arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onConnectionSuspended(int arg0) {
		// TODO Auto-generated method stub
		
	}
}
