package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.agc.ModeleVisa;
import ci.gouv.dgbf.domain.agc.Visa;
import ci.gouv.dgbf.dto.ModeleVisaDto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ModeleVisaService implements PanacheRepositoryBase<ModeleVisa, String> {

    @Inject
    CompositionVisaService compositionVisaService;

    public void persist(ModeleVisa modeleVisa){
        ModeleVisa old = Visa.findById(modeleVisa.uuid);
        if (old.isPersistent()){
            this.update(old, modeleVisa);
        } else {
            modeleVisa.persist();
        }
    }

    public void persist(ModeleVisaDto modeleVisaDto){
        if (modeleVisaDto.modeleVisa.uuid != null){
            ModeleVisa old = Visa.findById(modeleVisaDto.modeleVisa.uuid);
            this.update(old, modeleVisaDto.modeleVisa);
            compositionVisaService.persist(old, modeleVisaDto.visaDtoList);
        } else {
            modeleVisaDto.modeleVisa.persist();
            compositionVisaService.persist(modeleVisaDto.modeleVisa, modeleVisaDto.visaDtoList);
        }
    }

    private void update(ModeleVisa old, ModeleVisa modeleVisa){
        old.code = modeleVisa.code;
        old.libelle = modeleVisa.libelle;
        old.description = modeleVisa.description;
        old.persist();
    }

    public void delete(String uuid){
        compositionVisaService.deleteCompositionByModeleVisa(uuid);
        ModeleVisa.deleteById(uuid);
    }
}
