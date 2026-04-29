-- 코드를 입력하세요
SELECT MCDP_CD 진료과코드, count(*) 5월예약건수
from APPOINTMENT
where month(APNT_YMD)=05 -- and APNT_CNCL_YN = 'N'
group by 1
order by 2, 1;