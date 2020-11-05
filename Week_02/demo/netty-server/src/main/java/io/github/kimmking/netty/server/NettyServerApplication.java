package io.github.kimmking.netty.server;


public class NettyServerApplication {

    /**
     * 压测结果 4928.3
     **/
    public static void main(String[] args) {
        HttpServer server = new HttpServer(false, 8808);
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
