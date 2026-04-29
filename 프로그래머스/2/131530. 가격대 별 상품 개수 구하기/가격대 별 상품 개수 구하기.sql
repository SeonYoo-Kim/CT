-- 코드를 입력하세요
SELECT  floor(PRICE / 10000)*10000 PRICE_GROUP, count(*) PRODUCTS
from PRODUCT
group by 1
order by PRICE;