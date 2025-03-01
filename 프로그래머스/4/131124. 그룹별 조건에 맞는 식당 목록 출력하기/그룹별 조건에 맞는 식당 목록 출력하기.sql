
select 
    m.MEMBER_NAME, 
    r.REVIEW_TEXT, 
    DATE_FORMAT(r.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from 
    REST_REVIEW as r
    join MEMBER_PROFILE as m on r.member_id=m.member_id
where r.member_id = (select member_id
                     from REST_REVIEW
                     group by member_id
                     order by count(member_id) desc
                     limit 1) 
order by 3, 2
