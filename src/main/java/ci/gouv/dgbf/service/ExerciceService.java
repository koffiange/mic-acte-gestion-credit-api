package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.Exercice;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;

@ApplicationScoped
public class ExerciceService implements PanacheRepositoryBase<Exercice, String> {

    public void persist(Exercice exercice){
        deleteAll();
        exercice.persist();
    }

    public void init(){
        Exercice exercice = new Exercice(String.valueOf(LocalDate.now().getYear()));
        exercice.persist();
    }
}
