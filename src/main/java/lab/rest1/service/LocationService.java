package lab.rest1.service;

import lab.rest1.api.v1.model.LocationDTO;
import lab.rest1.domain.Location;

public interface LocationService {

    /** Compartilha a localização */
    void shareLocation(Location location);

}
