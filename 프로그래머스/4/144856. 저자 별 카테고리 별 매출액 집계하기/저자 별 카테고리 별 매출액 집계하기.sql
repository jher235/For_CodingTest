-- 코드를 입력하세요
SELECT b.author_id as AUTHOR_ID,
        a.author_name AS AUTHOR_NAME, 
        b.category as CATEGORY,
        sum(b.price * s.sales) as TOTAL_SALES
from 
    book b
    inner join author as a on b.author_id = a.author_id
    inner join book_sales as s on b.book_id = s.book_id
where YEAR(s.sales_date)='2022' 
    AND MONTH(s.sales_date)='1'
group by b.category, b.author_id
order by b.author_id, b.category desc;