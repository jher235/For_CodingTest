# -- 코드를 입력하세요

with cte as (
    select r.member_id, 
        count(r.member_id) as s
    from rest_review as r 
    group by r.member_id
    order by 2 desc
    limit 1
)


select 
    m.MEMBER_NAME, 
    r.REVIEW_TEXT, 
    DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from cte
    join rest_review as r on cte.member_id = r.member_id
    join MEMBER_PROFILE as m on cte.member_id = m.member_id
order by 3, 2;
