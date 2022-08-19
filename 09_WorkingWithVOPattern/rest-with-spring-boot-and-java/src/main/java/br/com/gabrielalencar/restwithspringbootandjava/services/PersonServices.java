package br.com.gabrielalencar.restwithspringbootandjava.services;

import br.com.gabrielalencar.restwithspringbootandjava.data.vo.v1.PersonVO;
import br.com.gabrielalencar.restwithspringbootandjava.data.vo.v2.PersonVOV2;
import br.com.gabrielalencar.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.gabrielalencar.restwithspringbootandjava.mapper.DozerMapper;
import br.com.gabrielalencar.restwithspringbootandjava.model.Person;
import br.com.gabrielalencar.restwithspringbootandjava.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

//Anotação @Service , serve para que o SpringBoot
//encarre essa classe como algo que será injetado
// em tempo de RUNTIME
@Service
public class PersonServices {
/************************************************************************************************************/
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
/************************************************************************************************************/
    @Autowired
    PersonRepository repository;
/************************************************************************************************************/
    public PersonVO findById(Long id){

        logger.info("Finding one person!");

        var entity = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID!"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }
/************************************************************************************************************/
    public List<PersonVO> findAll() {

    logger.info("Finding All people!");

    return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }
/************************************************************************************************************/
    public PersonVO create (PersonVO personVO){

        logger.info("Creating one person");

        var entity = DozerMapper.parseObject(personVO, Person.class);

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }
/************************************************************************************************************/
    public PersonVO update (PersonVO personVO){
        logger.info("Updating one person");

        var entity = repository.findById(personVO.getId())
                .orElseThrow( () -> new ResourceNotFoundException("No Records found for this ID!"));

        entity.setFirstName(personVO.getFirstName());
        entity.setLastName(personVO.getLastName());
        entity.setAddress(personVO.getAddress());
        entity.setGender(personVO.getGender());

        var vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);

        return vo;
    }
/************************************************************************************************************/
    public void delete (Long id){
        logger.info("Delete one person");

        var entity = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("No Records found for this ID!"));

        repository.delete(entity);
    }

    public PersonVOV2 createV2(PersonVOV2 personVOV2) {
        logger.info("Creating one person with V2");

        var entity = DozerMapper.parseObject(personVOV2, Person.class);
        var vo = DozerMapper.parseObject(repository.save(entity), PersonVOV2.class);

        return vo;
    }
/************************************************************************************************************/
/************************************************************************************************************/
}
