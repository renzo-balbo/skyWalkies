package com.mindhub.skywalkies.services.implement;

import com.mindhub.skywalkies.models.Client;
import com.mindhub.skywalkies.repositories.ClientRespository;
import com.mindhub.skywalkies.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImplements implements ClientService {
  @Autowired
  private ClientRespository clientRespository;
  @Override
  public List<Client> getAllClients(){
    return clientRespository.findAll();
  }
  @Override
  public Client getClientById(long id){
    return clientRespository.findById(id).orElse(null);
  }
  @Override
  public Client findClientByEmail(String email){
    return clientRespository.findByEmail(email);
  }
  @Override
  public void saveClient(Client client){
    clientRespository.save(client);
  }
}
