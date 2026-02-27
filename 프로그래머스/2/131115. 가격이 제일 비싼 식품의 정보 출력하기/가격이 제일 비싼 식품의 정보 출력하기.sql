-- 코드를 입력하세요

set @price = (select max(p.price) from food_product p);

SELECT p.product_id, p.product_name, p.product_cd, p.category, p.price
from food_product p
where p.price = @price;


