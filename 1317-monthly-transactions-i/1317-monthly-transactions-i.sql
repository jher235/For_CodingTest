# Write your MySQL query statement below

select DATE_FORMAT(t.trans_date, "%Y-%m") as month, 
        t.country, 
        count(t.id) as trans_count,
        sum(if(t.state='approved', 1, 0)) as approved_count,
        sum(t.amount) as trans_total_amount,
        sum(if(t.state='approved', t.amount,0)) as approved_total_amount
from Transactions as t
group by year(trans_date), Month(trans_date), country