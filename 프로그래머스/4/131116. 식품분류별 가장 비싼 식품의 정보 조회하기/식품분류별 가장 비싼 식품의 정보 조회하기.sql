# SELECT fp.category, fp.price as max_price, fp.product_name
# From food_product fp
# where fp.category in ('과자', '국', '김치', '식용유')
#  and fp.price = (
#  select max(fp2.price)
#      from food_product fp2
#      where fp2.category = fp.category
# )

# # # Group by fp.category
# # # having max(fp.price) as mfp
# order by fp.price desc


with maxfd as (
select 
    fd.product_id,
    rank() over(partition by fd.category order by fd.price desc) as rk,
    fd.product_name,
    fd.category,
    fd.price
from food_product fd
where fd.category in ('과자', '국', '김치', '식용유')
)

select mf.category, mf.price as max_price, mf.product_name
from maxfd as mf
where mf.rk = 1
order by mf.price desc









