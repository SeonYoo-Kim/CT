-- 코드를 입력하세요
SELECT extract(hour from DATETIME) HOUR, count(*) COUNT
from ANIMAL_OUTS 
where extract(hour from DATETIME) >= 9 and extract(hour from DATETIME) <20
group by 1
order by 1;