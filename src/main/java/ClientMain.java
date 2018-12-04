import client.Socketor;
import client.Support;

import java.util.ArrayList;
import java.util.List;

public class ClientMain {
    public static void main(String[] args) {
        Socketor socketor = new Socketor("192.168.0.2", 8000);
        Support support = new Support(socketor);
        support.start();
    }
}
