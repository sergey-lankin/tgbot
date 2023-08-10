package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.ActiveChat;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    @Test
    public void testRepo_found() {
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(7L);
        assertTrue(activeChatByChatId.isPresent());
        assertEquals(7L, activeChatByChatId.get().getChatId());
    }

    @Test
    public void testRepo_notFound() {
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(7L);
        assertFalse(activeChatByChatId.isPresent());
    }
}