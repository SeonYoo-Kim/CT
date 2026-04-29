-- 코드를 입력하세요
-- SELECT * from ONLINE_SALE ;
SELECT distinct USER_ID, PRODUCT_ID
from ONLINE_SALE 
where (USER_ID, PRODUCT_ID) in(
        select USER_ID, PRODUCT_ID from ONLINE_SALE 
        group by USER_ID, PRODUCT_ID
        having count(*) >= 2
        )
order by USER_ID, PRODUCT_ID desc;