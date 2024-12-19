package com.example.demo.entity;

import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class ItemTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    private User owner;
    private User manager;

    @BeforeEach
    void setUp() {
        owner = userRepository.save(new User("user", "test@email.com", "nickname", "1234"));
        manager = userRepository.save(new User("admin", "admin@email.com", "admin", "1234"));
    }

    @Test
    void testGetStatus() {
        //when
        Item item = new Item("item", "description", manager, owner);
        Item savedItem = itemRepository.save(item);

        //then
        assertThat(savedItem.getStatus()).isEqualTo("PENDING");
    }

//    Item entity에 있는 @DynamicInsert으로 테스트 중단
//    @Test
//    void testStatusisNotNull() {
//        //when
//        Item item = new Item("item", "description", manager, owner, null);
//
//        //then
//        assertThrows(DataIntegrityViolationException.class, ()-> {
//            itemRepository.save(item);
//        });
//    }

}