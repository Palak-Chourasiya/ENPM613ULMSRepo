package ulms.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
}
