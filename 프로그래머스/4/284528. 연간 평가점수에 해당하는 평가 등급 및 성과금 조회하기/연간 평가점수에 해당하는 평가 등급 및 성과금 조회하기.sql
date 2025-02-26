-- 코드를 작성해주세요
 
select 
    e.emp_no as EMP_NO, 
    e.emp_name as EMP_NAME, 
    GRADES.GRADE, 
    case when GRADES.GRADE ='S' then e.sal * 0.2
          when GRADES.GRADE ='A' then e.sal * 0.15
          when GRADES.GRADE ='B' then e.sal * 0.1
          else 0 end as BONUS
from 
    HR_EMPLOYEES as e
    join 
        (select g.emp_no, 
            case when AVG(g.score) >= 96 then 'S'
              when AVG(g.score) >= 90 then 'A'
              when AVG(g.score) >= 80 then 'B'
              else 'C' end as GRADE 
         from HR_GRADE as g
         group by g.emp_no) as GRADES
    on e.emp_no=GRADES.emp_no
group by  
    e.emp_no
order by
    e.emp_no