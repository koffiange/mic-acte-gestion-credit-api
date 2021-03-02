create PROCEDURE COPY_ACTE_INTO_BIDF(uuid VARCHAR2)
    IS
    CURSOR c_acte (acte_uuid VARCHAR2) IS
select * from AGC.ACTE where id = acte_uuid;
r_acte AGC.ACTE%ROWTYPE;
BEGIN
OPEN c_acte(uuid);
FETCH c_acte INTO r_acte;
PERSIST_ACTE_BIDF(r_acte);
CLOSE c_acte;
END;
/

