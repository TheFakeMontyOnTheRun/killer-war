package br.com.killerwar;

import java.net.URISyntaxException;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

public class SendThread implements Runnable {

	@Override
	public void run() {
		final Socket socket;
		try {
			socket = IO.socket("http://10.20.12.170:3001/");
		
			socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {
    			  socket.emit("adduser", "teste");
//    			  socket.emit("board", "Android - {\"command\": \"create\", \"params\" : {\"id\": \"1\", \"time\": \"red\"}}");
        		  socket.disconnect();
    		  }

    		}).on("adduser", new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {
//    			  socket.emit("board", "Android - {\"command\": \"create\", \"params\" : {\"id\": \"1\", \"time\": \"red\"}}");
//        		  socket.disconnect();
    		  }

    		}).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {

    		  @Override
    		  public void call(Object... args) {}

    		});
    		socket.connect();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
