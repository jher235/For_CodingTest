# Write your MySQL query statement below

select name as results
from users as u
    -- join MovieRating as m using (movie_id)
where user_id = (
    select user_id
    from MovieRating 
        join users using (user_id)
    group by user_id
    order by count(user_id) desc, users.name
    limit 1
)
union all
select m.title
from movies as m
where m.movie_id = (
    select movie_id
    from MovieRating 
        join movies using (movie_id)
    where year(created_at)='2020'  and month(created_at)='2' 
    group by movie_id
    order by avg(rating) desc, movies.title
    limit 1
)