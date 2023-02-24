SELECT *
FROM NUTRIENT_LIMIT_DB_NEW

CREATE TABLE user_info
(
user_id varchar2(15) NOT NULL,
user_pw varchar2(20) NOT NULL,
user_name varchar2(20) NOT NULL,
user_phone varchar2(13) NOT NULL,
RESIDENT_ID varchar2(14) NOT NULL, 
CONSTRAINT pk_user_info PRIMARY key(user_id)
)

SELECT *
FROM MEMBER_INFO

SELECT *
FROM PROCESSED_FOOD

SELECT *
FROM NUTRIENT

-- 해당 음식 이름의 음식 코드 알기
SELECT FOOD_CODE, FOOD_NAME 
FROM processed_food
WHERE FOOD_NAME  = '(정)땅콩맛전병'

-- 단위 확인해서 가지고오기
SELECT UNIT
FROM NUTRIENT n
WHERE FOOD_CODE = 'P053364'

-- 단위가 g 이면 이 쿼리문 실행
SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_G, n.PORTION_SIZE, n."Kcal" 
FROM processed_food p, NUTRIENT n
WHERE p.FOOD_CODE = n.FOOD_CODE AND n.FOOD_CODE = 'P053364'

GROUP BY MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.PORTION_SIZE, n."Kcal" 

-- 단위가 ml 이면 이 쿼리문 실행
SELECT MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_ML, n.PORTION_SIZE, n."Kcal" 
FROM processed_food p, NUTRIENT n
WHERE p.FOOD_CODE = n.FOOD_CODE AND FOOD_NAME  = '새우깡'

GROUP BY MANUFACTURER, FOOD_NAME, BIG_CTG, DETAIL_CTG, n.TOTAL_G, n.TOTAL_ML, n.UNIT, n."Kcal"

WHERE BIG_CTG = '모조치즈'
ORDER BY FOOD_NAME

SELECT FOOD_CODE , FOOD_NAME , DETAIL_CTG, MANUFACTURER , n."Kcal"
FROM PROCESSED_FOOD p, NUTRIENT n
WHERE p.FOOD_CODE = n.FOOD_CODE AND FOOD_NAME LIKE '%새우%'


SELECT *
FROM PROCESSED_FOOD p, NUTRIENT n
WHERE p.FOOD_CODE = n.FOOD_CODE

WHERE BIG_CTG = '과자'

ORDER BY big_ctg

ORDER BY FOOD_NAME

SELECT count('과자') FROM PROCESSED_FOOD where Big_ctg

SELECT FOOD_CODE, "Kcal" 
FROM NUTRIENT
WHERE FOOD_CODE = 'P048557'

SELECT pf.food_code, food_name, pf.DETAIL_CTG, pf.MANUFACTURER, n."Kcal" 
FROM PROCESSED_FOOD pf, NUTRIENT n
WHERE pf.food_code = n.FOOD_CODE AND pf.BIG_CTG = '가공두부' AND rownum BETWEEN 1 AND 5 
ORDER BY FOOD_NAME

SELECT ROWnum, TB.*
FROM (SELECT pf.food_code, food_name, pf.DETAIL_CTG, pf.MANUFACTURER, n."Kcal" 
FROM PROCESSED_FOOD pf, NUTRIENT n
ORDER BY food_name) tb

SELECT *
FROM (SELECT pf.food_code, food_name, pf.DETAIL_CTG, pf.MANUFACTURER, n."Kcal" 
FROM PROCESSED_FOOD pf, NUTRIENT n
WHERE pf.food_code = n.FOOD_CODE AND pf.BIG_CTG = '가공두부'
ORDER BY FOOD_NAME)
WHERE rownum BETWEEN 1 AND 10

SELECT *
FROM NUTRIENT
WHERE  FOOD_CODE = 'P010002' 

or FOOD_CODE = 'P053364' or FOOD_CODE = 'KorName'

SELECT *
FROM NUTRIENT
WHERE FOOD_CODE = 'P084743' OR FOOD_CODE = 'KorName'

