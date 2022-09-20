package com.mindhub.skywalkies.Service;

import com.mindhub.skywalkies.models.Client_order;

import java.util.List;

public interface Client_orderService {
    List<Client_order> getAllClientsOrders();

    Client_order getClientOrdersById(long id);

    void saveClientOrders(Client_order client_order);
}
