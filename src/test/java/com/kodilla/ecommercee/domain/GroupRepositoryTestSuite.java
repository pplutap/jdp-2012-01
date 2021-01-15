package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.GroupRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class GroupRepositoryTestSuite {

    @Autowired
    private GroupRepository groupRepository;


    @Test
    public void testGroupRepositorySave() {
        //Given
        Group ubrania = new Group("Ubrania");
        //When
        groupRepository.save(ubrania);
        //Then
        Long id = ubrania.getId();
        Assertions.assertNotNull(id);
        //CleanUp
        groupRepository.deleteById(id);
    }

    @Test
    public void testGroupRepositoryFindAll() {
        //Given
        Group ubrania = new Group("Ubrania");
        Group dodatki = new Group("Dodatki");
        Group bizuteria = new Group("Bizuteria");
        Group obuwie = new Group("Obuwie");
        //When
        groupRepository.save(ubrania);
        groupRepository.save(dodatki);
        groupRepository.save(bizuteria);
        groupRepository.save(obuwie);
        //Then
        Long idUbrania = ubrania.getId();
        Long idDodatki = dodatki.getId();
        Long idBizuteria = bizuteria.getId();
        Long idObuwie = obuwie.getId();

        List<Group> listGroup = groupRepository.findAll();
        Assertions.assertEquals(4, listGroup.size());

        //CleanUp
        groupRepository.deleteById(idUbrania);
        groupRepository.deleteById(idDodatki);
        groupRepository.deleteById(idBizuteria);
        groupRepository.deleteById(idObuwie);
    }

    @Test
    public void testGroupRepositoryFindById() {
        //Given
        Group bizuteria = new Group("Bizuteria");
        //When
        groupRepository.save(bizuteria);
        //Then
        Long id = bizuteria.getId();
        Optional<Group> readGroup = groupRepository.findById(id);
        Assertions.assertTrue(readGroup.isPresent());
        //CleanUp
        groupRepository.deleteById(id);
    }
    @Test
    public void testGroupRepositoryDeleteById() {
        //Given
        Group ubrania = new Group("Ubrania");
        Group dodatki = new Group("Dodatki");
        //When
        groupRepository.save(ubrania);
        groupRepository.save(dodatki);
        //Then
        Long idUbrania = ubrania.getId();
        Long idDodatki = dodatki.getId();
        groupRepository.deleteById(idDodatki);
        Assertions.assertEquals(1, groupRepository.findAll().size());
        //CleanUp
        groupRepository.deleteById(idUbrania);
    }
}
