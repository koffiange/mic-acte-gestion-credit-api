create PROCEDURE copy_operation_into_agc
    IS
    CURSOR c_operation_bidf IS
SELECT * FROM OPERATION_ACTE@DBLINK_ELABO_BIDF;

r_operation AGC.OPERATION%ROWTYPE;
    r_bailleur BAILLEUR@DBLINK_ELABO_BIDF%ROWTYPE;
    r_source_financement SOURCE_FINANCEMENT@DBLINK_ELABO_BIDF%ROWTYPE;
    r_nature_economique NATURE_ECONOMIQUE@DBLINK_ELABO_BIDF%ROWTYPE;
    r_section SECTION_BUDGETAIRE@DBLINK_ELABO_BIDF%ROWTYPE;
    r_activite ACTIVITE_DE_SERVICE@DBLINK_ELABO_BIDF%ROWTYPE;
    r_ligne_depense LIGNE_DE_DEPENSES@DBLINK_ELABO_BIDF%ROWTYPE;
    r_financement FINANCEMENT_DEPENSES@DBLINK_ELABO_BIDF%ROWTYPE;

BEGIN

FOR record IN c_operation_bidf LOOP

SELECT * INTO r_ligne_depense FROM LIGNE_DE_DEPENSES@DBLINK_ELABO_BIDF WHERE ldep_id = record.ldep_id;
SELECT * INTO r_activite FROM ACTIVITE_DE_SERVICE@DBLINK_ELABO_BIDF WHERE ads_id = r_ligne_depense.ads_id;
SELECT * INTO r_financement FROM FINANCEMENT_DEPENSES@DBLINK_ELABO_BIDF WHERE ldep_id = record.ldep_id;
SELECT * INTO r_source_financement FROM SOURCE_FINANCEMENT@DBLINK_ELABO_BIDF WHERE sfin_id = r_financement.sfin_id;
SELECT * INTO r_bailleur FROM BAILLEUR@DBLINK_ELABO_BIDF WHERE bai_id = r_financement.bai_id;
SELECT * INTO r_nature_economique FROM NATURE_ECONOMIQUE@DBLINK_ELABO_BIDF WHERE nat_id = r_ligne_depense.nat_id;
SELECT * INTO r_section FROM SECTION_BUDGETAIRE@DBLINK_ELABO_BIDF WHERE secb_id = r_ligne_depense.secb_id;

r_operation.id := SYS_GUID();
        r_operation.activitecode := r_activite.ads_code;
        r_operation.activitelibelle := r_activite.ads_liblg;
        r_operation.bailleurid := r_bailleur.bai_id;
        r_operation.bailleurlibelle := r_bailleur.bai_designation;
        r_operation.budgetactuelae := r_financement.find_bvote_ae;
        r_operation.budgetactuelcp := r_financement.find_bvote_cp;
        r_operation.disponibilitecredit := 'CREDIT_DISPONIBLES';
        r_operation.exercice := '2021';
        r_operation.financementid := r_financement.find_id;
        r_operation.lignedepenseuuid := record.ldep_id;
        r_operation.montantoperationae := record.montant_ae;
        r_operation.montantoperationcp := record.montant_cp;
        r_operation.natureeconomiquecode := r_nature_economique.nat_code;
        r_operation.natureeconomiquelibelle := r_nature_economique.nat_liblg;
        r_operation.nouvelleimputation := 0;
        r_operation.sectioncode := r_section.secb_num;
        r_operation.sectionlibelle := r_section.secb_liblg;
        r_operation.sourcefinancementcode := r_source_financement.sfin_code;
        r_operation.sourcefinancementlibelle := r_source_financement.sfin_libct;
        IF record.montant_ae < 0 THEN
            r_operation.typeoperation := 'ORIGINE';
ELSE r_operation.typeoperation := 'DESTINATION';
END IF;
        r_operation.acte_id := record.acte_id;

INSERT INTO AGC.OPERATION VALUES r_operation;
END LOOP;
END;
/

