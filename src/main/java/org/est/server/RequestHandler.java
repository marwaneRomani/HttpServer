package org.est.server;

public interface RequestHandler {
    void handler(Request req, Response res);
}
