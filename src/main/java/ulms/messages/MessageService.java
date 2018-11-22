package ulms.messages;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class MessageService {
	public static final String CACHE_NAME = "cache.account";
	public static final Class CACHE_TYPE = messageEntity.class;
	public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";
	 
	private final messageRepository messRepository;
	
	@Autowired
	public MessageService(messageRepository messRepository) {
		this.messRepository = messRepository;
	}
	
	public messageEntity getMessage(Long messageID) {
		Optional<messageEntity> message = messRepository.findById(messageID);
		return message.get();
	}
	
    public Page<messageEntity> getAllMessage(Pageable pageRequest) {
        return messRepository.findAll(pageRequest);
    }

	public void addMessage(messageEntity newMessage) {
		messRepository.save(newMessage);
	}
	
	public void deleteMessage(Long messageID) {
		messRepository.deleteById(messageID);
	}

}
