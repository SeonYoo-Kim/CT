-- 코드를 입력하세요
SELECT b.BOOK_ID, a.AUTHOR_NAME, b.PUBLISHED_DATE
from BOOK b
left join AUTHOR  a using (AUTHOR_ID)
where CATEGORY='경제'
order by PUBLISHED_DATE;