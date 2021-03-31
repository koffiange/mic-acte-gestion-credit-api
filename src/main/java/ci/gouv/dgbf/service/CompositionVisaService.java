package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.Composition;
import ci.gouv.dgbf.domain.agc.ModeleVisa;
import ci.gouv.dgbf.dto.VisaDto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CompositionVisaService implements PanacheRepositoryBase<Composition, String> {

    public List<Composition> findByModele(String uuid){
        return Composition.find("modeleVisa.uuid", uuid).list();
    }

    public void persist(ModeleVisa modeleVisa, List<VisaDto> visaList){
        deleteCompositionByModeleVisa(modeleVisa.uuid);
        visaList.forEach(visaDto -> this.buildCompositionVisa(modeleVisa, visaDto).persist());
    }

    private Composition buildCompositionVisa(ModeleVisa modeleVisa, VisaDto visaDto){
        return new Composition(modeleVisa, visaDto.visa, visaDto.numeroOrdre);
    }

    public void deleteCompositionByModeleVisa(String uuid){
        Composition.delete("modeleVisa.uuid", uuid);
    }
}
