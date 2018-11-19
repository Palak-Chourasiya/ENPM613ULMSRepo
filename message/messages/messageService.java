package messages;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ulms.recipes.models.IngredientEntity;

import org.springframework.data.domain.PageRequest;
@Service
public class messageService {
	
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

	
	public void addMessage(messageEntity newMessage) {
		messRepository.save(newMessage);
	}

}