SELECT *
FROM NUTRIENT_DIETARY_REFERENCE ndr 

ALTER TABLE NUTRIENT MODIFY food_code NOT NULL

CREATE TABLE member_info
(
id varchar2(20) NOT NULL,
pwd varchar2(20) NOT NULL,
email varchar2(320) NOT NULL,
name varchar2(20) NOT NULL,
gender varchar2(3) NOT NULL,
barth varchar2(6) NOT NULL, 
CONSTRAINT pk_member_info PRIMARY key(id)
)

ALTER TABLE NUTRIENT MODIFY ("Caffeine_mg" VARCHAR2(100));

select * from v$version

SELECT pf.MANUFACTURER, pf.FOOD_NAME, h.AMOUNT, h.KCAL 
FROM MEMBER_NUTRIENT_HISTORY h, PROCESSED_FOOD pf
WHERE h.FOOD_CODE = pf.FOOD_CODE AND id = 'shg' AND YMD = '20230113'

WHERE id = 'shg'

-- 정규식 함수를 사용하여 숫자 외 문자들 제거. 섭취량 합 계산 시 사용
SELECT sum(REGEXP_REPLACE(AMOUNT, '[^0-9.-]', '')) AS sum
FROM MEMBER_ADD_NUTRIENT
WHERE YMD = '20230112' AND id = 'sth'

-- number 타입인 칼로리 계산시 사용
SELECT sum(kcal) AS sum
FROM MEMBER_NUTRIENT_HISTORY
WHERE YMD = '20230112' AND id = 'sth'

-- varchar2 타입인 영양소들 계산시 사용
SELECT sum(TO_NUMBER(NUTRY1))AS sum
FROM MEMBER_NUTRIENT_HISTORY
WHERE YMD = '20230112' AND id = 'sth'

--delete FROM MEMBER_ADD_NUTRIENT
--WHERE id = 'sth'

SELECT * 
FROM MEMBER_INFO

WHERE ID = 'sth'

SELECT distinct

SELECT KCAL 
FROM NUTRIENT_DIETARY_REFERENCE
WHERE GENDER = '여' AND AGE = '32'

OR gender = '성별'

SELECT * 
FROM NUTRIENT
WHERE food_code = 'KorName'

SELECT * 
FROM NUTRIENT_DIETARY_REFERENCE

WHERE nd.GENDER = '성별' AND nd.AGE = '나이'

INSERT INTO MEMBER_ADD_NUTRIENT 
VALUES ('성별', '나이', 0, '수분(g)', '단백질(g)','지방(g)', '탄수화물(g)', '총당류(g)', '포도당(g)', '과당(g)', '당알콜(g)', '에리스리톨(g)', '총 식이섬유(g)', '칼슘(㎎)', '철(㎎)', '마그네슘(㎎)', '인(㎎)', '칼륨(㎎)', '나트륨(㎎)', '아연(㎎)', '구리(㎎)', '구리(㎍)', '망간(㎎)', '망간(㎍)', '셀레늄(㎍)', '요오드(㎍)', '	염소(㎎)', '비타민 A(㎍ RE)', '베타카로틴(㎍)', '비타민 D(D2+D3)(㎍)', '비타민 D3(㎍)', '비타민 D1(㎍)	', '비타민 E(㎎)', '비타민 E(㎎ α-TE)', '비타민 K(㎎)', '비타민 K(㎍)', '	비타민 K1(㎍)', '비타민 K2(㎍)', '비타민 B1(㎎)', '비타민 B1(㎍)', '비타민 B2(㎎)', '비타민 B2(㎍)', '나이아신(㎎ NE)', '판토텐산(㎎)', '판토텐산(㎍)', '비타민 B6(㎎)', '비타민 B6(㎍)', '비오틴(㎍)', '엽산(DFE)(㎍)', '비타민 B12(㎎)', '비타민 B12(㎍)', '비타민 C(g)', '비타민 C(㎎)', '콜린(㎎)', '류신(㎎)', '트립토판(㎎)', '	히스티딘(㎎)', '아르기닌(㎎)', '시스테인(㎎)', '프롤린(㎎)', '타우린(㎎)', '콜레스테롤(g)', '콜레스테롤(㎎)', '총 포화 지방산(g)', '리놀레산(18:2(n-6)c)(g)', '알파 리놀렌산(18:3(n-3))(㎎)', '감마 리놀렌산(18:3(n-6))(㎎)', '아라키돈산(20:4(n-6))(㎎)', '	에이코사펜타에노산(20:5(n-3))(㎎)', '도코사헥사에노산(22:6(n-3))(㎎)', 'EPA와 DHA의 합(㎎)', '오메가 3 지방산(g)', '트랜스 지방산(g)', '총 불포화지방산(g)', '회분(g)', '카페인(㎎)')

