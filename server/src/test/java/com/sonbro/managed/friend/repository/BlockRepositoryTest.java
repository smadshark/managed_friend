package com.sonbro.managed.friend.repository;
import static org.assertj.core.api.Assertions.assertThat;
import com.sonbro.managed.friend.domain.Block;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlockRepositoryTest {
    @Autowired
    private BlockRepository blockRepository;

    @Test
    void create() {
        Block block = new Block();
        block.setId(3L);
        block.setName("SON");
        block.setReason("just hate");
        block.setStartDate(LocalDate.now());
        block.setEndDate(LocalDate.now().plusDays(10));

        blockRepository.save(block);
        List<Block> blocks = blockRepository.findAll();

        assertThat(blocks.size()).isEqualTo(3);
        assertThat(blocks.get(2).getName()).isEqualTo("SON");
    }
}