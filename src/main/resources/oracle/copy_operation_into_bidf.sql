create PROCEDURE COPY_OPERATION_INTO_BIDF(uuid VARCHAR2)
    IS
    CURSOR c_operation (acte_uuid VARCHAR2) IS
select * from AGC.operation where acte_id = acte_uuid;
r_acte AGC.ACTE%ROWTYPE;
BEGIN
SELECT * INTO r_acte FROM AGC.ACTE WHERE id = uuid;
FOR r_operation IN c_operation(uuid) LOOP
        persist_operation_bidf(r_operation, r_acte);
END LOOP;
END;
/

