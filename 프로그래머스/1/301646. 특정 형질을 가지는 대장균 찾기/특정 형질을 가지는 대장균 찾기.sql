select count(*) COUNT
from ECOLI_DATA 
where GENOTYPE & 2 = 0 && (GENOTYPE & 1 != 0 || GENOTYPE & 4 != 0);
-- bin(GENOTYPE) like '%10_' || bin(GENOTYPE) like '%1_0_';