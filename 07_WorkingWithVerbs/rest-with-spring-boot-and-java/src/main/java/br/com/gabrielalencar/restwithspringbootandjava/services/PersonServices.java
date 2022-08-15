package br.com.gabrielalencar.restwithspringbootandjava.services;

import br.com.gabrielalencar.restwithspringbootandjava.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

//Anotação @Service , serve para que o SpringBoot
//encarre essa classe como algo que será injetado
// em tempo de RUNTIME
@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong(); // Simula o ID
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id){
        //Mocks - Estruturas de código temporárias, para dar sustento ao mesmo, até
        //que outros componentes estejam prontos. A medida que o projeto vai evoluindo
        //eles vão sendo removidos.
        //Podem existir mocks permanentes utilizados em testes automatizados

        //Mock.
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Zaraki");
        person.setLastName("Kenpachi");
        person.setAddress("Gotei 13");
        person.setGender("Male");
        return person;
    }
    private Person mockPerson(int i) {
        logger.info("Finding All people!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person Name " + i);
        person.setLastName("Last Name " + i);
        person.setAddress("Adress " + i);
        person.setGender("Male");
        return person;
    }

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        for (int i=0; i<8; i++ ){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }
}
