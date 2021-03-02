create PROCEDURE COPY_AO_INTO_BIDF(acte_id VARCHAR2)
    IS
BEGIN
    copy_acte_into_bidf(acte_id);
    copy_operation_into_bidf(acte_id);
END;
/

