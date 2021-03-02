create PROCEDURE COPY_ACTE_INTO_AGC
    IS
    CURSOR c_acte_bidf IS
SELECT * FROM ACTE_BUDGETAIRE@DBLINK_ELABO_BIDF;
r_acte AGC.ACTE%ROWTYPE;
BEGIN
FOR record IN c_acte_bidf LOOP
        r_acte.id := record.acte_id;
        r_acte.categorieacte := CASE TRIM(record.cadep_id)
                                    WHEN 'BUDGET_INITIAL' THEN 'ACTE_BUDGET_INITIAL'
                                    WHEN 'ACTE_INTEGRATION_RESSOURCES' THEN 'ACTE_INTEGRATION_RESSOURCES'
                                    WHEN 'ACTE_REPORT' THEN 'ACTE_REPORT'
                                    WHEN 'ACTE_GELE_DEGELE' THEN 'ACTE_GELE_DEGELE'
                                    WHEN 'ACTE_ANNULATION' THEN 'ACTE_ANNULATION'
                                    ELSE 'ACTE_MOUVEMENT'
END;

        r_acte.datesignature := record.acte_date_acte;


        /* CONDITION DE LA NATURE D'ACTE */
        IF (INSTR(TRIM(LOWER(record.acte_designation)),'arrêté') > 0) THEN
            r_acte.natureacte := 'ARRETE';
END IF;
        IF (INSTR(TRIM(LOWER(record.acte_designation)),'décret') > 0) THEN
            r_acte.natureacte := 'DECRET';
END IF;
        IF (INSTR(TRIM(LOWER(record.acte_designation)),'décision') > 0) THEN
            r_acte.natureacte := 'DECISION';
END IF;
        IF (INSTR(TRIM(LOWER(record.acte_designation)),'ordonnance') > 0) THEN
            r_acte.natureacte := 'ORDONNANCE';
END IF;

        /* CONDITION DE LA NATURE D'ACTE */
        IF (INSTR(TRIM(LOWER(record.cadep_id)),'transfert') > 0) THEN
            r_acte.naturetransaction := 'TRANSFERT';
ELSE
            r_acte.naturetransaction := 'VIREMENT';
END IF;

        r_acte.reference := record.acte_designation;
        r_acte.libelle := record.acte_designation;
        r_acte.statutacte := 'APPLIQUE';
INSERT INTO AGC.ACTE VALUES r_acte;
END LOOP;
END;
/

