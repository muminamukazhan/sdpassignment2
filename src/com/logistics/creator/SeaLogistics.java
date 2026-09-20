package com.logistics.creator;

import com.logistics.transport.Transport;
import com.logistics.transport.Ship;

public class SeaLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Ship();
    }
}