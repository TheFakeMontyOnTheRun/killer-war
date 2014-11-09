package br.com.killerwar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.github.nkzawa.socketio.client.Socket;


public class MainActivity extends Activity implements OnClickListener {

	String url = "http://10.20.12.170:3001";
	
	Button btUp, btDown, btLeft, btRight, btFire;
	Socket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btFire = (Button) findViewById(R.id.btFire);
        btFire.setOnClickListener(this);
        
        btLeft = (Button) findViewById(R.id.btLeft);
        btLeft.setOnClickListener(this);
        
        btRight = (Button) findViewById(R.id.btRight);
        btRight.setOnClickListener(this);
        
        btDown = (Button) findViewById(R.id.btDown);
        btDown.setOnClickListener(this);
        
        btUp = (Button) findViewById(R.id.btUp);
        btUp.setOnClickListener(this);
        
//		try {
//			socket = IO.socket(url);
//		
//			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
//
//    		  @Override
//    		  public void call(Object... args) {
//    			  socket.emit("adduser", "teste");
////        		  socket.disconnect();
//        		  Log.i("call", "chamado");
//    		  }
//
//    		});
//			.on("adduser", new Emitter.Listener() {
//
//    		  @Override
//    		  public void call(Object... args) {
//    		  }
//
//    		}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
//
//    		  @Override
//    		  public void call(Object... args) {}
//
//    		});
//    		socket.connect();
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
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
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btDown:
				SendThread sendThread = new SendThread();
				new Thread( sendThread ).start();
				break;
				
			case R.id.btFire:
				
				break;
			case R.id.btLeft:
				
				break;
			case R.id.btRight:
				
				break;
			case R.id.btUp:
				
				break;				
		}
	}
}
