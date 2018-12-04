package ulms.messages.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ulms.messages.model.entity.messageEntity;
import ulms.messages.model.entity.messageReceiverEntity;
import ulms.messages.model.entity.messageReceiverIdentity;
import ulms.messages.repository.messageReceiverRepository;

@Service
public class messageReceiverService {
	public static final String CACHE_NAME = "cache.account";
	public static final Class CACHE_TYPE = messageReceiverEntity.class;
	public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";
	
	private final messageReceiverRepository messReceiverRepository;
	
	@Autowired
	public messageReceiverService(messageReceiverRepository messReceiverRepository) {
		this.messReceiverRepository = messReceiverRepository;
	}
	
	public void addMessageReceiver(messageReceiverEntity newMessageReceiver) {
		messReceiverRepository.save(newMessageReceiver);
	}
	
	public List<messageReceiverEntity> getMessageByEmail(String email)
	{
		return messReceiverRepository.findByEmail(email);
	}
	
	public List<messageReceiverEntity> getMessageByEmail(String email, messageReceiverEntity.messageFlag flag)
	{
		return messReceiverRepository.findAllEmail(email, flag);
	}
	
	public messageReceiverEntity findById(Long id, String email)
	{
		Optional<messageReceiverEntity> message = messReceiverRepository.findById(new messageReceiverIdentity(id, email));
		return message.get();
	}
	
	public void update(messageReceiverEntity newMessageReceiver) {
		messReceiverRepository.save(newMessageReceiver);
	}
	

	
}
