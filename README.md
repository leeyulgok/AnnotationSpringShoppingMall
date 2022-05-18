# AnnotationSpringShoppingMall

목적: Spring Annotation을 활용한 스프링 쇼핑몰 제작.

제작기간 : 21일

사용한 툴 : Spring Tools Suite4 (Maven Project)

사용한 언어 : JAVA, HTML, CSS, JSP, JAVASCRIPT, JQUERY

사용한 데이터베이스 : MYSQL

데이터베이스 Tools : Sequal Pro

사용한 테이블 4개
1. 구매내역
  CREATE TABLE BUYLIST(
    BUYNUMBER INT PRIMARY KEY AUTO_INCREMENT,
    CART_NUMBER VARCHAR(10), // 장바구니
    SEQ INT, // 여기서부터 EMAIL까진 회원가입 내용
    ID VARCHAR(30),
    NAME VARCHAR(20),
    ADDRESS VARCHAR(100),
    PHONE VARCHAR(20),
    EMAIL VARCHAR(100),
    P_NUMBER VARCHAR(10), // 여기서부터 PRICE까진 제품 내용
    P_NAME VARCHAR(100),
    IMAGEPATH VARCHAR(300),
    IMAGENAME VARCHAR(300),
    PRICE INT,
    BUYDATE TIMESTEMP DEFAULT CURRENT_TIMESTEMP,
    FOREIGN KEY (SEQ) REFERENCES SIGNUP (SEQ) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (P_NUMBER) REFERENCES PRODUCT (P_NUMBER) ON UPDATE CASCADE ON DELETE CASCADE
  ); 
2. 장바구니 
  CREATE TABLE CART(
    CART_NUMBER VARCHAR(10) PRIMARY KEY,
    IMAGEPATH VARCHAR(300), // 여기서부터 PRICE까진 제품내용
    IMAGENAME VARCHAR(300),
    SEQ INT, // 여긴 회원가입 내용
    P_NUMBER VARCHAR(10),
    P_NAME VARCHAR(100), 
    PRICE INT,
    COUNT INT,
  ); 
3. 제품
  CREATE TABLE PRODUCT(
    P_NUMBER VARCHAR(10) PRIMARY KEY,
    P_NAME VARCHAR(100),
    TYPE VARCHAR(100),
    PRICE INT,
    SIZE VARCHAR(10),
    CONTENT VARCHAR(300),
    SALE INT,
    FILEPATH VARCHAR(300),
    FILENAME VARCHAR(300),
    HIT INT,
    REGDATE TIMESTMEP DEFAULT CURRENT_TIMESTMEP,
    TOTALSALE INT,
  ); 
4. 회원가입
  CREATE TABLE BUYLIST(
    SEQ INT PRIMARY KEY,
    NAME VARCHAR(20),
    ID VARCHAR(30),
    PASSWORD VARCHAR(40),
    PASSWORDCHECK VARCHAR(40),
    ADDRESS VARCHAR(100),
    PHONE VARCHAR(20),
    EMAIL VARCHAR(100),
  ); 
  
마치며.
결제 API는 따로 구매하여 적용을 해야해서 무리였다.
이번 쇼핑몰은 사전 설계없이 진행하여 꽤나 수정을 많이 했다.
다음에는 DB와 설계를 정확하게 해서 수정하는 시간을 줄이도록 해야겠다.

또한 디테일적인 측면에서 아직 많이 부족한 것 같다. 최대한 기능 위주로 만드는데 급급해서 놓친 부분이 아주 많다.
시간이 되면 공부를 더 해서 수정하는 시간을 갖도록 해야겠다.
