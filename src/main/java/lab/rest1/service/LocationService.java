package lab.rest1.service;

import lab.rest1.domain.Location;

/**
 * =================================
 * Métodos do serviço de localização
 * =================================
 * @author bruno.carneiro
 */
public interface LocationService {

    /** Compartilha a localização */
    void shareLocation(Location location);

}
