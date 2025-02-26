-- 코드를 작성해주세요
 
select 
    e.emp_no as EMP_NO, 
    e.emp_name as EMP_NAME, 
    (case when AVG(g.score) >= 96 then 'S'
          when AVG(g.score) >= 90 then 'A'
          when AVG(g.score) >= 80 then 'B'
          else 'C' end) as GRADE, 
    (case when AVG(g.score) >= 96 then e.sal * 0.2
          when AVG(g.score) >= 90 then e.sal * 0.15
          when AVG(g.score) >= 80 then e.sal * 0.1
          else 0 end) as BONUS
from 
    HR_EMPLOYEES as e
    join HR_DEPARTMENT as d on e.dept_id=d.dept_id
    join HR_GRADE as g on e.emp_no=g.emp_no
group by  
    e.emp_no
order by
    e.emp_no
