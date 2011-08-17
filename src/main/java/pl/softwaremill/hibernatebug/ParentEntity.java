package pl.softwaremill.hibernatebug;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.INTEGER;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

/**
 * Created by Pawel Stawicki on 8/17/11 11:01 PM
 */

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "AGREEMENT_CLASS_ID", discriminatorType = INTEGER)
public abstract class ParentEntity  {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
}

