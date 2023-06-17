package io.getarrays.server.service;

import io.getarrays.server.model.Server;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 9/4/2021
 */
public interface ServerService {
    Server create(Server server);
    Server ping(String ipAddress) throws IOException;
    List<Server> list();
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
