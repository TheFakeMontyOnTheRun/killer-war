package br.com.killerwar;

import java.net.URISyntaxException;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class SendThread implements Runnable {

	@Override
	public void run() {
		final Socket socket;
		
			try {
				socket = IO.socket("http://10.20.12.170:3001");
			
				socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

	    		  @Override
	    		  public void call(Object... args) {
	    			  socket.emit("adduser", "teste");
//	        		  socket.disconnect();
	        		  Log.i("call", "chamado");
	    		  }

	    		});
    		socket.connect();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
