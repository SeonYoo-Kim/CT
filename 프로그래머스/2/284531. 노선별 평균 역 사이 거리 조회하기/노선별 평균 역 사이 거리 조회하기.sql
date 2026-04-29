-- 코드를 작성해주세요
select ROUTE, concat(round(sum(D_BETWEEN_DIST), 2), 'km') TOTAL_DISTANCE, concat(round(sum(D_BETWEEN_DIST)/count(*), 2), 'km') AVERAGE_DISTANCE
from SUBWAY_DISTANCE 
group by ROUTE
order by sum(D_BETWEEN_DIST) desc;