INSERT INTO NUTRIENT_DIETARY_REFERENCE
VALUES ('성별', '나이', 0, '수분(g)', '단백질(g)','지방(g)', '탄수화물(g)', '총당류(g)', '포도당(g)', '과당(g)', '당알콜(g)', '에리스리톨(g)', '총 식이섬유(g)', '칼슘(㎎)', '철(㎎)', '마그네슘(㎎)', '인(㎎)', '칼륨(㎎)', '나트륨(㎎)', '아연(㎎)', '구리(㎎)', '구리(㎍)', '망간(㎎)', '망간(㎍)', '셀레늄(㎍)', '요오드(㎍)', '	염소(㎎)', '비타민 A(㎍ RE)', '베타카로틴(㎍)', '비타민 D(D2+D3)(㎍)', '비타민 D3(㎍)', '비타민 D1(㎍)	', '비타민 E(㎎)', '비타민 E(㎎ α-TE)', '비타민 K(㎎)', '비타민 K(㎍)', '	비타민 K1(㎍)', '비타민 K2(㎍)', '비타민 B1(㎎)', '비타민 B1(㎍)', '비타민 B2(㎎)', '비타민 B2(㎍)', '나이아신(㎎ NE)', '판토텐산(㎎)', '판토텐산(㎍)', '비타민 B6(㎎)', '비타민 B6(㎍)', '비오틴(㎍)', '엽산(DFE)(㎍)', '비타민 B12(㎎)', '비타민 B12(㎍)', '비타민 C(g)', '비타민 C(㎎)', '콜린(㎎)', '류신(㎎)', '트립토판(㎎)', '	히스티딘(㎎)', '아르기닌(㎎)', '시스테인(㎎)', '프롤린(㎎)', '타우린(㎎)', '콜레스테롤(g)', '콜레스테롤(㎎)', '총 포화 지방산(g)', '리놀레산(18:2(n-6)c)(g)', '알파 리놀렌산(18:3(n-3))(㎎)', '감마 리놀렌산(18:3(n-6))(㎎)', '아라키돈산(20:4(n-6))(㎎)', '	에이코사펜타에노산(20:5(n-3))(㎎)', '도코사헥사에노산(22:6(n-3))(㎎)', 'EPA와 DHA의 합(㎎)', '오메가 3 지방산(g)', '트랜스 지방산(g)', '총 불포화지방산(g)', '회분(g)', '카페인(㎎)')

