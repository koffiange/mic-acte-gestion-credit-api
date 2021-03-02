create PROCEDURE PERSIST_OPERATION_BIDF(r_operation AGC.OPERATION%ROWTYPE, r_acte AGC.ACTE%ROWTYPE)
    IS
    r_operation_acte AGC.OPERATION_ACTE%ROWTYPE;
/*r_operation_acte OPERATION_ACTE@DBLINK_ELABO_BIDF%ROWTYPE;*/
BEGIN
    r_operation_acte.id := SYS_GUID();
    r_operation_acte.acte_id := r_acte.id;
    r_operation_acte.ldep_id := r_operation.lignedepenseuuid;
    r_operation_acte.find_id := r_operation.financementid;
    r_operation_acte.type_acte := CASE r_acte.natureacte
                                        WHEN 'DECRET' THEN 'AL'
                                        WHEN 'LOI' THEN 'AL'
                                        ELSE 'AR'
END;
    r_operation_acte.type_operation := '03';
    r_operation_acte.montant_ae := r_operation.montantoperationae;
    r_operation_acte.montant_cp := r_operation.montantoperationcp;
    r_operation_acte.etat := 'NOUV';
    r_operation_acte.nature_acte := CASE r_acte.naturetransaction
                                        WHEN 'VIREMENT' THEN 'V'
                                        ELSE 'T'
END;
    r_operation_acte.sens_operation := CASE r_operation.typeoperation
                                            WHEN 'PRELEVEMENT' THEN 'DEBIT'
                                            ELSE 'CREDIT'
END;
    r_operation_acte.effectue_par := r_acte.created_by;
    r_operation_acte.date_acte := r_acte.datesignature;

INSERT INTO AGC.OPERATION_ACTE VALUES r_operation_acte;
/*INSERT INTO OPERATION_ACTE@DBLINK_ELABO_BIDF VALUES r_operation;*/

DBMS_OUTPUT.PUT_LINE('NOUVELLE OPERATION PERSISTE');
    DBMS_OUTPUT.PUT_LINE('ACTE_ID : '||r_operation_acte.acte_id);
    DBMS_OUTPUT.PUT_LINE('LDEP_ID : '||r_operation_acte.ldep_id);
    DBMS_OUTPUT.PUT_LINE('FIND_ID : '||r_operation_acte.find_id);
    DBMS_OUTPUT.PUT_LINE('TYPE_ACTE : '||r_operation_acte.type_acte);
END;
/

