package ci.gouv.dgbf.service;

import ci.gouv.dgbf.domain.Acte;
import ci.gouv.dgbf.domain.Imputation;
import ci.gouv.dgbf.dto.ImputationDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class ImputationService {

    public List<Imputation> findByActe(Acte acte){
        return Imputation.list("acte.uuid", acte.uuid);
    }

    public void persistAll(List<ImputationDto> imputationList, Acte acte){
        imputationList.forEach(imputationDto -> {
            Imputation imputation = Imputation.parseImputationDto(imputationDto);
            imputation.acte = acte;
            imputation.persist();
        });
    }

    public void deleteByActe(String acteUuid){
        Imputation.delete("acte.uuid", acteUuid);
    }
}
