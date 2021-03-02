create PROCEDURE PERSIST_ACTE_BIDF(r_acte AGC.ACTE%ROWTYPE)
    IS
    r_acte_budgetaire AGC.ACTE_BUDGETAIRE%ROWTYPE;
/*r_acte_budgetaire AGC.ACTE_BUDGETAIRE@DBLINK_ELABO_BIDF%ROWTYPE;*/
BEGIN
    r_acte_budgetaire.acte_id := r_acte.id;
    r_acte_budgetaire.acte_date_acte := r_acte.datesignature;
    r_acte_budgetaire.exo_num := '2021';
    r_acte_budgetaire.acte_designation := r_acte.reference;
    r_acte_budgetaire.cadep_id := r_acte.naturetransaction;

INSERT INTO AGC.ACTE_BUDGETAIRE VALUES r_acte_budgetaire;
/*INSERT INTO ACTE_BUDGETAIRE@DBLINK_ELABO_BIDF VALUES r_bidf_acte;*/
END;
/

