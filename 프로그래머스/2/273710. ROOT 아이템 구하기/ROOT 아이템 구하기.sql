
# select ii.item_id, ii.item_name
# from item_info ii 
# where ii.item_id in (
#     select it.item_id
#     from item_tree it
#     where it.parent_item_id is null
# )
# order by ii.item_id ;

-- 위는 item_tree에 모든 parent 관련 정보가 나온다는 가정이 있는 경우임. 이게 없다면??

with ids as (
    select distinct(it.item_id) as id
    from item_tree it
    where it.parent_item_id is not null
)

select ii.item_id, ii.item_name
from item_info ii 
where ii.item_id not in (select id from ids)
order by ii.item_id ;