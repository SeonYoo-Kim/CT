-- 코드를 입력하세요
SELECT distinct left(PRODUCT_CODE, 2) CATEGORY, count(PRODUCT_ID) PRODUCTS
from product
group by 1
order by 1;
