package ulms.messages.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ulms.messages.model.entity.messageEntity;
import ulms.messages.repository.messageRepository;
@Service
public class messageService {
	public static final String CACHE_NAME = "cache.account";
	public static final Class CACHE_TYPE = messageEntity.class;
	public static final String CACHE_TTL = "${cache.recipe.timetolive:60}";
	 
	private final messageRepository messRepository;
	
	@Autowired
	public messageService(messageRepository messRepository) {
		this.messRepository = messRepository;
	}

	public messageEntity getMessage(Long messageID) {
		Optional<messageEntity> message = messRepository.findById(messageID);
		return message.get();
	}
	
    public Page<messageEntity> getAllMessage(Pageable pageRequest) {
        return messRepository.findAll(pageRequest);
    }
    
    public List<messageEntity> getMessageByUserName(String userName)
    {
    	return messRepository.findByUserName(userName);
    }

	public messageEntity addMessage(messageEntity newMessage) {
		return messRepository.save(newMessage);
	}
	
	public void deleteMessage(Long messageID) {
		messRepository.deleteById(messageID);
	}
	
	public void updateMessage(messageEntity messageData)
	{
		messRepository.save(messageData);
	}

}
