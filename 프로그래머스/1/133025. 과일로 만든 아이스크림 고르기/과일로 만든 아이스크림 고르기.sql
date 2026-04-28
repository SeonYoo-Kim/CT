-- 코드를 입력하세요
SELECT H.FLAVOR 
from FIRST_HALF H
join ICECREAM_INFO I on H.FLAVOR = I.FLAVOR
where H.TOTAL_ORDER > 3000 && I.INGREDIENT_TYPE='fruit_based'
order by H.TOTAL_ORDER desc;