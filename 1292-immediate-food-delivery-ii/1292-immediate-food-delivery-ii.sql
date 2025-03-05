
-- with first as(
--     select 
--         min(order_date) as order_date, 
--         -- customer_pref_delivery_date
--         min(customer_pref_delivery_date) as customer_pref_delivery_date
--     from Delivery
--     group by customer_id
-- )
-- select round(avg(if(order_date=customer_pref_delivery_date, 100,0)),2) as immediate_percentage
-- from first


-- select
--     round( avg(if(d.order_date=d.customer_pref_delivery_date, 100, 0)) ,2) as immediate_percentage
-- from Delivery as d
-- where (d.customer_id, d.order_date) in (
--     select customer_id, min(order_date)
--     from Delivery
--     group by customer_id
--     )

select
    round(avg(d.order_date=d.customer_pref_delivery_date)* 100, 2) as immediate_percentage
from Delivery as d
where (d.customer_id, d.order_date) in (
    select customer_id, min(order_date)
    from Delivery
    group by customer_id
)

 