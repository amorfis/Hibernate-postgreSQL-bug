package pl.softwaremill.hibernatebug;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Pawel Stawicki on 8/17/11 11:01 PM
 */
@Entity
@DiscriminatorValue("1")
public class InheritingEntity extends ParentEntity {

}
