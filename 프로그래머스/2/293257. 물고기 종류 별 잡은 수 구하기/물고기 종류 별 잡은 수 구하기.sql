-- 코드를 작성해주세요
select count(*) FISH_COUNT,	FISH_NAME
from FISH_INFO 
join FISH_NAME_INFO using (FISH_TYPE)
group by FISH_TYPE
order by 1 desc;