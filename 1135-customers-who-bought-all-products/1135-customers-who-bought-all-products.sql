# Write your MySQL query statement below


# product_key 테이블을 사용하지 않는 경우? -> 에러가 발생함.

-- with cte as(
--     select customer_id, product_key
--     from customer
--     group by customer_id, product_key
-- )
-- , all_p as( # 이건 사용X
--     select count(distinct product_key) as cnt
--     from customer
-- )

-- select customer_id 
-- from cte
--     join all_p
-- group by customer_id
-- having count(customer_id) = (
--     select count(distinct product_key) as cnt
--     from customer);


with cte as(
    select customer_id, product_key
    from customer
    group by customer_id, product_key
)

select customer_id 
from cte
group by customer_id
having count(customer_id) = (
    select count(distinct product_key) as cnt
    from product);
