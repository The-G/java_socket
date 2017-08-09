package test2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerSocket {
	static final int SERVER_PORT = 8667;
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
			System.out.println("서버 소캣이 생성됨 : " + SERVER_PORT);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("연결됨...");
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				// 소캣을 이용해서 input, output stream을 연거다!!
				
				Object in = ois.readObject();
				System.out.println(socket.getInetAddress() + " 받은 메시지 : " + in);
				
				oos.writeObject("안녕하세요. 저는 서버입니다.");
				oos.flush();
				socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
