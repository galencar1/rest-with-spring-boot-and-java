package br.com.gabrielalencar.restwithspringbootandjava.services;

import br.com.gabrielalencar.restwithspringbootandjava.exceptions.ResourceNotFoundException;
import br.com.gabrielalencar.restwithspringbootandjava.data.vo.v1.PersonVO;
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
        //Mocks - Estruturas de código temporárias, para dar sustento ao mesmo, até
        //que outros componentes estejam prontos. A medida que o projeto vai evoluindo
        //eles vão sendo removidos.
        //Podem existir mocks permanentes utilizados em testes automatizados

        //Mock.
        logger.info("Finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID!"));
    }
/************************************************************************************************************/
    public List<PersonVO> findAll() {
    logger.info("Finding All people!");
    return repository.findAll();
    }
/************************************************************************************************************/
    public PersonVO create (PersonVO person){
        logger.info("Creating one person");
        return repository.save(person);
    }
/************************************************************************************************************/
    public PersonVO update (PersonVO person){
        logger.info("Updating one person");
        PersonVO entity = repository.findById(person.getId())
                .orElseThrow( () -> new ResourceNotFoundException("No Records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return repository.save(person);
    }
/************************************************************************************************************/
    public void delete (Long id){
        logger.info("Delete one person");

        PersonVO entity = repository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("No Records found for this ID!"));

        repository.delete(entity);
    }
/************************************************************************************************************/
/************************************************************************************************************/
}
