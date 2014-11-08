package br.com.killerwar.task;

import java.net.URISyntaxException;

import android.os.AsyncTask;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class SendTask extends AsyncTask<Void, Void, Void>{

	@Override
	protected Void doInBackground(Void... params) {
        	
        	final Socket socket;
			try {
				socket = IO.socket("http://10.20.12.170:3001/");
			
        	socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

        		  @Override
        		  public void call(Object... args) {
        			  socket.emit("board", "Android - {\"command\": \"create\", \"params\" : {\"id\": \"1\", \"time\": \"red\"}}");
	        		  socket.disconnect();
        		  }

        		}).on("board", new Emitter.Listener() {

        		  @Override
        		  public void call(Object... args) {}

        		}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

        		  @Override
        		  public void call(Object... args) {}

        		});
        		socket.connect();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

}
