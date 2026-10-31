-- 코드를 입력하세요


select month(start_date) as month, car_id, count(1) records
from CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
where car_id in (
    SELECT car_id
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh2
    where start_date >= '2022-08-01' and start_date < '2022-11-01'
    group by car_id
    having count(1) > 4
) and start_date >= '2022-08-01' and start_date < '2022-11-01'
group by car_id, month
order by month, car_id desc


