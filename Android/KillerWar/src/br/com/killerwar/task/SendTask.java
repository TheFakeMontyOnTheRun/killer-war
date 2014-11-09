package br.com.killerwar.task;

import java.net.URISyntaxException;

import android.os.AsyncTask;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class SendTask extends AsyncTask<Void, Void, Void>{
	String url = "https://10.20.12.170:3001/";
	@Override
	protected Void doInBackground(Void... params) {
        	
        	final Socket socket;
        	try {
    			socket = IO.socket(url);
    		
    			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

        		  @Override
        		  public void call(Object... args) {
        			  socket.emit("adduser", "teste");
            		  socket.disconnect();
        		  }

        		}).on("adduser", new Emitter.Listener() {

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
		return null;
	}

}
