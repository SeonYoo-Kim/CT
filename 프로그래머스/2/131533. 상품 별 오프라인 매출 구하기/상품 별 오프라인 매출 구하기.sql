-- 코드를 입력하세요
SELECT PRODUCT_CODE, sum(SALES_AMOUNT * price) SALES
from OFFLINE_SALE
join  PRODUCT using (PRODUCT_ID)
group by 1
order by 2 desc, 1;