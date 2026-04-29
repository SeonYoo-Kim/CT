-- 코드를 작성해주세요
select sum(SCORE) SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL
from HR_GRADE 
join HR_EMPLOYEES using(EMP_NO)
join HR_DEPARTMENT  using (DEPT_ID)
group by EMP_NO
order by 1 desc
limit 1;