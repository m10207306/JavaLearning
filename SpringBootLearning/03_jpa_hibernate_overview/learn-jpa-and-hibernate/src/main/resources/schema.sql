-- 創建 H2 中的 table, 名稱好像一定要事 schema.sql 

CREATE TABLE course
(
    id BIGINT NOT NULL,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);
