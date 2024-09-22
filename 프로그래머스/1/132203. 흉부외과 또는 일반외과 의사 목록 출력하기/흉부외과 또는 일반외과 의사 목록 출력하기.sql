-- 코드를 입력하세요
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, "%Y-%m-%d") AS HIRE_YMD #날짜 포멧을 사용하여 'HIRE_YMD'으로 HIRE_YMD를 %Y-%m-%d포멧으로 넣어줌.
FROM DOCTOR 
WHERE MCDP_CD = 'CS' OR MCDP_CD = 'GS' 
order by HIRE_YMD DESC, DR_NAME;