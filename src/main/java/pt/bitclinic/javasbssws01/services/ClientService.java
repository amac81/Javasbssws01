package pt.bitclinic.javasbssws01.services;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import pt.bitclinic.javasbssws01.dao.ClientRepository;
import pt.bitclinic.javasbssws01.entities.Client;
import pt.bitclinic.javasbssws01.services.exceptions.DatabaseException;
import pt.bitclinic.javasbssws01.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	private ClientRepository clientRepository;
	
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Transactional(readOnly = true)	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	@Transactional(readOnly = true)	
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(()->  new ResourceNotFoundException(id));
	}
	
	public Client insert(Client obj) {
		return clientRepository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			clientRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e1) {
			throw new DatabaseException(e1.getMessage());		
		}
	}

	public Client update(Long id, Client obj) {
		try {
			//getReferenceById more efficient than findById
			//getReferenceById only "prepares" the monitored object 
			Client entity = clientRepository.getReferenceById(id);
			updateData(entity, obj);
			return clientRepository.save(entity);
			
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}
	
	private void updateData(Client entity, Client obj) {
		//id and password not allowed to update
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