INSERT INTO NUTRIENT
VALUES ('KorName', 0, '단위', '총내용량(g)', '총내용량(mL)', 0,'수분(g)','단백질(g)','지방(g)', '탄수화물(g)', '총당류(g)', '포도당(g)', '과당(g)', '당알콜(g)', '에리스리톨(g)', '총 식이섬유(g)', '칼슘(㎎)', '철(㎎)', '마그네슘(㎎)', '인(㎎)', '칼륨(㎎)', '나트륨(㎎)', '아연(㎎)', '구리(㎎)', '구리(㎍)', '망간(㎎)', '망간(㎍)', '셀레늄(㎍)', '요오드(㎍)', '	염소(㎎)', '비타민 A(㎍ RE)', '베타카로틴(㎍)', '비타민 D(D2+D3)(㎍)', '비타민 D3(㎍)', '비타민 D1(㎍)	', '비타민 E(㎎)', '비타민 E(㎎ α-TE)', '비타민 K(㎎)', '비타민 K(㎍)', '	비타민 K1(㎍)', '비타민 K2(㎍)', '비타민 B1(㎎)', '비타민 B1(㎍)', '비타민 B2(㎎)', '비타민 B2(㎍)', '나이아신(㎎ NE)', '판토텐산(㎎)', '판토텐산(㎍)', '비타민 B6(㎎)', '비타민 B6(㎍)', '비오틴(㎍)', '엽산(DFE)(㎍)', '비타민 B12(㎎)', '비타민 B12(㎍)', '비타민 C(g)', '비타민 C(㎎)', '콜린(㎎)', '류신(㎎)', '트립토판(㎎)', '	히스티딘(㎎)', '아르기닌(㎎)', '시스테인(㎎)', '프롤린(㎎)', '타우린(㎎)', '콜레스테롤(g)', '콜레스테롤(㎎)', '총 포화 지방산(g)', '리놀레산(18:2(n-6)c)(g)', '알파 리놀렌산(18:3(n-3))(㎎)', '감마 리놀렌산(18:3(n-6))(㎎)', '아라키돈산(20:4(n-6))(㎎)', '	에이코사펜타에노산(20:5(n-3))(㎎)', '도코사헥사에노산(22:6(n-3))(㎎)', 'EPA와 DHA의 합(㎎)', '오메가 3 지방산(g)', '트랜스 지방산(g)', '총 불포화지방산(g)', '회분(g)', '카페인(㎎)')

INSERT INTO NUTRIENT
VALUES ('EngName', 0, 'UNIT', 'TOTAL_G', 'TOTAL_ML', 0,'Moisture','Protein_g','Fat_g', 'Carbs_g', 'Total_Sugars_g', 'Glucose_g', 'Fruit_Sugar_g', 'Sugar_Alcohol_g', 'Erythritol_g', 'Total_Dietary_Fiber_g', 'Calcium_mg', 'Iron_mg', 'Magnesium_mg', 'Phosphorus_mg', 'Potassium_mg', 'Salt_mg', 'Spelter_mg', 'Cuprum_mg', 'Cuprum', 'Manganese_mg', 'Manganese', 'Selenium', 'Iodine', 'Chlorine_mg', 'VitaminA', 'Bata_Carotene', 'VitaminD', 'VitaminD3', 'VitaminD1	', 'VitaminE_mg', 'VitaminE_mg_TE', 'VitaminK_mg', 'VitaminK', 'VitaminK1', 'VitaminK2', 'VitaminB1_mg', 'VitaminB1', 'VitaminB2_mg', 'VitaminB2', 'Niacin_mg', 'Pantothenic_Acid_mg', 'Pantothenic_Acid', 'VitaminB6_mg', 'VitaminB6', 'Biotin', 'Folic_Acid', 'VitaminB12_mg', 'VitaminB12', 'VitaminC_g', 'VitaminC_mg', 'Choline_mg', 'Leucine_mg', 'Tryptophan_mg', '	Histidine_mg', 'Arginine_mg', 'Cysteine_mg', 'Proline_mg', 'Taurine_mg', 'Cholesterol_g', 'Cholesterol_mg', 'Total_Saturated_Fatty_Acids_g', 'Linoleic_Acid_g', 'Alpa_Linoleic_Acid_mg', 'Gamma_Linoleic_Acid_mg', 'Arachidonic_Acid_mg', 'Eicosapentaenoic_Acid_mg', 'Docosahexaenoic_mg', 'Sum_Of_EPA_And_DHA_mg', 'Omega3_Fatty_Acids_g', 'Trans_Fatty_Acids_g', 'Total_Unsaturated_Fatty_Acids_g', 'Ash_g', 'Caffeine_mg')

INSERT INTO Member_info VALUES ('sth', '123456', 'sth@naver.com', '신태현', '남', '030625')