package br.com.gabrielalencar.restwithspringbootandjava.repository;

import br.com.gabrielalencar.restwithspringbootandjava.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Interface Repositório - É a classe que permite acesso ao banco de dados
@Repository
//JPA Repository permite efetuar CRUD básico
//Ele exige um tipo, no nosso caso é a Classe PERSON, e o ID da classe PERSON
//que nesse caso é LONG.
public interface PersonRepository extends JpaRepository <Person, Long> {
}
