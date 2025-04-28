-- 코드를 입력하세요




SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, 
    ROUND(AVG(rr.review_score), 2) as score
from REST_INFO as ri
inner join REST_REVIEW as rr on ri.rest_id = rr.rest_id 
    and ri.address like '서울%'
group by ri.rest_id
order by score desc, count(ri.favorites)




