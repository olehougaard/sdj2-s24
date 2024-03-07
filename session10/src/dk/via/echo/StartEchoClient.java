package dk.via.echo;

public class StartEchoClient {
    public static void main(String[] args) throws Exception {
        EchoClient client = new EchoClientImplementation("127.0.0.1", 8888);
        String reply = client.echo("Hello, World!");
        System.out.println(reply);
        Thread.sleep(2000);
        reply = client.echo("Goodbye, World!");
        System.out.println(reply);
        client.close();
    }
}
