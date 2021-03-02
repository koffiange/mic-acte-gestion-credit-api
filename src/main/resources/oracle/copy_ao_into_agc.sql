create or replace PROCEDURE copy_ao_into_agc
    IS
BEGIN
DELETE FROM AGC.OPERATION;
DELETE FROM AGC.ACTE;
copy_acte_into_agc;
copy_operation_into_agc;
END;