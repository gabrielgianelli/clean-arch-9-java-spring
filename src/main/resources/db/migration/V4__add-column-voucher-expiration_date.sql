ALTER TABLE ccca9.voucher ADD COLUMN expiration_date DATE;

UPDATE ccca9.voucher SET expiration_date = '2099-12-31';

COMMIT;

ALTER TABLE ccca9.voucher ALTER COLUMN expiration_date SET NOT NULL;
